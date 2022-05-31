package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Building;
import com.example.demo.models.GoldResult;

@Controller
public class HomeController {
	private HashMap<String, Building> buildings() {
		return Building.GetDefaultBuildingsMap();
	}
	
	private static String GOLD_KEY = "gold";
	private static String MESSAGE_KEY = "messages";
	
	@GetMapping("")
	public String index(HttpSession session, Model viewModel) {
		// initialize total gold (in session)
		if(session.getAttribute(GOLD_KEY) == null) {
			session.setAttribute(GOLD_KEY, 0);
		}
		// initialize messages (in session)
		if(session.getAttribute(MESSAGE_KEY) == null) {
			session.setAttribute(MESSAGE_KEY, new ArrayList<String>());
		}
		
		// prepare viewmodel properties
		viewModel.addAttribute("gold", session.getAttribute(GOLD_KEY));
		viewModel.addAttribute("messages", session.getAttribute(MESSAGE_KEY));
		viewModel.addAttribute("buildings", Building.GetDefaultBuildingsArray());
		
		return "index.jsp";
	}
	@PostMapping("")
	public String process(@RequestParam("building") String building, HttpSession session) {
		GoldResult result = Building.ProcessGold(this.buildings().get(building));
		// update total gold (in session)
		session.setAttribute(GOLD_KEY, (int)session.getAttribute(GOLD_KEY) + result.getGoldProcessed());
		
		// update total messages (in session)
		ArrayList<String> currentMessages = (ArrayList<String>)session.getAttribute(MESSAGE_KEY);
		currentMessages.add(result.getMessage());
		session.setAttribute(MESSAGE_KEY, currentMessages);
		
		return "redirect:/";
	}
}
