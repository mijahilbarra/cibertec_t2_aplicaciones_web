package com.cibertec.clase3.application.usescases.implementation;

import com.cibertec.clase3.application.usescases.dto.request.ProductRequest;
import com.cibertec.clase3.application.usescases.dto.response.ProductResponse;
import com.cibertec.clase3.application.usescases.dto.response.ProviderResponse;
import com.cibertec.clase3.application.usescases.interfaces.IInventoryUseCase;
import com.cibertec.clase3.domain.services.interfaces.IInventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InventoryUseCaseImplementation implements IInventoryUseCase {
    private final IInventoryService inventoryService;

    @Override
    public List<ProductResponse> listarProductos() {
        return inventoryService.listarProductos();
    }

    @Override
    public List<ProviderResponse> listarProveedores() {
        return inventoryService.listarProveedores();
    }

    @Override
    public ProductResponse agregarProducto(ProductRequest productRequest) {
        return inventoryService.agregarProducto(productRequest);
    }

    @Override
    public void eliminarProducto(Long idProducto) {
        inventoryService.eliminarProducto(idProducto);
    }

    @Override
    public List<ProductResponse> listarProductosPorProveedor(Long proveedorId) {
        return inventoryService.listarProductosPorProveedor(proveedorId);
    }
}
