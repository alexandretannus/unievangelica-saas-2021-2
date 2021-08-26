package br.edu.unievangelica.tannus.saas.autenticacaobasic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
            .and()      
            .authorizeRequests()
                .antMatchers("/main/free", "/actuator/*").permitAll()
                .anyRequest().authenticated()
           .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()        
            .withUser("admin").password(passwordEncoder().encode("admin")).roles("roles") // não usar essa forma, pois é insegura
            .and()
            .withUser("alexandre").password("$2a$10$Vu7J7EB83m7KGcyS8Vo3R.d6mhsER7./BdgLSn0a0gAN.S/IoYxdS").roles("roles");
    }
 
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    } 
}
