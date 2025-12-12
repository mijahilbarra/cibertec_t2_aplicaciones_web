package com.cibertec.clase3.infrastructure.database.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "proveedores")
public class ProviderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_proveedor", nullable = false)
    private String nombreProveedor;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "apoderado_legal")
    private String apoderadoLegal;

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductEntity> productos;
}
