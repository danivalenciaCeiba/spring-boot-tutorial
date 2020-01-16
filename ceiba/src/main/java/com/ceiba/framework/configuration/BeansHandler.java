package com.ceiba.framework.configuration;

import com.ceiba.application.builder.PersonBuilder;
import com.ceiba.application.command.PersonCommand;
import com.ceiba.application.handler.PersonHandler;
import com.ceiba.domain.repository.PersonRepository;
import com.ceiba.domain.repository.UserRepository;
import com.ceiba.domain.service.PersonService;
import com.ceiba.domain.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class BeansHandler extends WebSecurityConfigurerAdapter {
   
    @Autowired
    private UserService uService;

    @Autowired
    private BCryptPasswordEncoder bCrypt;

    @Bean
    public PersonService personService(PersonRepository personRepository) {
        return new PersonService(personRepository);
    }

    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserService(userRepository);
    }

    @Bean
    public PersonCommand PersonCommand() {
        return new PersonCommand();
    }

    @Bean
    public PersonBuilder personBuilder() {
        return new PersonBuilder();
    }

    @Bean
    public PersonHandler personHandler(PersonService personService, PersonBuilder personBuilder) {
        return new PersonHandler(personService, personBuilder);
    }

    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(uService).passwordEncoder(bCrypt);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
        .anyRequest()
        .authenticated()
        .and()
        .httpBasic();
    }
}