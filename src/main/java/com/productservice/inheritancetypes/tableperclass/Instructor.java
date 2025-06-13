package com.productservice.inheritancetypes.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "tcb_instructor")
@Getter
@Setter
public class Instructor extends User {
	
	private int noOfBatches;

}
