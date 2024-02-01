package com.kdu.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;


@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "username", length = 32)
    private String username;

    @Column(name = "loggedin")
    private int loggedIn = 0;

    @Column(name = "time_zone", length = 32)
    private String timeZone;
}
