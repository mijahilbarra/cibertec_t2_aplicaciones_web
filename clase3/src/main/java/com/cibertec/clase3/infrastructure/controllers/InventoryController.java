package com.cibertec.clase3.infrastructure.controllers;

import com.cibertec.clase3.application.usescases.dto.request.ProductRequest;
import com.cibertec.clase3.application.usescases.dto.response.ProductResponse;
import com.cibertec.clase3.application.usescases.dto.response.ProviderResponse;
import com.cibertec.clase3.application.usescases.interfaces.IInventoryUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class InventoryController {
    private final IInventoryUseCase inventoryUseCase;

    @GetMapping("/productos")
    public ResponseEntity<List<ProductResponse>> listarProductos() {
        return ResponseEntity.ok(inventoryUseCase.listarProductos());
    }

    @GetMapping("/proveedores")
    public ResponseEntity<List<ProviderResponse>> listarProveedores() {
        return ResponseEntity.ok(inventoryUseCase.listarProveedores());
    }

    @PostMapping("/productos")
    public ResponseEntity<ProductResponse> agregarProducto(@Valid @RequestBody ProductRequest productRequest) {
        ProductResponse created = inventoryUseCase.agregarProducto(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        inventoryUseCase.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/proveedores/{id}/productos")
    public ResponseEntity<List<ProductResponse>> listarProductosPorProveedor(@PathVariable Long id) {
        return ResponseEntity.ok(inventoryUseCase.listarProductosPorProveedor(id));
    }
}
