package com.greyflame.bluetrail.config;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greyflame.bluetrail.persistence.BusStop;
import com.greyflame.bluetrail.persistence.LongDistanceTrail;
import com.greyflame.bluetrail.persistence.LongDistanceTrailRepository;
import com.greyflame.bluetrail.persistence.StampPoint;
import com.greyflame.bluetrail.persistence.TrailSection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StartupBean implements InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(StartupBean.class);

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("Initializing Blue Trail Planner application.");

        fillDatabase();
    }

    private void fillDatabase() throws JsonParseException, JsonMappingException, IOException {

        if (ldtRepository.count() == 0) {
            //create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            //read json file and convert to customer object
            LongDistanceTrail longDistanceTrail = 
                objectMapper.readValue(new File("src/main/resources/json/bluetrail.json"), LongDistanceTrail.class);

            logger.info("Adding " + longDistanceTrail.getOriginalName());
            for(TrailSection section: longDistanceTrail.getTrailSections()) {
                logger.info("Reading " + section.getOfficialId());
                section.setLongDistanceTrail(longDistanceTrail);

                for (StampPoint stampPoint: section.getStampPoints()) {
                    logger.info("Reading " + stampPoint.getName());
                    stampPoint.setTrailSection(section);

                    BusStop busStop = stampPoint.getBusStop();
                    busStop.setStampPoint(stampPoint);
                }
            }

            ldtRepository.save(longDistanceTrail);

            logger.info(longDistanceTrail.getOriginalName() + " added to database.");
        }
    }

    @Autowired
    private LongDistanceTrailRepository ldtRepository;
}
