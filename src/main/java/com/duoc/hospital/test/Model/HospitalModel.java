package com.duoc.hospital.test.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "hospitales")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String direccion;
}
