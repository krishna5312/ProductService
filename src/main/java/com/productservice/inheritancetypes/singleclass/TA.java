package com.productservice.inheritancetypes.singleclass;

import java.time.LocalDateTime;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "sc_ta")
@DiscriminatorValue(value = "0")
public class TA extends User{
	
	private LocalDateTime sessionStartTime;
	
    private int doubtsClarified;

}
