package com.greyflame.bluetrail;

import com.greyflame.bluetrail.persistence.LongDistanceTrail;
import com.greyflame.bluetrail.persistence.LongDistanceTrailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BluetrailController {

    @GetMapping("/bluetrail")
    public String greetingForm(Model model) {
        if (ldTrail == null) {
            ldTrail = ldtRepository.findByForeignNameKey("blue.trail").get(0);
        }

        model.addAttribute("bluetrailDisplayContext", new BluetrailDisplayContext(ldTrail));
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

    @Autowired
    private LongDistanceTrailRepository ldtRepository;

    private LongDistanceTrail ldTrail;
}