package com.api.lifeplus.infra.repository;

import com.api.lifeplus.domain.model.Medicamentos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentosRepository extends JpaRepository<Medicamentos, Long> {

}
