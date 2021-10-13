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
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name="camp")
public class Camp {
	@Id  //only for primary key
	@Column(name="id")
  int campId;
	@Column(name="location")
  String location;
	@Column(name="campdate")
	LocalDate date;
	@Column(name="starttime")
	String startTime;
	@Column(name="endtime")
	String endTime;
	
	
}
