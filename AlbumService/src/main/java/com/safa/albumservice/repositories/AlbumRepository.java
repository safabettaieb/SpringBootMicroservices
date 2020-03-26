package com.safa.albumservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safa.albumservice.entities.Album;

public interface AlbumRepository extends JpaRepository<Album, Long>  {
	public List<Album> findByUserId(Long userId);
}
