package com.lti.actuatordemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	/** @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
	 
	    }*/
	 
	 @SuppressWarnings("deprecation")
	@Bean
	 public UserDetailsService userDetaisService() {
		 
		 User.UserBuilder users= User.withDefaultPasswordEncoder();
		 InMemoryUserDetailsManager manager= new InMemoryUserDetailsManager();
		 manager.createUser(users.username("admin").password("admin").roles("USER","ADMIN").build());
		 return manager;
	 }

}
