package com.safa.albumservice.controllers;

import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safa.albumservice.dto.AlbumDTO;
import com.safa.albumservice.services.AlbumService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/albums")
@AllArgsConstructor
public class AlbumController {
	
	private Environment environment;
	
	private AlbumService allbumService;

	@GetMapping({ "", "/", "/welcome" })
	public String welcome() {

		return "Album Service runin on port :  " + environment.getProperty("local.server.port");
	}
	
	@PostMapping("/add")
	public AlbumDTO addAlbum(@RequestBody AlbumDTO albumDTO) {
		return allbumService.addAlbum(albumDTO);
	}
	
	@GetMapping("/user/{userId}")
	public List<AlbumDTO> getUserAlbums(@PathVariable Long userId){
		return allbumService.getUserAlbums(userId);
		
	}
	

}
