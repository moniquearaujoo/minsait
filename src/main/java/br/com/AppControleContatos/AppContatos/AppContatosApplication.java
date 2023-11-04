package br.com.AppControleContatos.AppContatos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@EntityScan(basePackages = "br.com.AppControleContatos.AppContatos.model")
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class AppContatosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppContatosApplication.class, args);
	}

}
