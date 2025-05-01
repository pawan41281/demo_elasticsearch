package com.example.demo_elasticsearch.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfiguration {

	@Bean
	OpenAPI defineOpenApi() {
		Server localhost = new Server();
		localhost.setUrl("http://localhost:8080");
		localhost.setDescription("Development");

//		Server vm_4_213_142_244 = new Server();
//		vm_4_213_142_244.setUrl("http://4.213.142.244:8080");
//		vm_4_213_142_244.setDescription("vm_4_213_142_244");

		Contact myContact = new Contact();
		myContact.setName("Pawan Kumar");
		myContact.setEmail("pawan.kumar@gmail.com");

		Info information = new Info()
								.title("Employee API")
								.version("1.0")
								.description("This API exposes endpoints to manage employees.")
								.contact(myContact)
								.license(new License().name("Apache 2.0").url("http://springdoc.org"));
		
//								.externalDocs(new ExternalDocumentation().description("SpringBoot Wiki Documentation").url("https://springboot.wiki.github.org/docs"))
				
//		return new OpenAPI().info(information).servers(List.of(localhost,vm_4_213_142_244));
		
		return new OpenAPI().info(information).servers(List.of(localhost));
	}

}
