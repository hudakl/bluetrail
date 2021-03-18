package com.greyflame.bluetrail;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import com.greyflame.bluetrail.display.BluetrailDisplayContext;
import com.greyflame.bluetrail.display.BluetrailPlannerModel;
import com.greyflame.bluetrail.itinerary.ItineraryPlanner;
import com.greyflame.bluetrail.persistence.LongDistanceTrail;
import com.greyflame.bluetrail.persistence.LongDistanceTrailRepository;
import com.greyflame.bluetrail.persistence.StampPoint;
import com.greyflame.bluetrail.persistence.StampPointRepository;
import com.greyflame.bluetrail.persistence.TrailSection;
import com.greyflame.bluetrail.persistence.TrailSectionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BluetrailController {

    @GetMapping("/bluetrail")
    public String greetingForm(Model model) {
        if (ldTrail == null) {
            ldTrail = ldtRepository.findByForeignNameKey("blue.trail").get(0);
        }

        BluetrailDisplayContext bluetrailDisplayContext = new BluetrailDisplayContext(ldTrail); 

        model.addAttribute("bluetrailDisplayContext", bluetrailDisplayContext);
        model.addAttribute("bluetrailPlannerModel", new BluetrailPlannerModel(
            bluetrailDisplayContext.getStartPoint(), 
            bluetrailDisplayContext.getEndPoint(), 
            bluetrailDisplayContext.getHikeDay())
        );
        return "bluetrail";
    }

    @PostMapping("/routeplanning")
    public String routePlanning(
            @ModelAttribute 
            BluetrailPlannerModel bluetrailPlannerModel, 
            
            Model model) {

        int startNum = bluetrailPlannerModel.getStartPoint();
        int endNum = bluetrailPlannerModel.getEndPoint();
        boolean westward = startNum > endNum;
        Date hikeDay = bluetrailPlannerModel.getHikeDay();

        System.out.println(bluetrailPlannerModel);

        LinkedList<StampPoint> stampPoints = new LinkedList<StampPoint>();
        
        if (westward) {
            stampPoints.addAll(stampPointRepository.findByNumberBetween(endNum, startNum));
            Collections.reverse(stampPoints);
        }
        else {
            stampPoints.addAll(stampPointRepository.findByNumberBetween(startNum, endNum));
        }

        System.out.println(stampPoints);
        ItineraryPlanner itineraryPlanner = new ItineraryPlanner(stampPoints, westward);
        System.out.println("Distance: " + itineraryPlanner.getAllDistance());
        System.out.println("Time: " + itineraryPlanner.getAllTime());
        System.out.println("Elevation: " + itineraryPlanner.getAllElevation());

        if (!stampPoints.isEmpty()) {
            BluetrailDisplayContext bluetrailDisplayContext = 
                new BluetrailDisplayContext(
                    ldTrail, stampPoints.getFirst(), stampPoints.getLast(), 
                    bluetrailPlannerModel.getHikeDay());
            
            model.addAttribute("bluetrailDisplayContext", bluetrailDisplayContext);
        }
        else {
            model.addAttribute("bluetrailDisplayContext", new BluetrailDisplayContext(ldTrail));
        }
        
        model.addAttribute("bluetrailPlannerModel", new BluetrailPlannerModel(
            startNum, endNum, hikeDay)
        );

        return "bluetrail";
    }

    @RequestMapping("/sectionchange")
    @ResponseBody
    public Map<Integer, String> sectionChange(
        @RequestParam String section) {

        Map<Integer, String> response = new HashMap<Integer, String>();
        TrailSection trailSection = trailSectionRepository.findByOfficialId(section).get(0);

        for (StampPoint stamp: trailSection.getStampPoints()) {
            response.put(stamp.getNumber(), stamp.getName());
        }

        return response;
    }

    @Autowired
    private LongDistanceTrailRepository ldtRepository;

    @Autowired
    private TrailSectionRepository trailSectionRepository;

    @Autowired
    private StampPointRepository stampPointRepository;

    private LongDistanceTrail ldTrail;
}