package com.productservice.inheritancetypes.tableperclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("tbc_ta_repository")
public interface TARepository extends JpaRepository<TA, Long>{

}
