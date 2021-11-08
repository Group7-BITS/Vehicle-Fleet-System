package com.bits.mtech.ss.dbms.vfs.entity.init;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bits.mtech.ss.dbms.vfs.entity.Vehicle;
import com.bits.mtech.ss.dbms.vfs.entity.VehicleInsurance;
import com.bits.mtech.ss.dbms.vfs.entity.repository.VehicleRepository;
import com.bits.mtech.ss.dbms.vfs.entity.Address;
import com.bits.mtech.ss.dbms.vfs.entity.Booking;
import com.bits.mtech.ss.dbms.vfs.entity.Driver;
import com.bits.mtech.ss.dbms.vfs.entity.LicenseTypeVehicleType;
import com.bits.mtech.ss.dbms.vfs.entity.Trip;
import com.bits.mtech.ss.dbms.vfs.entity.TripRoute;
import com.bits.mtech.ss.dbms.vfs.entity.User;
import com.bits.mtech.ss.dbms.vfs.entity.UserRole;
import com.bits.mtech.ss.dbms.vfs.entity.UserCredential;

import com.bits.mtech.ss.dbms.vfs.entity.VehicleLocation;
import com.bits.mtech.ss.dbms.vfs.entity.VehicleProblemType;
import com.bits.mtech.ss.dbms.vfs.entity.VehicleServices;
import com.bits.mtech.ss.dbms.vfs.entity.VehicleType;
import com.bits.mtech.ss.dbms.vfs.entity.VehicleVendor;

import com.bits.mtech.ss.dbms.vfs.entity.repository.AddressRepository;
import com.bits.mtech.ss.dbms.vfs.entity.repository.BookingRepository;
import com.bits.mtech.ss.dbms.vfs.entity.repository.DriverRepository;
import com.bits.mtech.ss.dbms.vfs.entity.repository.LicenseTypeVehicleTypeRepository;
import com.bits.mtech.ss.dbms.vfs.entity.repository.TripRepository;
import com.bits.mtech.ss.dbms.vfs.entity.repository.TripRouteRepository;
import com.bits.mtech.ss.dbms.vfs.entity.repository.UserCredentialRepository;
import com.bits.mtech.ss.dbms.vfs.entity.repository.UserRepository;

import com.bits.mtech.ss.dbms.vfs.entity.repository.UserRoleRepository;
import com.bits.mtech.ss.dbms.vfs.entity.repository.VehicleInsuranceRepository;

import com.bits.mtech.ss.dbms.vfs.entity.repository.VehicleLocationRepository;
import com.bits.mtech.ss.dbms.vfs.entity.repository.VehicleProblemTypeRepository;
import com.bits.mtech.ss.dbms.vfs.entity.repository.VehicleServicesRepository;
import com.bits.mtech.ss.dbms.vfs.entity.repository.VehicleTypeRepository;
import com.bits.mtech.ss.dbms.vfs.entity.repository.VehicleVendorRepository;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(VehicleRepository vehicleRepository,UserRepository userRepository, UserRoleRepository userRoleRepository,
		  AddressRepository addressRepository, BookingRepository bookingRepository, DriverRepository driverRepository,
		  LicenseTypeVehicleTypeRepository licenseTypeVehicletypeRepository, TripRepository tripRepository, 
		  TripRouteRepository tripRouteRepository, UserCredentialRepository userCredentialRepository,
		  VehicleInsuranceRepository vehicleInsuranceRepository, VehicleLocationRepository vehicleLocationRepository,
		  VehicleProblemTypeRepository vehicleProblemTypeRepository, VehicleServicesRepository vehicleServicesRepository, VehicleTypeRepository vehicleTypeRepository,
		  VehicleVendorRepository vehicleVendorRepository) {

    return args -> {
      log.info("Preloading {}", vehicleRepository.save(new Vehicle("CH-0567899", "RG-UP074567", new Date())));
      log.info("Preloading {}" ,vehicleRepository.save(new Vehicle("CH-879763536", "RG-TG089765", new Date())));
      log.info("Preloading {}", userRepository.save(new User("yogesh", "saini", "yk@gmail.com","7566004312","1")));
      log.info("Preloading {}" ,userRepository.save(new User("yks", "saini", "yk@gmail.com","7566004312","2")));
      log.info("Preloading {}", userRoleRepository.save(new UserRole("Customer")));
      log.info("Preloading {}" ,userRoleRepository.save(new UserRole("Vendor")));
      log.info("Preloading {}" ,addressRepository.save(new Address("41°24’12.2″N   2°10’26.5″E", "La Sagrada Familia, C. Mallorca, 401", "#415", "Barcelona", "08013", "SPAIN", "Opposit to Cake Shop")));
      log.info("Preloading {}" ,bookingRepository.save(new Booking("SPAIN", "AUSTRIA", new Date(1636310839), "customer-145", "driver-444", "TBVGU", "PENDING")));
      log.info("Preloading {}" ,driverRepository.save(new Driver(new Date(1636310839), new Date(1736310899), "INTERSTATE")));
      log.info("Preloading {}" ,licenseTypeVehicletypeRepository.save(new LicenseTypeVehicleType("COUNTRY", "4-WHEEL")));
      log.info("Preloading {}" ,tripRepository.save(new Trip(new Date(1636311082), new Date(1646311082), 18299.00, "It is a smooth experience", "36/2, 8th Cross Rd, R K Colony, 2nd Phase, J. P. Nagar, Bengaluru, Karnataka 560078", "Outer Ring Road Manyata - Embassy Business Park, Block E, Bengaluru, Karnataka 560045")));
      log.info("Preloading {}" ,tripRouteRepository.save(new TripRoute("41°24’12.2″N   2°10’26.5″E")));
      log.info("Preloading {}" ,userCredentialRepository.save(new UserCredential("iweuryiweurihei9738473dsd", "key")));
      log.info("Preloading {}" ,vehicleInsuranceRepository.save(new VehicleInsurance(new Date(1636311082), new Date(1646311082))));
      log.info("Preloading {}", vehicleLocationRepository.save(new VehicleLocation("1","41°24’12.2″N   2°10’26.5″E")));
      log.info("Preloading {}", vehicleProblemTypeRepository.save(new VehicleProblemType("T1","Engine Problem")));
      log.info("Preloading {}", vehicleServicesRepository.save(new VehicleServices("1", new Date(1646311082),"Customer","Customer","Customer")));
      log.info("Preloading {}", vehicleTypeRepository.save(new VehicleType("2BHK","1-Ton")));
      log.info("Preloading {}", vehicleVendorRepository.save(new VehicleVendor("1","2")));
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