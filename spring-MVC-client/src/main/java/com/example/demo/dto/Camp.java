package com.example.demo.dto;

import java.time.LocalDate;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
public class Camp {
	 
	 @Range(min=101,max=1000,message="the Roll Number should be between 100 to 200")
	  int campId;
	  String location;
	  @DateTimeFormat(iso = ISO.DATE)
	  LocalDate date;
		String startTime;
		String endTime;
		
}
