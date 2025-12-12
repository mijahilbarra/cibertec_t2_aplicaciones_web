package com.cibertec.clase3.infrastructure.database.repositories;

import com.cibertec.clase3.infrastructure.database.dto.ProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<ProviderEntity, Long> {
}
