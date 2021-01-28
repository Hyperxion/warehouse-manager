package com.edemko.warehousemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class WarehouseManagerApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(WarehouseManagerApplication.class, args);
	}

}
