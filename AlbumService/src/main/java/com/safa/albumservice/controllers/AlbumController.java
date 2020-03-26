package com.safa.albumservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {
	@Autowired
	private Environment environment;

	@GetMapping({ "", "/", "/welcome" })
	public String welcome() {

		return "Album Service runin on port : " + environment.getProperty("local.server.port");
	}

}
