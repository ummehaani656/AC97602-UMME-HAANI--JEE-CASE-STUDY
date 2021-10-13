package com.example.demo.repos;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Camp;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
@Repository
public interface CampRepository extends JpaRepository<Camp,Integer> {
	public List<Camp> findByLocation(String location);
	@Query(nativeQuery = true,
			value="update camp set location=:location where id=:id")
			@Modifying
			@Transactional
			public int updateLocation(@Param("location") String location,@Param("id") int id);
	@Query(nativeQuery = true,
			value="update donor set startTime=:starttime where id=:id")
			@Modifying
			@Transactional
			public int updateStartTime(@Param("starttime") String startTime,@Param("id") int id);
	@Query(nativeQuery = true,
			value="update donor set endTime=:endtime where id=:id")
			@Modifying
			@Transactional
			public int updateEndTime(@Param("endtime") String endTime,@Param("id") int id);
	@Query(nativeQuery = true,
			value="update camp set campdate=:date where id=:id")
			@Modifying
			@Transactional
			public int updateCampDate(@Param("date") LocalDate date,@Param("id") int id);


}
