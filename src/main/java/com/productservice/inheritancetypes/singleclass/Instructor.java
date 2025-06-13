package com.productservice.inheritancetypes.singleclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "sc_instructor")
@Getter
@Setter
@DiscriminatorValue(value = "2")
public class Instructor extends User {
	
	private int noOfBatches;

}
