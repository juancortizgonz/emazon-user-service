package com.emazon.user_service.infrastructure.entity;

import com.emazon.user_service.infrastructure.entity.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_lastname", nullable = false)
    private String userLastName;

    @Column(name = "user_dni", nullable = false)
    private String userDni;

    @Column(name = "user_phone", nullable = false)
    private String userPhone;

    @Column(name = "user_birthdate", nullable = false)
    private LocalDate userBirthDate;

    @Column(name = "user_email", nullable = false)
    private String userEmail;

    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @Enumerated(EnumType.STRING)
    private RoleEnum userRole;
}
