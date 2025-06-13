package com.productservice.inheritancetypes.join;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("j_student_repository")
public interface StudentRepository extends JpaRepository<Student, Long>{

}
