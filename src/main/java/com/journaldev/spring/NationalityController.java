package com.journaldev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.model.Nationality;
import com.journaldev.spring.service.NationalityService;

//test
@Controller
public class NationalityController {

	private NationalityService nationalityService;

	@Autowired(required = true)
	@Qualifier(value = "nationalityService")
	public void setNationalityService(NationalityService ps) {
		this.nationalityService = ps;
	}

	@RequestMapping(value = "/nationalities", method = RequestMethod.GET)
	public String listNationalities(Model model) {
		model.addAttribute("nationality", new Nationality());
		model.addAttribute("listNationalities",
				this.nationalityService.listNationalities());
		return "nationalities";
	}

	// For add and update nationality both
	@RequestMapping(value = "/nationality/add", method = RequestMethod.POST)
	public String addNationality(@ModelAttribute("nationality") Nationality p) {

		if (p.getId() == 0) {
			// new person, add it
			this.nationalityService.addNationality(p);
		} else {
			// existing person, call update
			this.nationalityService.updateNationality(p);
		}

		return "redirect:/nationalities";

	}

	// @RequestMapping("/remove/{id}")
	// public String removeNationality(@PathVariable("id") int id) {
	//
	// this.nationalityService.removeNationality(id);
	// return "redirect:/nationalities";
	// }
	//
	// @RequestMapping("/edit/{id}")
	// public String editNationality(@PathVariable("id") int id, Model model) {
	// model.addAttribute("nationality",
	// this.nationalityService.getNationalityById(id));
	// model.addAttribute("listNationalities",
	// this.nationalityService.listNationalities());
	// return "nationality";
	// }

}
