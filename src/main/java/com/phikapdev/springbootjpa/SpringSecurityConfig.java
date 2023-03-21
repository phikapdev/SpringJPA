package com.phikapdev.springbootjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.phikapdev.springbootjpa.auth.handler.LoginSucessHandler;

@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Configuration
public class SpringSecurityConfig{

    @Autowired
    private LoginSucessHandler successHandler;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

       http.authorizeRequests()
            .antMatchers("/","/css/**", "/js/**", "/images/**", "/listar")
            .permitAll()
            // .antMatchers("/ver/**").hasAnyRole("USER")
            // .antMatchers("/uploads/**").hasAnyRole("USER")
            // .antMatchers("/form/**").hasAnyRole("ADMIN")
            // .antMatchers("/eliminar/**").hasAnyRole("ADMIN")
            // .antMatchers("/factura/**").hasAnyRole("ADMIN")
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .successHandler(successHandler)
            .loginPage("/login")
            .permitAll()
            .and()
            .logout().permitAll()
            .and()
            .exceptionHandling().accessDeniedPage("/error_403");

            return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        UserDetails user = User.withUsername("fercar")
            .password(encoder.encode("123"))
            .roles("USER").build();

            UserDetails admin = User.withUsername("admin")
            .password(encoder.encode("123456"))
            .roles("ADMIN").build();

        return new InMemoryUserDetailsManager(admin,user);
    }
}
