package com.cibertec.clase3.application.usescases.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private Long id;
    private String nombreProducto;
    private Integer cantidad;
    private BigDecimal precioUnitario;
    private Long proveedorId;
    private String nombreProveedor;
    private String direccionProveedor;
    private String apoderadoLegal;
}
