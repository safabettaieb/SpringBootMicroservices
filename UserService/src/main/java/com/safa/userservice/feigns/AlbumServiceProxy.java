package com.safa.userservice.feigns;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.safa.userservice.dto.AlbumDTO;

@FeignClient(name = "album-service" , url="localhost:8010")
public interface AlbumServiceProxy {
	
	@GetMapping("/user/{userId}")
	public List<AlbumDTO> getUserAlbums(@PathVariable Long UserId);

}
