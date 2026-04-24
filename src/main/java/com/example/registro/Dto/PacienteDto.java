package com.example.registro.Dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PacienteDto {

    private Long id;
    private String nombre;
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long hospitalId;
    private HospitalExternoDto hospital; // Este es el que se llena con el WebClient
}
