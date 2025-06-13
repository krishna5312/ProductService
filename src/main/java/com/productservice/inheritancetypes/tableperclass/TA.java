package com.productservice.inheritancetypes.tableperclass;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tbc_ta")
public class TA extends User{
	
	private LocalDateTime sessionStartTime;
	
    private int doubtsClarified;

}
