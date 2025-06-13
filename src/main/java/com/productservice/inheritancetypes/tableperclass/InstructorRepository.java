package com.productservice.inheritancetypes.tableperclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("tpc_instructor_repository")
public interface InstructorRepository extends JpaRepository<Instructor, Long>{

}
