package com.productservice.inheritancetypes.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "tbc_student")
public class Student extends User {
	
	private double psp;
	
	private double attendance;

}
