package com.tencoding.wonilblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

	@GetMapping({"", "/"})
	public String index() {
		return "home";
	}
}
