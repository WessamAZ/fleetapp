package com.kindsonthegenius.fleetapp.controllers;

import com.kindsonthegenius.fleetapp.models.JobTitle;
import com.kindsonthegenius.fleetapp.services.JobTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class JobTitleController {
	
	@Autowired private JobTitleService jobTitleService;
	
	//Get All JobTitles
	@GetMapping("jobTitles")
	public String findAll(Model model){		
		model.addAttribute("jobTitles", jobTitleService.findAll());
		return "jobTitle";
	}	
	
	@RequestMapping("jobTitles/findById") 
	@ResponseBody
	public Optional<JobTitle> findById(Integer id)
	{
		return jobTitleService.findById(id);
	}
	
	//Add JobTitle
	@PostMapping(value="jobTitles/addNew")
	public String addNew(JobTitle jobTitle) {
		jobTitleService.save(jobTitle);
		return "redirect:/jobTitles";
	}	
	
	@RequestMapping(value="jobTitles/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(JobTitle jobTitle) {
		jobTitleService.save(jobTitle);
		return "redirect:/jobTitles";
	}
	
	@RequestMapping(value="jobTitles/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		jobTitleService.delete(id);
		return "redirect:/jobTitles";
	}

}
