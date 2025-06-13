package com.productservice.inheritancetypes.singleclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("sc_user_repository")
public interface UserRepository extends JpaRepository<User, Long>{

}
