package com.transportation.app.seeding;

import com.transportation.app.com.transportation.app.models.Drone;
import com.transportation.app.com.transportation.app.models.Medications;
import com.transportation.app.com.transportation.app.models.Model;
import com.transportation.app.com.transportation.app.models.States;
import com.transportation.app.repository.DroneRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
public class Config {
    @Bean
    public CommandLineRunner commandLineRunner(DroneRepository droneRepository){
        return args -> {
          var d1=  new Drone(
                  6L,4l,
                  Model.Cruiserweight,
                  "97kg",
                  "10%",
                  States.DELIVERED,
                  List.of(new Medications("parastamo",
                          3L,"AGFGH_L","jjdhch", new Drone(6L))));
            var d2=  new Drone(1L,
                    2L,
                    Model.Heavyweight,
                    "99kg",
                    "10%",
                    States.LOADED, List.of(new Medications("parastamo",
                    3L,"AFGGHHHH_","jnjdhdlj", new Drone(1L))));
            var obj=  List.of(d1,d2);
           // droneRepository.saveAll(obj);

        };
    }
}
