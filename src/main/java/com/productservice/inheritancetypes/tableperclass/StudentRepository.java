package com.productservice.inheritancetypes.tableperclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("tpc_student_repository")
public interface StudentRepository extends JpaRepository<Student, Long>{

}
