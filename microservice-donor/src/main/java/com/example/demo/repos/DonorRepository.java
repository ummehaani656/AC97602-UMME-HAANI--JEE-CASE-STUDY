package com.example.demo.repos;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Donor;

@Repository
public interface DonorRepository extends JpaRepository<Donor,Integer> {
	public List<Donor> findByBloodGrp(String srchgrp);
	public List<Donor> findByAddress(String address);
	@Query(nativeQuery = true,
			value="update donor set donorname=:name where id=:id")
			@Modifying
			@Transactional
			public int updateName(@Param("name") String name,@Param("id") int id);
	@Query(nativeQuery = true,
			value="update donor set gender=:gender where id=:id")
			@Modifying
			@Transactional
			public int updateGender(@Param("gender") String gender,@Param("id") int id);
	@Query(nativeQuery = true,
			value="update donor set address=:address where id=:id")
			@Modifying
			@Transactional
			public int updateAddress(@Param("address") String address,@Param("id") int id);
	

	@Query(nativeQuery = true,
			value="update donor set bloodgrp=:grp where id=:id")
			@Modifying
			@Transactional
			public int updateGrp(@Param("grp") String grp,@Param("id") int id);
	@Query(nativeQuery = true,
			value="update donor set phonenumber=:num where id=:id")
			@Modifying
			@Transactional
			public int updateNumber(@Param("num") long num,@Param("id") int id);
	@Query(nativeQuery = true,
			value="update donor set donateddate=:date where id=:id")
			@Modifying
			@Transactional
			public int updateDate(@Param("date") LocalDate date,@Param("id") int id);
}
