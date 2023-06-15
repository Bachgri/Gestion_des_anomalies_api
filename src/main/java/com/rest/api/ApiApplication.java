package com.rest.api;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.rest.api.entity.Client;
import com.rest.api.service.AccountService; 

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
		
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	CommandLineRunner start(AccountService accs) {
		return args ->{
			/*accs.addRole(new ClientRole(null, "USER"));
			accs.addRole(new ClientRole(null, "ADMIN"));
			accs.addRole(new ClientRole(null, "CUSTOMMER_MANAGER"));
			accs.addRole(new ClientRole(null, "PRODUCT_MANAGER"));
			accs.addRole(new ClientRole(null, "BILLS_MANAGER"));
			accs.addClient(new Client(null, "admin", "admin", "admin15963", "admin@gmail.com", "0622115470", "adress", new ArrayList<>()));
			accs.addClient(new Client(null, "user", "user", "user15963", "user@gmail.com", "0622115470", "adress", new ArrayList<>()));
			accs.addClient(new Client(null, "costumer", "costumer", "costumer15963", "costumer@gmail.com", "0622115470", "adress", new ArrayList<>()));
			accs.addClient(new Client(null, "products", "product", "product15963", "product@gmail.com", "0622115470", "adress", new ArrayList<>()));
			accs.addClient(new Client(null, "bill", "bill", "bill15963", "bill@gmail.com", "0622115470", "adress", new ArrayList<>()));*/
			/*for (Client c : accs.listClients()) {
				System.out.println(c);
			}*/
			//accs.addRolToUser("admin", "ADMIN");
			//System.out.println(accs.loadUserByUserName("admin")); 
			//accs.addRolToUser("user", "USER");  
			//System.out.println(accs.loadUserByUserName("user"));
			
			System.out.println("--------------------------------------**--------------------------------------------");
			for (Client c : accs.listClients()) {
				System.out.println(c);
			}
		};
	}

}
