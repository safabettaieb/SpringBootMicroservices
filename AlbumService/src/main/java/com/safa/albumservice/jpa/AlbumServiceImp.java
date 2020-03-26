package com.safa.albumservice.jpa;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.safa.albumservice.dto.AlbumDTO;
import com.safa.albumservice.entities.Album;
import com.safa.albumservice.repositories.AlbumRepository;
import com.safa.albumservice.services.AlbumService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AlbumServiceImp implements AlbumService{
	
	private AlbumRepository albumRepository;
	private ModelMapper mapper;
	@Override
	public AlbumDTO addAlbum(AlbumDTO albumDTO) {
		Album albumEntity = mapper.map(albumDTO, Album.class);
		albumRepository.save(albumEntity);
		return albumDTO ; 
	}
	

}
