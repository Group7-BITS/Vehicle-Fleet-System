package com.bits.mtech.ss.dbms.vfs.entity.init;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bits.mtech.ss.dbms.vfs.entity.Vehicle;
import com.bits.mtech.ss.dbms.vfs.entity.repository.VehicleRepository;
import com.bits.mtech.ss.dbms.vfs.entity.Address;
import com.bits.mtech.ss.dbms.vfs.entity.User;
import com.bits.mtech.ss.dbms.vfs.entity.repository.AddressRepository;
import com.bits.mtech.ss.dbms.vfs.entity.repository.UserRepository;
import com.bits.mtech.ss.dbms.vfs.entity.UserRole;
import com.bits.mtech.ss.dbms.vfs.entity.repository.UserRoleRepository;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(VehicleRepository vehicleRepository,UserRepository userRepository, UserRoleRepository userRoleRepository,
		  AddressRepository addressRepository) {

    return args -> {
      log.info("Preloading {}", vehicleRepository.save(new Vehicle("CH-0567899", "RG-UP074567", new Date())));
      log.info("Preloading {}" ,vehicleRepository.save(new Vehicle("CH-879763536", "RG-TG089765", new Date())));
      log.info("Preloading {}", userRepository.save(new User("yogesh", "saini", "yk@gmail.com","7566004312","1")));
      log.info("Preloading {}" ,userRepository.save(new User("yks", "saini", "yk@gmail.com","7566004312","2")));
      log.info("Preloading {}", userRoleRepository.save(new UserRole("Customer")));
      log.info("Preloading {}" ,userRoleRepository.save(new UserRole("Vendor")));
      log.info("Preloading {}" ,addressRepository.save(new Address("41°24’12.2″N   2°10’26.5″E", "La Sagrada Familia, C. Mallorca, 401", "#415", "Barcelona", "08013", "SPAIN", "Opposit to Cake Shop")));
      
    };
    
  }
//  @Bean
//  CommandLineRunner initDatabase(UserRepository userRepository) {
//
//    return args -> {
//      log.info("Preloading {}", userRepository.save(new User("yogesh", "saini", "yk@gmail.com","7566004312","1")));
//      log.info("Preloading {}" ,userRepository.save(new User("yks", "saini", "yk@gmail.com","7566004312","2")));
//    };
//    
//  }
  
  
  
}