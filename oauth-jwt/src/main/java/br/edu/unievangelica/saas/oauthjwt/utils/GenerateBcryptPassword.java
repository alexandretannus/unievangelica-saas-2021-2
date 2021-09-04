package br.edu.unievangelica.saas.oauthjwt.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GenerateBcryptPassword {
    
    public static void main(String[] args) {
        String password = "123456";
        
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode(password));
    }

}
