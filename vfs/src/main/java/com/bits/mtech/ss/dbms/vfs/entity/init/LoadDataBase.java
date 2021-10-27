package com.bits.mtech.ss.dbms.vfs.entity.init;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bits.mtech.ss.dbms.vfs.entity.Vehicle;
import com.bits.mtech.ss.dbms.vfs.entity.repository.VehicleRepository;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(VehicleRepository vehicleRepository) {

    return args -> {
      log.info("Preloading {}", vehicleRepository.save(new Vehicle("CH-0567899", "RG-UP074567", new Date())));
      log.info("Preloading {}" ,vehicleRepository.save(new Vehicle("CH-879763536", "RG-TG089765", new Date())));
    };
  }
}