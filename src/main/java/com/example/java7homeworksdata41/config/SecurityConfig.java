package com.example.java7homeworksdata41.config;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
//public class SecurityConfig {
//
//    private boolean securityDebug;
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder) {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("Dasha")
//                .password(bCryptPasswordEncoder.encode("userCity"))
//                .roles("USER-City")
//                .build());
//        manager.createUser(User.withUsername("Pavel")
//                .password(bCryptPasswordEncoder.encode("userAge"))
//                .roles("USER-Age")
//                .build());
//        manager.createUser(User.withUsername("admin")
//                .password(bCryptPasswordEncoder.encode("adminPass"))
//                .roles("USER", "ADMIN")
//                .build());
//        return manager;
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf()
//                .disable()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.DELETE).hasRole("ADMIN")
//                .antMatchers("/admin/**").hasAnyRole("ADMIN")
//                .antMatchers("/user/**").hasAnyRole("USER-City", "USER-Age", "ADMIN")
//                .antMatchers("/login/**").anonymous()
//                .antMatchers("/persons/user-city/**").hasAnyRole("USER-City")
//                .antMatchers("/persons/user-age/**").hasAnyRole("USER-Age")
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic()
//                .and()
//                .logout().logoutUrl("/logout")
///               .logoutSuccessUrl("/login")
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        return http.build();
//    }
//
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.debug(securityDebug)
//                .ignoring()
//                .antMatchers("/css/**", "/js/**", "/img/**", "/lib/**", "/favicon.ico");
//    }
//}

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Pasha").password("{noop}1234").authorities("City")
                .and()
                .withUser("Admin").password("{noop}admin").authorities("Admin")
                .and()
                .withUser("Olga").password("{noop}1234").authorities("Age");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().and()
                .authorizeHttpRequests().antMatchers("/persons/user-city/**").hasAnyAuthority("City", "Admin")
                .and()
                .authorizeHttpRequests().antMatchers("/persons/user-age/**").hasAnyAuthority("Age", "Admin")
                .and()
                .authorizeHttpRequests().antMatchers("/persons/admin/**").hasAuthority("Admin")
                .and()
                .authorizeHttpRequests().antMatchers("/persons/hello").authenticated()
                .and()
                .authorizeHttpRequests().antMatchers("/persons/").permitAll()
                .and()
                .authorizeHttpRequests().anyRequest().authenticated();


    }
}





