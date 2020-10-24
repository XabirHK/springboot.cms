package com.zabir.springboot.cms.domains;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.*;


@Entity
@Table(name = "users", uniqueConstraints = {
    @UniqueConstraint(columnNames = "username"),
    @UniqueConstraint(columnNames = "email")
})
@Data
public class User implements RetData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullname;

    @Size(max = 25)
    private String username;

    @Size(max = 256)
    private String password;

    @Email
    @NotBlank
    @Size(max = 50)
    private String email;

    public User(final String username) {
        this.username = username;
    }

    public User(final String username, final String email) {
        this.username = username;
        this.email = email;
    }
}