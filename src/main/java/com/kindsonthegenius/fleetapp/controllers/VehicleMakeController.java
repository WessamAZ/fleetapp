package com.kindsonthegenius.fleetapp.controllers;

import com.kindsonthegenius.fleetapp.models.VehicleMake;
import com.kindsonthegenius.fleetapp.services.VehicleMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleMakeController {
	
	@Autowired private VehicleMakeService vehicleMakeService;
	
	//Get All VehicleMakes
	@GetMapping("vehicleMakes")
	public String findAll(Model model){		
		model.addAttribute("vehicleMakes", vehicleMakeService.findAll());
		return "vehicleMake";
	}	
	
	@RequestMapping("vehicleMakes/findById") 
	@ResponseBody
	public Optional<VehicleMake> findById(Integer id)
	{
		return vehicleMakeService.findById(id);
	}
	
	//Add VehicleMake
	@PostMapping(value="vehicleMakes/addNew")
	public String addNew(VehicleMake vehicleMake) {
		vehicleMakeService.save(vehicleMake);
		return "redirect:/vehicleMakes";
	}	
	
	@RequestMapping(value="vehicleMakes/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleMake vehicleMake) {
		vehicleMakeService.save(vehicleMake);
		return "redirect:/vehicleMakes";
	}
	
	@RequestMapping(value="vehicleMakes/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		vehicleMakeService.delete(id);
		return "redirect:/vehicleMakes";
	}


}
