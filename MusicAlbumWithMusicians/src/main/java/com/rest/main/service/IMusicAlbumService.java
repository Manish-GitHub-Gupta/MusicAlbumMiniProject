package com.rest.main.service;

import java.util.List;

import com.rest.main.entity.MusicAlbum;
import com.rest.main.entity.Musicians;

public interface IMusicAlbumService 
{
	String createMusicAlbumData(MusicAlbum album , Boolean flag);
	String updateMusicAlbumData(Long albumID, MusicAlbum album);
	
	List<MusicAlbum> findByOrderByAlbumReleaseDate();
	List<MusicAlbum> getMusicAlbumPriceAsc();
	
	List<Musicians> getMusicianOrderByName();
}
