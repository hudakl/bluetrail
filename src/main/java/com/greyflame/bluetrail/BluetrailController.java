package com.greyflame.bluetrail;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BluetrailController {

    @GetMapping("/bluetrail")
    public String greetingForm(Model model) {
        model.addAttribute("bluetrail", new BluetrailDisplayContext());
        return "bluetrail";
    }

    @PostMapping("/routeplanning")
    public String routePlanning(
            @ModelAttribute 
            BluetrailDisplayContext bluetrailDisplayContext, 
            
            Model model) {

        model.addAttribute("bluetrailDisplayContext", bluetrailDisplayContext);
        return "result";
    }

}