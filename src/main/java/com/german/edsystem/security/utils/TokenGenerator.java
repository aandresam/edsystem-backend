package com.german.edsystem.security.utils;

import java.time.LocalDate;

public class TokenGenerator {
    private static final String ACCESS_TOKEN_SECURITY = "4qhq8LrEBfYcaRHxhdb9zURb2rf8e7Ud";
    private static final Long ACCESS_TOKEN_EXPIRE_TIME = 2_592_000L;

    public static String generateToken(String username, String email) {
        Long expirationTime = ACCESS_TOKEN_EXPIRE_TIME * 1000;
        LocalDate expirationDate = new LocalDate(System.currentTimeMillis() + expirationTime);
    }

}
