package com.mgr.pickMeCar.db.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/admin/**").permitAll()
            .antMatchers("/register/**").permitAll()
            .antMatchers("/rest-api/**").permitAll()
            .antMatchers("/**").access("hasRole('ROLE_ADMIN')")
            
//            .anyRequest().permitAll()
            .and()
              .formLogin().loginPage("/login").permitAll()
              .usernameParameter("username").passwordParameter("password")
            .and()
              .logout().logoutSuccessUrl("/login?logout") 
             .and()
             .exceptionHandling().accessDeniedPage("/403")
            .and()
              .csrf();
       
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
      web.ignoring().antMatchers("/webjars/**").antMatchers("/css/**");
    }
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {    
   	 auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
    } 
    @Bean(name="passwordEncoder")
    public PasswordEncoder passwordencoder(){
     return new BCryptPasswordEncoder();
    }
    

}