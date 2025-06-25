package com.example.springkadaiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springkadaiform.form.ContactForm;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("contactForm")
public class ContactFormController {

    @ModelAttribute("contactForm")
    public ContactForm setupForm() {
        return new ContactForm();
    }

    @GetMapping("/form")
    public String showForm() {
        return "contactFormView";
    }

    @PostMapping("/confirm")
    public String confirm(@ModelAttribute("contactForm") @Valid ContactForm contactForm,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            // エラーメッセージを一時的に引き継ぐ
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.contactForm", bindingResult);
            redirectAttributes.addFlashAttribute("contactForm", contactForm);
            return "redirect:/form"; // ✅ リダイレクト
        }
        return "confirmView";
    }
}