package com.learning.sitemeshdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class commonController {

	@GetMapping("/index")
	public String getIndexPage() {
		return "index";
	}
}
