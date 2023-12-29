package com.example.useraccountmanagementbackend.payload.response;

import com.example.useraccountmanagementbackend.enumerator.ERole;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
@Setter
@Getter
public class JwtResponse {
  private String token;
  private String type = "Bearer";
  private UUID id;
  private String username;
  private String email;
  private ERole role;
  private List<String> roles;

  public JwtResponse(String token, UUID id, String username, String email, ERole role, List<String> roles) {
    this.token = token;
    this.id = id;
    this.username = username;
    this.email = email;
    this.role = role;
    this.roles = roles;
  }
}
