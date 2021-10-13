package com.example.demo.controllers;

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

import com.example.demo.entity.Donor;

import com.example.demo.services.DonorService;

@RestController 
@RequestMapping(path="/api/v1/donors")
public class DonorController {

	   private DonorService service;


	@Autowired
	public void setService(DonorService service) {
		this.service = service;
	}   
	   
	    @GetMapping
	    
	    public List<Donor> findAll(){
	    	return this.service.findAll();
	    }
	    
	    @GetMapping("/searchbycity/{city}")  
	    public List<Donor> findByAddress(@PathVariable("city") String address){
	    	return this.service.findByAddress(address);
	    }
	    @GetMapping("/searchbybloodgroup/{grp}")
	    public List<Donor> findByBloodGrp(@PathVariable("grp") String bloodGrp){
	    	return this.service.findByBloodGrp(bloodGrp);
	    }
	   
	  
	    @PostMapping
	    public ResponseEntity<Donor> add(@RequestBody Donor entity) {
	    	
	    	Donor addedEntity=this.service.addDonor(entity);
	    	return ResponseEntity.status(HttpStatus.CREATED).body(addedEntity);
	    }
	    
	    @PutMapping("/n/{id}/{name}")
	  
	    public ResponseEntity<String> updateName(@PathVariable("name") String name
	    		,@PathVariable("id")int id){
	    	int count= this.service.updateName(name,id);
	    	return ResponseEntity.ok().body(count+" record with " +id+"  updated with new name "+name);
	    }
	   
	    @PutMapping("/g/{id}/{gender}")
	    
	    public ResponseEntity<String> updateGender(@PathVariable("gender") String gender
	    		,@PathVariable("id")int id){
	    	int count= this.service.updateGender(gender,id);
	    	return ResponseEntity.ok().body(count+" record with " +id+"  updated with  gender "+gender);
	    }
	    @PutMapping("/a/{id}/{address}")
	  
	    public ResponseEntity<String> updateAddress(@PathVariable("address") String address
	    		,@PathVariable("id")int id){
	    	int count= this.service.updateAddress(address,id);
	    	return ResponseEntity.ok().body(count+" record with " +id+"  updated with new address "+address);
	    }
	    @PutMapping("/b/{id}/{grp}")
	  
	    public ResponseEntity<String> updateGrp(@PathVariable("grp") String grp
	    		,@PathVariable("id")int id){
	    	int count= this.service.updateGrp(grp,id);
	    	return ResponseEntity.ok().body(count+" record with " +id+"  updated with new Blood group "+grp);
	    }
	    @PutMapping("/p/{id}/{num}")
	
	    public ResponseEntity<String> updateNumber(@PathVariable("num") long num
	    		,@PathVariable("id")int id){
	    	int count= this.service.updateNumber(num,id);
	    	return ResponseEntity.ok().body(count+" record with " +id+"  updated with new Phone Number "+ num);
	    }
	    @PutMapping("/d/{id}/{date}")
	  
	    public ResponseEntity<String> updateDate(@PathVariable("date") String date
	    		,@PathVariable("id")int id){
	    	LocalDate donatedDate=LocalDate.parse(date);
	    	int count= this.service.updateDate(donatedDate,id);
	    	return ResponseEntity.ok().body(count+" record with " +id+"  updated the Blood Donated date"+date);
	    }
	   
	   
	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<String> removeDonor(@PathVariable("id") int id){
	    	int count= this.service.remove(id);
	    	HttpStatus status=HttpStatus.NOT_FOUND;
	    	String message="record not found";
	    	if(count==1){
	    		status=HttpStatus.OK;
	    		message="One record Deleted";
	    	}
	    	
	    			return ResponseEntity.status(status).body(message);
	    }

	}
