package net.javaguides.springboot.controller;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguides.springboot.model.Pickup;
import net.javaguides.springboot.service.PickupService;

@Controller
public class PickupController {

	@Autowired
	private PickupService pickupService;
	
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findPaginated(1, "firstName", "asc", model);		
	}
	
	@GetMapping("/show")
	public String showForm(Model model) {
		// create model attribute to bind form data
		Pickup pickup = new Pickup();
		model.addAttribute("pickup", pickup);
		return "pickup";
	}
	
	@PostMapping("/savePickup")
	public String savePickup(@ModelAttribute("pickup") Pickup pickup) {
		// save employee to database
		
		Integer siguienteOrder = this.pickupService.siguienteOrder();
		Integer siguientePedido = this.pickupService.siguientePedido();
		LocalTime LocalTime = this.pickupService.LocalTime();
		
		
		pickup.setOrden(siguienteOrder);
		pickup.setPedido(siguientePedido);
		
		pickup.setHour(LocalTime);
		
		
		
		
		pickupService.savePickup(pickup);
		return "redirect:/";
	}
	

	
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<Pickup> page = pickupService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Pickup> listPickups = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listPickups", listPickups);
		return "index";
	}
}
