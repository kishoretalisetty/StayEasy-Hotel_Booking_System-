package org.example.DTOSLayer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDetailsDto {
    @NonNull
    private String name;
    @NonNull
    private String password;
    @NonNull
    private String firstName;
    @NonNull
    private String secondName;
    private String role;

    public UserDetailsDto(@NonNull String name, @NonNull String password, @NonNull String firstName, @NonNull String secondName) {
        this.name = name;
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
    }
}
