package com.example.demo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@RestController
public class JwtController {

    @GetMapping("/")
    public String hello() {
        return createJWT();
    }

    @GetMapping("/verify/{token}")
    public void verify(@RequestParam String token) {
        verify(token);
    }

    public void verifyToken(String token) {
        var algo = Algorithm.HMAC256("secret");
        var verifyToken = JWT.require(algo).withIssuer("USER").build();
        var verified = verifyToken.verify(token);
        System.out.println("Response of signature" + verified.getSignature());
        System.out.println("Response of subject" + verified.getSubject());
    }

    public String createJWT() {
        String secret = "secret";
        var algo = Algorithm.HMAC256(secret);

        var date = new Date();
        var expiryDate = AddDate(date, 60);

        var headers = new HashMap<String, Object>();
        headers.put("algo", "HS256");
        headers.put("typ", "jwt");
        return JWT.create().withHeader(headers)
                .withIssuedAt(date)
                .withExpiresAt(expiryDate)
                .withSubject("FISHING DEPARTMENT")
                .withClaim("FISHING-CLIAMS", date).withIssuer("USER")
                .sign(algo);
    }

    public Date AddDate(Date date, int minute) {
        if (date == null)
            date = new Date();
        var cal = new GregorianCalendar();
        cal.setTime(date);
        ;
        cal.add(Calendar.MINUTE, minute);
        return cal.getTime();
    }
}
