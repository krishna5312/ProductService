package com.productservice.inheritancetypes.join;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("j_instructor_repository")
public interface InstructorRepository extends JpaRepository<Instructor, Long>{

}
