package com.jwt_example.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Builder
public class JwtResponse {
    private String jwtToken;
    private String username;


}
