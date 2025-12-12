package com.cibertec.clase3.application.usescases.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProviderResponse {
    private Long id;
    private String nombreProveedor;
    private String direccion;
    private String apoderadoLegal;
}
