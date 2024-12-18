package com.SaludAnimalia.service;


import com.SaludAnimalia.web.dto.UsuarioDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.cglib.core.internal.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class JwtService {
    private final String secret = "46T/6tR1ubo4tsmJOoLOW07ZqUSUAEoxP45t89cEZck=";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public List<String> extractPermisos(String token) {
        Claims claims = extractAllClaims(token);
        return claims.get("permisos", List.class);
    }

    public String extractRol(String token){
        Claims claims = extractAllClaims(token);
        return claims.get("rol", String.class);
    }

    public Integer extractUserId(String token) {
        Claims claims = extractAllClaims(token);
        return claims.get("userId", Integer.class);
    }

    public String generateToken(UserDetails userDetails, List<String> permisos, Integer userId, String rol) {
        Map<String, Object> claims = Map.of(
                "permisos", permisos,
                "userId", userId,
                "rol",rol
        );
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 horas
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .compact();
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(secret.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public boolean validateToken(String token, UsuarioDto usuario ) {
        final String username = extractUsername(token);

        return (username.equals(usuario.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }
}