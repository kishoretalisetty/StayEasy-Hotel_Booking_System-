package org.example.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "email")
    @NonNull
    private String name;
    @NonNull
    private String password;
    @NonNull
    private String firstName;
    @NonNull
    private String secondName;
    private String role;

    public User(@NonNull String name, @NonNull String password, @NonNull String firstName, @NonNull String secondName) {
        this.name = name;
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public User(@NonNull String name, @NonNull String password, @NonNull String firstName, @NonNull String secondName, String role) {
        this.name = name;
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
        this.role = role;
    }
}
