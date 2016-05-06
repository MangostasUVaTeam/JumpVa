/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.api.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import java.security.Key;
import java.util.Date;

/**
 *
 * @author garciparedes
 */
public class TokenManager {
    
    
    private static Key KEY = MacProvider.generateKey();

    
    public static String validateToken(String token) throws Exception{
        return Jwts.parser().setSigningKey(KEY)
                .parseClaimsJws(token).getBody().getSubject();
    }
    
    
    public static String issueToken(String username){
        return Jwts.builder().setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + 60000l))
                .signWith(SignatureAlgorithm.HS256, KEY).compact();
    }
}
