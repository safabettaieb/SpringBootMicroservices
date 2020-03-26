package com.safa.albumservice.services;

import java.util.List;

import com.safa.albumservice.dto.AlbumDTO;

public interface AlbumService {
	public AlbumDTO addAlbum(AlbumDTO albumDTO);
	public List<AlbumDTO>getUserAlbums(Long UserId);

}
