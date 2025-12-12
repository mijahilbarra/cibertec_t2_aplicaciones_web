package com.cibertec.clase3.application.usescases.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    @NotBlank(message = "nombreProducto es requerido")
    private String nombreProducto;

    @NotNull(message = "cantidad es requerida")
    @Min(value = 0, message = "cantidad debe ser mayor o igual a 0")
    private Integer cantidad;

    @NotNull(message = "precioUnitario es requerido")
    @DecimalMin(value = "0.0", inclusive = false, message = "precioUnitario debe ser mayor a 0")
    private BigDecimal precioUnitario;

    @NotNull(message = "proveedorId es requerido")
    private Long proveedorId;
}
