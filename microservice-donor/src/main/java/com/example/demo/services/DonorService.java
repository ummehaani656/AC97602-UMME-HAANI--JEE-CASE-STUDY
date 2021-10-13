package com.example.demo.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Donor;
import com.example.demo.exception.ErrorHandler;
import com.example.demo.repos.DonorRepository;


@Service
public class DonorService  {
	@Autowired
	   private DonorRepository repo;
		
		public List<Donor> findAll(){
			return this.repo.findAll();
		}
		 public Donor addDonor(Donor entity) {
		    	return this.repo.save(entity);
		 }
		 public List<Donor> findByAddress(String address){
			 return   this.repo.findByAddress(address);
		 }
		 public List<Donor> findByBloodGrp( String key){
		    	return  this.repo.findByBloodGrp(key);
		    }
		 public int updateName(String name,int id) {
			 return this.repo.updateName(name, id);
		 }
		 public int updateGender(String gender,int id) {
			 return this.repo.updateGender(gender, id);
		 }
		 public int updateAddress(String address,int id) {
			 return this.repo.updateAddress(address, id);
		 }
		 public int updateGrp(String grp,int id) {
			 return this.repo.updateGrp(grp, id);
		 }
		 public int updateNumber(long num,int id) {
			 return this.repo.updateNumber(num, id);
		 }
		 public int updateDate(LocalDate date,int id) {
			 return this.repo.updateDate(date, id);
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
			
		


