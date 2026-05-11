/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gerenciadordecolecoes.gerenciador.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author farma
 */
@Service
public class TokenService {
    
    @Value("${api.security.token.secret}")
    private String secret;
    
    private SecretKey getSignKey() {
        byte[] chaveBytes = Decoders.BASE64.decode(this.secret);
        return Keys.hmacShaKeyFor(chaveBytes);
    }
    
    public String gerarToken(String email) {
        return Jwts.builder().subject(email)
        .issuedAt(new Date())
        .expiration(new Date(System.currentTimeMillis() + 300000))
        .signWith(getSignKey()).compact();
    }
    
    public boolean validarToken(String token){
        try{
            Jwts.parser()
            .setSigningKey(getSignKey())
            .build()
            .parseClaimsJws(token);
            return true;
        } catch(JwtException | IllegalArgumentException e){
            return false;
        }
    }
    
    public Claims extrairClaims(String token) {
        return Jwts.parser()
        .setSigningKey(getSignKey())
        .build().parseClaimsJws(token)
        .getBody();
    }
}
