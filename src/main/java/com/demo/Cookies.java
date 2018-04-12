package com.demo;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by robert.manukyan on 3/21/2018.
 */
public class Cookies  {

    public static Cookie getCookie(ServletRequest request) throws IOException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        Cookie[] cookies = httpRequest.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("auth".equals(cookie.getName())) {
                    return cookie;
                }
            }

        }
        return null;
    }


}
