package com.example.demo.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
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
public class Donor {
		  @Range(min=101,max=1000,message="the Roll Number should be between 100 to 200")
		  int id;
		  @Length(min=3,max=20,message="name should be between 3 and 20 characters")
		  String donorname;
		  @NotBlank(message="select Gender")
		  String gender;
		  @NotBlank(message="Enter the Address")
		  String address;
		  @NotBlank(message="select the blood Group")
		  String bloodGrp;
		 // @NotBlank(message="phone Number cannot be null")
		 // @Pattern(regexp="(^$|[0-9]{10})",message="The phone number should be 10 digits")
		  long phoneNumber;
		  @NotNull(message="enter the  last Blood donated Date")
		  @DateTimeFormat(iso = ISO.DATE)
		  LocalDate donatedDate;	
		  
	}


