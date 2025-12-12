package com.cibertec.clase3.domain.services.interfaces;

import com.cibertec.clase3.application.usescases.dto.request.ProductRequest;
import com.cibertec.clase3.application.usescases.dto.response.ProductResponse;
import com.cibertec.clase3.application.usescases.dto.response.ProviderResponse;

import java.util.List;

public interface IInventoryService {
    List<ProductResponse> listarProductos();

    List<ProviderResponse> listarProveedores();

    ProductResponse agregarProducto(ProductRequest productRequest);

    void eliminarProducto(Long idProducto);

    List<ProductResponse> listarProductosPorProveedor(Long proveedorId);
}
