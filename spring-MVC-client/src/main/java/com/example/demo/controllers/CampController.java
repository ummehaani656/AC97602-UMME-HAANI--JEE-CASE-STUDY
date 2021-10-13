package com.example.demo.controllers;
import org.springframework.http.HttpEntity.*;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.Camp;

@Controller
public class CampController {
	

    @Autowired
    private Camp object;

    //String name=null;
    
   // @Autowired
   // private ModelAndView mdlView;

    @Autowired
    private RestTemplate template;

    
   @GetMapping(path="/addDonationCamp")
   public String sendForm(Model model) {
      model.addAttribute("command",object);
      return "addCamp";
   }
  
   @PostMapping(path="/addDonationCamp")
   public String submitForm(@Valid @ModelAttribute("command")Camp camp,BindingResult result) {
	   
	 System.out.println(camp.getDate());
     String nextStep="success";

     if(result.hasErrors()) {
    	 System.out.println(result);
         nextStep="addCamp";
     }
     else {
    	 HttpHeaders headers = new HttpHeaders();
    	 headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    	 headers.setContentType(MediaType.APPLICATION_JSON);
    	 HttpEntity<Camp> requestBody = new HttpEntity<>(camp,headers);
    	 
    	 
    	 template.exchange("http://localhost:8585/api/v1/camps",HttpMethod.POST, requestBody, Camp.class);
     }
    return nextStep;
   }
   
   @GetMapping(path = "/getAllDonationCamps")
   public String findAll(Model model) {

   Camp[] resp =template.getForObject("http://localhost:8585/api/v1/camps",
  Camp[].class);
   
   model.addAttribute("details",resp);
   return "showdetails";

   }
   
   @GetMapping(path = "/searchcampbyarea")
 public String findDonationCamp(Model model,String location) {
	  

Camp[] resp =template.getForObject("http://localhost:8585/api/v1/camps/search/"+location,
Camp[].class);
model.addAttribute("details",resp);
//   model.addAttribute("location",name);
 return "showdetails";

  }
   
//   @RequestMapping("/delete/{id}")
//   public void delete(@PathVariable("id") int id) {
//	   
//	   HttpHeaders headers= new HttpHeaders();
//	   headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//	
//	   HttpEntity<Donor> requestBody = new HttpEntity<>(headers);
//	   
//	   this.template.exchange("http://localhost:9090/api/v1/donations/"+id,HttpMethod.DELETE, requestBody,String.class);
//	  
//   }
//   @RequestMapping(value="/update/{regNumber}/{bloodGroup}/{phoneNumber}")
//   public void update(@PathVariable("regNumber") int regNumber,@PathVariable("bloodGroup")String bloodGroup,@PathVariable("phoneNumber")Long phoneNumber) {
//	   
//	   HttpHeaders headers= new HttpHeaders();
//	   headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//	   
//	   HttpEntity<Donor> requestBody = new HttpEntity<>(headers);
//	   
//	   this.template.exchange("http://localhost:9090/api/v1/donations/"+regNumber+"/"+bloodGroup+"/"+phoneNumber,HttpMethod.PUT, requestBody,String.class);
//	  
//   }
   
   @GetMapping(path="/delete")
   public String sendForm1(Model model) {
      model.addAttribute("command",object);
      return "delete";
   }
   
   @RequestMapping("/remove")
  public ResponseEntity<String> delete(@RequestParam("regNumber")int campId,Model model) {
	   
	   HttpHeaders headers= new HttpHeaders();
	   headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	
	   HttpEntity<Camp> requestBody = new HttpEntity<>(headers);
	   
	   ResponseEntity<String>template=this.template.exchange("http://localhost:9090/api/v1/donationcamps/"+campId,HttpMethod.DELETE, requestBody,String.class);
	   
       if(template.getBody().contains("1 deleted")) {
		   
		   return ResponseEntity.ok().body("Donation Camp with Id "+campId+" has been removed");
	   }
	   else {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).body("404 not found");
	   }
       
   }
       @GetMapping(path="/edit")
       public String sendForm2(Model model) {
          model.addAttribute("command",object);
          return "edit";
       }
       
       @RequestMapping(value="/editDetails")
     public ResponseEntity<String> update(@RequestParam("regNumber") int campId,@RequestParam("donationCampName")String campName,@RequestParam("location")String location) {
  	   
  	   HttpHeaders headers= new HttpHeaders();
  	   headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
  	   
  	   HttpEntity<Camp> requestBody = new HttpEntity<>(headers);
  	   
  	   this.template.exchange("http://localhost:8585/api/v1/donationcamps/"+campId+"/"+campName+"/"+location,HttpMethod.PUT, requestBody,String.class);
  	  
  	   return ResponseEntity.ok().body("Updated Details: CampId:= "+campId+", DonationCampName:= "+campName+", Location"+location);
     }
	  
 
   
   
}

