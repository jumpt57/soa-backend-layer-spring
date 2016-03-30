package soa.backend.layer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class Application extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	protected void configure(HttpSecurity http) {
		try {
			http.csrf().disable().authorizeRequests()
					.antMatchers("/css/**", "/js/**", "/img/**", "/fonts/**", "/reponse").permitAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
