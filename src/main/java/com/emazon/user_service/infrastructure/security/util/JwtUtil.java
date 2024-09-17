package com.emazon.user_service.infrastructure.security.util;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class JwtUtil {
    private JwtUtil() {
    }

    public static Date getExpirationDate() {
        Instant now = Instant.now();
        Instant expiration = now.plus(Duration.ofDays(1));
        return Date.from(expiration);
    }

    public static Date getIssuedDate() {
        return new Date(System.currentTimeMillis());
    }

}
