package com.sss.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 * JwtHelper class
 *
 * @author Sss
 * @date 2019/3/27
 */
public class JwtHelper {

    private static final String SECRET = "session_secret";

    private static final String ISSUER = "youfei";

    public static String genToken(Map<String,String> claims){
        try{

            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTCreator.Builder builder = JWT.create().withIssuer(ISSUER).withExpiresAt(DateUtils.addDays(new Date(),1));
            claims.forEach((k,v) -> builder.withClaim(k,v));
            return builder.sign(algorithm);
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public static Map<String,String> verifyToken(String token){
        Algorithm algorithm = null;
        try{
            algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier jwtVerifier = JWT.require(algorithm).withIssuer(ISSUER).build();
            DecodedJWT jwt = jwtVerifier.verify(token);
            Map<String, Claim> claimMap = jwt.getClaims();
            Map<String,String> resultMap = new HashMap<>();
            claimMap.forEach((k,v) -> resultMap.put(k,v.asString()));
            return resultMap;

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
