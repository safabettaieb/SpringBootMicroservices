package com.safa.albumservice.jpa;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.safa.albumservice.dto.AlbumDTO;
import com.safa.albumservice.entities.Album;
import com.safa.albumservice.repositories.AlbumRepository;
import com.safa.albumservice.services.AlbumService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AlbumServiceImp implements AlbumService {

	private AlbumRepository albumRepository;
	private ModelMapper mapper;

	@Override
	public AlbumDTO addAlbum(AlbumDTO albumDTO) {
		Album albumEntity = mapper.map(albumDTO, Album.class);
		albumRepository.save(albumEntity);
		return albumDTO;
	}

	@Override
	public List<AlbumDTO> getUserAlbums(Long userId) {

		List<Album> albumsEntity = new ArrayList<>();
		albumRepository.findByUserId(userId).forEach(albumsEntity::add);

		List<AlbumDTO> DtoList = mapper.map(albumsEntity, new TypeToken<List<AlbumDTO>>() {
		}.getType());
		return DtoList;
	}

}
