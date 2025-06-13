package com.productservice.inheritancetypes.join;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "j_ta")
@PrimaryKeyJoinColumn(name = "user_id")
public class TA extends User{
	
	private LocalDateTime sessionStartTime;
	
    private int doubtsClarified;

}
