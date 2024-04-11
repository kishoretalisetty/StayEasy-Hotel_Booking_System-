package org.example.Pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Login
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
    private String username;
    private String password;
}