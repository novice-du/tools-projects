package com.djh.config;

import com.djh.utils.MD5Util;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author: dujunhua
 * @create: 2021/10/26 4:10
 * @description:
 */
public class MyPasswordEncoderConfig implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return MD5Util.encode((String) charSequence);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encodedPassword.equals(MD5Util.encode((String) rawPassword));
    }
}
