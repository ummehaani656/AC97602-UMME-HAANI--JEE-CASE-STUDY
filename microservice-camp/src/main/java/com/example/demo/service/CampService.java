package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Camp;

import com.example.demo.repos.CampRepository;

@Service
public class CampService {
	@Autowired
	   private CampRepository repo;
		
		public List<Camp> findAll(){
			return this.repo.findAll();
		}
		public Camp addCamp(Camp entity) {
	    	return this.repo.save(entity);
	 }
	 public List<Camp> findByLocation(String address){
		 return  this.repo.findByLocation(address);
	 }
	 public int updateLocation(String location,int id) {
		 return this.repo.updateLocation(location, id);
	 }
	 public int updateStartTime(String startTime,int id) {
		 return this.repo.updateLocation(startTime, id);
	 }
	 public int updateEndTime(String endTime,int id) {
		 return this.repo.updateLocation(endTime, id);
	 }
	 public int updateCampDate(LocalDate date,int id) {
		 return this.repo.updateCampDate(date, id);
	 }
	 public int remove(int id) {
		 int rowDeleted=0;
		 if(this.repo.existsById(id)) {
			 this.repo.deleteById(id);
			 rowDeleted=1;
		 }
		 return rowDeleted;
	 }
}
