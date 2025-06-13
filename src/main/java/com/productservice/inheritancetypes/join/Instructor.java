package com.productservice.inheritancetypes.join;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "j_instructor")
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "user_id")
public class Instructor extends User {
	
	private int noOfBatches;

}
