package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Camp;
import com.example.demo.service.CampService;


@RestController 
@RequestMapping(path="/api/v1/camps")
public class CampController {
	        @Autowired
		   private CampService service;


		@Autowired
		public void setService(CampService service) {
			this.service = service;
		}   
		   
		    @GetMapping
		    
		    public List<Camp> findAll(){
		    	return this.service.findAll();
		    }
		    
		    @GetMapping("/search/{location}")  
		    public List<Camp> findByLocation(@PathVariable("location") String address){
		    	return this.service.findByLocation(address);
		    }
		  
		    @PostMapping
		    @RolesAllowed(value = {"ROLE_ADMIN"})
		    public ResponseEntity<Camp> add(@RequestBody Camp entity) {
		    	
		    	Camp addedEntity=this.service.addCamp(entity);
		    	return ResponseEntity.status(HttpStatus.CREATED).body(addedEntity);
		    }
		    
		    @PutMapping("/l/{id}/{location}")
		    @RolesAllowed(value = {"ROLE_ADMIN"})
		    public ResponseEntity<String> updateLocation(@PathVariable("location") String location
		    		,@PathVariable("id")int id){
		    	int count= this.service.updateLocation(location,id);
		    	return ResponseEntity.ok().body(count+" record with  id " +id+"  updated with new location "+location);
		    }
		   
		    @PutMapping("/s/{id}/{stime}")
		    @RolesAllowed(value = {"ROLE_ADMIN"})
		    public ResponseEntity<String> updateStartTime(@PathVariable("stime") String startTime
		    		,@PathVariable("id")int id){
		    	int count= this.service.updateStartTime(startTime,id);
		    	return ResponseEntity.ok().body(count+" record with id  " +id+"  updated with Start Time "+startTime);
		    }
		    @PutMapping("/e/{id}/{etime}")
		    @RolesAllowed(value = {"ROLE_ADMIN"})
		    public ResponseEntity<String> updateEndTime(@PathVariable("etime") String endTime
		    		,@PathVariable("id")int id){
		    	int count= this.service.updateEndTime(endTime,id);
		    	return ResponseEntity.ok().body(count+" record with id " +id+"  updated with new End Time  "+endTime);
		    }
		    @PutMapping("/d/{id}/{date}")
		    @RolesAllowed(value = {"ROLE_ADMIN"})
		    public ResponseEntity<String> updateCampDate(@PathVariable("date") String date
		    		,@PathVariable("id")int id){
		    	LocalDate donatedDate=LocalDate.parse(date);
		    	int count= this.service.updateCampDate(donatedDate,id);
		    	return ResponseEntity.ok().body(count+" record with  id " +id+"  updated the Blood Donation Camp date"+date);
		    }
		    @DeleteMapping("/delete/{id}")
		    @RolesAllowed(value = {"ROLE_ADMIN"})
		    public ResponseEntity<String> removeCamp(@PathVariable("id") int id){
		    	int count= this.service.remove(id);
		    	HttpStatus status=HttpStatus.NOT_FOUND;
		    	String message="record not found";
		    	if(count==1){
		    		status=HttpStatus.OK;
		    		message="One camp Deleted";
		    	}
		    	
		    			return ResponseEntity.status(status).body(message);
		    }

		}
	

