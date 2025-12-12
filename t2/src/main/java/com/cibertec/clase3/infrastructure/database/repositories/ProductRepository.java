package com.cibertec.clase3.infrastructure.database.repositories;

import com.cibertec.clase3.infrastructure.database.dto.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByProveedorId(Long proveedorId);

    @Modifying
    @Query("delete from ProductEntity p where p.id = :id")
    int deleteByIdReturningCount(@Param("id") Long id);
}
