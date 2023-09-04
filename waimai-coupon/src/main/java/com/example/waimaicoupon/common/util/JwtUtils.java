package com.example.waimaicoupon.common.util;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * JWT工具类，用于生成和解析验证JWT
 */
@Component
public class JwtUtils {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expiration;

    /**
     * 生成JWT Token
     *
     * @param username 用户名
     * @return JWT Token
     */
    public String generateJwtToken(String username, Integer userId) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiration * 1000);

        return Jwts.builder()
                .claim("username", username)
                .claim("userId", userId)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 从JWT Token中获取用户名
     *
     * @param token JWT Token
     * @return 用户名
     */
    public Claims getUsernameFromJwtToken(String token) {

        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        return claims;
    }

    /**
     * 验证JWT Token是否有效
     *
     * @param token JWT Token
     * @return true表示有效，false表示无效
     */
    public boolean validateJwtToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            // Invalid signature
        } catch (MalformedJwtException e) {
            // Invalid JWT token
        } catch (ExpiredJwtException e) {
            // Expired JWT token
        } catch (UnsupportedJwtException e) {
            // Unsupported JWT token
        } catch (IllegalArgumentException e) {
            // JWT token compact of handler are invalid
        }
        return false;
    }
}
