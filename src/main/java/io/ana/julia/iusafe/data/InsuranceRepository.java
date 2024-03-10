package io.ana.julia.iusafe.data;

import io.ana.julia.iusafe.data.entity.InsuranceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<InsuranceEntity,Long> {
}
