package com.duoc.hospital.test.Dto;

package com.duoc.hospital.test.Dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HospitalDTO {
    private Long id;
    private String nombre;
    private String direccion;
}