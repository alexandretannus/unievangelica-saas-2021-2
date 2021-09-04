package br.edu.unievangelica.saas.oauthjwt.config;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@SuppressWarnings("deprecation")
@Configuration
public class JwtConfig {
    
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey("thisKeyMustHaveMoreThanThirtyTwoCharacters");

        return jwtAccessTokenConverter;
    }

    @Bean 
    public JwtDecoder jwtDecoder() {
        var secretKey = new SecretKeySpec("thisKeyMustHaveMoreThanThirtyTwoCharacters".getBytes(), "HmacSHA256");
        return NimbusJwtDecoder.withSecretKey(secretKey).build();
    }
}
