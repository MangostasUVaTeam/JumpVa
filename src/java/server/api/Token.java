/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.api;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;
import com.auth0.jwt.internal.org.apache.commons.codec.binary.Base64;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Map;

/**
 *
 * @author garciparedes
 */
public class Token {
    
    private static Token instance = null;

    private static String CLIENT_SECRET="1234";
    private static Base64 decoder = new Base64(true);
    private static byte[] secret = decoder.decodeBase64(CLIENT_SECRET);
    private static Map<String,Object> decodedPayload;
    
    
    private static Token getInstance() throws NoSuchAlgorithmException, InvalidKeyException, IOException, JWTVerifyException {
        if(instance == null) {
           instance = new Token();
        }
        return instance;
    }

    
    private Token() throws NoSuchAlgorithmException, InvalidKeyException, IOException, JWTVerifyException {
        try {
            decodedPayload = new JWTVerifier(secret, "audience").verify("my-token");
            

            // Get custom fields from decoded Payload
            System.out.println(decodedPayload.get("name"));
            decodedPayload.put(CLIENT_SECRET, null);
            decodedPayload.get("hola");
            
        } catch (SignatureException signatureException) {
            System.err.println("Invalid signature!");
        } catch (IllegalStateException illegalStateException) {
            System.err.println("Invalid Token! " + illegalStateException);
        }
    }
    
    public static  Credentials getCredentials(String token){
        return null;
    }
    
    public static void setCredentials(Credentials credentials){
        
    }
}
