package com.javafee.springdemo.controller;

import java.util.*;

import com.javafee.springdemo.entity.Numerator;
import com.javafee.springdemo.service.NumeratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javafee.springdemo.entity.Customer;
import com.javafee.springdemo.service.CustomerService;

@Controller
@RequestMapping("/numerator")
public class CustomerController {
	@Autowired
	private NumeratorService numeratorService;
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listNumerators(Model model) {
		List<Numerator> numerators = numeratorService.getNumerators();
		model.addAttribute("numerators", numerators);
		return "list-numerator";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Numerator numerator = new Numerator();
		model.addAttribute("numerator", numerator);
		return "numerator-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("numeratorId") int id,  Model model) {
		Numerator numerator = numeratorService.getNumeratorById(id);
		model.addAttribute("numerator", numerator);
		return "numerator-form";
	}

	@GetMapping("/search")
	public String search(@RequestParam("searchValue") String searchValue, Model model) {
		List<Numerator> numerators = numeratorService.searchNumeratorsByValue(searchValue);
		model.addAttribute("numerators", numerators);
		return  "list-numerator";
	}

	@GetMapping("/deleteNumerator")
	public String deleteCustomer(@RequestParam("numeratorId") int id) {
		numeratorService.deleteNumeratorById(id);
		return "redirect:/numerator/list";
	}

	@PostMapping("/saveNumerator")
	public String saveNumerator(@ModelAttribute("numerator") Numerator numerator) {
		numerator.setAddition_date(new Date());
		//TODO check is palindrome
		numeratorService.saveNumerator(numerator);
		return "redirect:/numerator/list";
	}

	//Map<String,Object> model
	@GetMapping("/check")
	public String checkNumberIsPalindrome(@RequestParam("checkNumerator") String value, Model model) {
		if (value != null && value.trim().length() > 0 && Integer.parseInt(value) >= 0) {
			int numeratorValue= Integer.parseInt(value);
			boolean isPalindrome = numeratorService.checkNumberIsPalindrome(numeratorValue);
			Numerator numerator= new Numerator(null, numeratorValue, new Date(), isPalindrome);
			model.addAttribute("nr", numerator);
		}
		//model.put(value,isPalindrome);
		return "redirect:/numerator/list";
	}
	@GetMapping("/showFormForGenerate")
	public String generate(@RequestParam("startingPoint") int startPoint, @RequestParam("endingPoint") int endPoint, Model model) {
		int interval[]={startPoint,endPoint};
		Set<Numerator> numerators = numeratorService.generatePalindromesFromSpecificInterval(interval);
		model.addAttribute("generatedNumerators", numerators);
		return "list-palindromes";
	}
}
