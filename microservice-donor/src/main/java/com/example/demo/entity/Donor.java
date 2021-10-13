package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name="donor")
public class Donor {
		@Id  //only for primary key
		@Column(name="id")
	  int id;
		@Column(name="donorname")
	  String donorname;
		@Column(name="gender")
		  String gender;
		@Column(name="address")
	  String address;
		@Column(name="bloodgrp")
	   String bloodGrp ;
		@Column(name="phonenumber")
		long phoneNumber;
		@Column(name="donateddate")
		LocalDate donatedDate;
		
		
	}


