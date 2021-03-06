package com.example.demo.controllers;



import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



import javax.validation.Valid;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.Camp;
import com.example.demo.dto.Donor;



@Controller
public class DonorController {



@Autowired
private Donor obj1;
String BaseURL="http://localhost:1515/api/v1/donors";
@Autowired
private RestTemplate template;

@RequestMapping(value="/")
public String init(Model model) {
model.addAttribute("majHeading","BLOOD BANK MANAGEMENT SYSTEM");
return "index";
}
@GetMapping(path="/addDonor")
public String sendForm(Model model) {
model.addAttribute("command",obj1);
return "addDonor";
}

@PostMapping(path="/addDonor")
public String submitForm(@Valid @ModelAttribute("command") Donor donor,BindingResult result) {
//this.template.postForObject("http://localhost:7070/api/v1/students", student, Student.class);
String nextStep="success";

if(result.hasErrors()) {
nextStep="addDonor";
}
else {
HttpHeaders headers=new HttpHeaders();
headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
headers.setContentType(MediaType.APPLICATION_JSON);

HttpEntity<Donor> requestBody=new HttpEntity<>(donor,headers);
template.postForObject(BaseURL, requestBody, Donor.class);
}
return nextStep;
}
@GetMapping(path = "/getAllDonors")
public String findAll(Model model) {
Donor[] resp =template.getForObject(BaseURL,Donor[].class);
if(resp.length>0) {
model.addAttribute("data",resp); 
return "showall";}
else  
	return "dataNotFound";
}

@GetMapping(path = "/getEligibleDonors")
public String findEligibleDonors(Model model) {
Donor[] resp =template.getForObject(BaseURL,Donor[].class);
model.addAttribute("data",resp);

return "eligibleDonors";
}


@GetMapping(path = "/getBloodGroup")
public String findByBloodGroup(Model model,String searchbybloodgroup) {
Donor[] resp =template.getForObject(BaseURL+"/searchbybloodgroup/"+searchbybloodgroup,Donor[].class);
if(resp.length>0) {
model.addAttribute("data",resp); 
return "showall";}
else  
	return "dataNotFound";

}
@GetMapping(path = "/getByCity")
public String findByCity(Model model,String searchbycity) {
Donor[] resp =template.getForObject(BaseURL+"/searchbycity/"+searchbycity,Donor[].class);
if(resp.length>0) {
model.addAttribute("data",resp); 
return "showall";}
else  
	return "dataNotFound";


}
@GetMapping(path="/unregister")
public String removeDonor(Model model,int value)
{
template.delete(BaseURL+"/delete/"+value,Donor[].class);
return "deleteSuccess";
}
@GetMapping(path = "/getByArea")
public String findCamps(Model model,String location) {
Camp[] resp =template.getForObject("http://localhost:8585/api/v1/camps/"+location,Camp[].class);

if(resp.length>0) {
model.addAttribute("details",resp); 
return "CampDetails";}
else  
	return "dataNotFound";
}

@GetMapping(path="/updateDate")
public String updateDate(Model model,int id,String date) {

template.put(BaseURL+"/d/"+id+"/"+LocalDate.parse(date), Donor[].class);
return "updateSuccess";
}
@GetMapping(path="/updateName")
public String updateName(Model model,String name,int id) {
	template.put(BaseURL+"/n/"+id+"/"+name, Donor[].class);
	
		return "updateSuccess";
		}

@GetMapping(path="/updateGender")
public String updateGender(Model model,int id,String gender) {

template.put(BaseURL+"/g/"+id+"/"+gender, Donor[].class);
return "updateSuccess";
}
@GetMapping(path="/updateAddress")
public String updateAddress(Model model,int id,String address) {

template.put(BaseURL+"/a/"+id+"/"+address, Donor[].class);
return "updateSuccess";
}
@GetMapping(path="/updateGroup")
public String updategrp(Model model,int id,String grp) {

template.put(BaseURL+"/b/"+id+"/"+grp, Donor[].class);
return "updateSuccess";
}
@GetMapping(path = "/editDetails")
public String editdetails() {
return "editDetails";
}
@GetMapping(path="/updateNumber")
public String updateNumber(Model model,int id,long num) {
template.put(BaseURL+"/p/"+id+"/"+num, Donor[].class);
return "updateSuccess";
}
}