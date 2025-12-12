package com.cibertec.clase3.domain.services.implementation;

import com.cibertec.clase3.application.usescases.dto.request.ProductRequest;
import com.cibertec.clase3.application.usescases.dto.response.ProductResponse;
import com.cibertec.clase3.application.usescases.dto.response.ProviderResponse;
import com.cibertec.clase3.domain.services.interfaces.IInventoryService;
import com.cibertec.clase3.infrastructure.database.dto.ProductEntity;
import com.cibertec.clase3.infrastructure.database.dto.ProviderEntity;
import com.cibertec.clase3.infrastructure.database.repositories.ProductRepository;
import com.cibertec.clase3.infrastructure.database.repositories.ProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class InventoryServiceImplementation implements IInventoryService {
    private final ProductRepository productRepository;
    private final ProviderRepository providerRepository;

    @Override
    public List<ProductResponse> listarProductos() {
        return productRepository.findAll()
                .stream()
                .map(this::toProductResponse)
                .toList();
    }

    @Override
    public List<ProviderResponse> listarProveedores() {
        return providerRepository.findAll()
                .stream()
                .map(this::toProviderResponse)
                .toList();
    }

    @Override
    public ProductResponse agregarProducto(ProductRequest productRequest) {
        ProviderEntity provider = providerRepository.findById(productRequest.getProveedorId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Proveedor no encontrado"));

        ProductEntity entity = new ProductEntity();
        entity.setNombreProducto(productRequest.getNombreProducto());
        entity.setCantidad(productRequest.getCantidad());
        entity.setPrecioUnitario(productRequest.getPrecioUnitario());
        entity.setProveedor(provider);

        ProductEntity saved = productRepository.save(entity);
        return toProductResponse(saved);
    }

    @Override
    public void eliminarProducto(Long idProducto) {
        int rows = productRepository.deleteByIdReturningCount(idProducto);
        if (rows == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado");
        }
        productRepository.flush(); // ensure delete is executed before returning
    }

    @Override
    public List<ProductResponse> listarProductosPorProveedor(Long proveedorId) {
        ProviderEntity provider = providerRepository.findById(proveedorId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Proveedor no encontrado"));

        return productRepository.findByProveedorId(provider.getId())
                .stream()
                .map(this::toProductResponse)
                .toList();
    }

    private ProductResponse toProductResponse(ProductEntity entity) {
        ProviderEntity provider = entity.getProveedor();
        return ProductResponse.builder()
                .id(entity.getId())
                .nombreProducto(entity.getNombreProducto())
                .cantidad(entity.getCantidad())
                .precioUnitario(entity.getPrecioUnitario())
                .proveedorId(provider != null ? provider.getId() : null)
                .nombreProveedor(provider != null ? provider.getNombreProveedor() : null)
                .direccionProveedor(provider != null ? provider.getDireccion() : null)
                .apoderadoLegal(provider != null ? provider.getApoderadoLegal() : null)
                .build();
    }

    private ProviderResponse toProviderResponse(ProviderEntity provider) {
        return ProviderResponse.builder()
                .id(provider.getId())
                .nombreProveedor(provider.getNombreProveedor())
                .direccion(provider.getDireccion())
                .apoderadoLegal(provider.getApoderadoLegal())
                .build();
    }
}
