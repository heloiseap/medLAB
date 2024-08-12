package com.medLAB.dtos;

import lombok.Data;

@Data
public class UsuarioRequest {
    private Long id;
    private String username;
    private String password;
}
