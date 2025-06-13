package com.productservice.inheritancetypes.join;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("j_ta_repository")
public interface TARepository extends JpaRepository<TA, Long>{

}
