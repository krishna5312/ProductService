package com.productservice.inheritancetypes.mappedsource;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "msc_student")
@Getter
@Setter
public class Student extends User {
	
	private double psp;
	
	private double attendance;

}
