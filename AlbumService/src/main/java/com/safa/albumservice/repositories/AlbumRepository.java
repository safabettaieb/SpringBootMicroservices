package com.safa.albumservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safa.albumservice.entities.Album;

public interface AlbumRepository extends JpaRepository<Album, Long>  {

}
