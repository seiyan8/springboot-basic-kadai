package com.example.springkadaiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springkadaiform.form.ContactForm;

import jakarta.validation.Valid;

@Controller
public class ContactFormController {

    @GetMapping("/form")
    public String showForm(Model model) {
        // Flash属性にcontactFormがあるか確認し、なければ空フォームを追加
        if (!model.containsAttribute("contactForm")) {
            model.addAttribute("contactForm", new ContactForm());
        }
        return "contactFormView";
    }

    @PostMapping("/confirm")
    public String confirm(
            @Valid @ModelAttribute("contactForm") ContactForm contactForm,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            // バリデーションエラー時はフォームに戻し、エラー情報と入力値をFlash属性で保持する
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.contactForm", bindingResult);
            redirectAttributes.addFlashAttribute("contactForm", contactForm);
            return "redirect:/form";
        }

        // バリデーションOKなら確認画面へ遷移
        redirectAttributes.addFlashAttribute("contactForm", contactForm);
        return "redirect:/confirm";
    }

    @GetMapping("/confirm")
    public String showConfirm(@ModelAttribute("contactForm") ContactForm contactForm) {
        return "confirmView";
    }
}