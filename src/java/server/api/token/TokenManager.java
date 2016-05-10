/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.api.token;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import java.security.Key;

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
                .signWith(SignatureAlgorithm.HS256, KEY).compact();
    }
}
