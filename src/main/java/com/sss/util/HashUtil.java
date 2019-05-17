package com.sss.util;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * HashUtil class
 *
 * @author Sss
 * @date 2019/3/26
 */
public class HashUtil {

    private static final HashFunction FUNCTION = Hashing.sha256();
    private static final HashFunction MURMUR_FUNC = Hashing.murmur3_128();

    public static final String SALT = "youfei";

    public static String encryPassword(String password){
        HashCode code = FUNCTION.newHasher().putString(SALT+password, Charset.forName("UTF-8")).hash();
        return code.toString();
    }

    public static String encryText(String text){
        HashCode code = null;
        try{
            code = MURMUR_FUNC.hashBytes(text.getBytes("utf-8"));
        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return code.toString();

    }
}
