package com.bits.mtech.ss.dbms.vfs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VfsApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(VfsApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(VfsApplication.class, args);
	}

	@Override
    public void run(String... args) {

        log.info("StartApplication...");
	}
}
