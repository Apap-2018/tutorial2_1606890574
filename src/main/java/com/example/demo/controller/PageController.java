package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
	@RequestMapping(value= {"/challenge", "challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "KB");
		} return "challenge";	
	}
	
//	@RequestMapping("/challenge")
//	public String challenge(@RequestParam (value="name", required=false, defaultValue="kiki" ) String name, Model model) {
//		model.addAttribute("name", name);
//		return "challenge";
//	}
	
	@RequestMapping("/generator")
	public String generator(@RequestParam (value="a", required=false, defaultValue="0") int a, 
			@RequestParam (value="b", required=false, defaultValue="0") int b, Model model) {
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		String kata = "";
		String result = "";
		if (a==0 || a==1 || b==0 || b==1) {
			kata = "hm ";
			result = wordMultiplier(kata, b);
		} else {
			kata = "h";
			for (int i = 0; i < a; i++) {
				kata += "m";
			}
			kata = kata + " ";
			result = wordMultiplier(kata, b);
		}
		
		model.addAttribute("result", result);
		return "generator";
	}
	
	public String wordMultiplier(String kata, int b) {
		String result = "";
		for (int i = 0; i < b; i++) {
			result = result + kata;
		} return result;
	}
}
