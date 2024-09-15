package com.emazon.user_service.infrastructure.util;

import java.time.LocalDate;
import java.util.Set;

public class DataLoaderConstants {
    private DataLoaderConstants() {
    }

    public static final String ADMIN_EMAIL = "admin@example.com";
    public static final String ADMIN_NAME = "Admin";
    public static final String ADMIN_LAST_NAME = "User";
    public static final String ADMIN_DNI = "00000000";
    public static final String ADMIN_PHONE = "+570000000000";
    public static final LocalDate ADMIN_BIRTH_DATE = LocalDate.of(1990, 1, 1);
    public static final Set<String> ADMIN_ROLE = Set.of("ADMIN");
}
