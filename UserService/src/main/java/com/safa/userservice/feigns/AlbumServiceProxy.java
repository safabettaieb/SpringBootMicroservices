package com.safa.userservice.feigns;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.safa.userservice.dto.AlbumDTO;

@FeignClient(name = "album-service" , url="http://localhost:8010/album-service")
@RequestMapping("/api/albums")
public interface AlbumServiceProxy {
	
	@GetMapping("/user/{userId}")
	public List<AlbumDTO> getUserAlbums(@PathVariable Long userId);
	

}
