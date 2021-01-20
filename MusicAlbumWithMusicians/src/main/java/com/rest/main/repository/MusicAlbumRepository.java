package com.rest.main.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rest.main.entity.MusicAlbum;
import com.rest.main.entity.Musicians;

@Repository
public interface MusicAlbumRepository extends JpaRepository<MusicAlbum, Long> 
{
	List<MusicAlbum> findByOrderByAlbumReleaseDate();
	Optional<MusicAlbum> findById(Long id);
	
	@Query("SELECT m FROM MusicAlbum m ORDER BY albumPrice")
	List<MusicAlbum> getMusicAlbumPriceAsc();
	
	@Query("SELECT m FROM Musicians m ORDER BY musicianName")
	List<Musicians> getMusicianOrderByName();
}
