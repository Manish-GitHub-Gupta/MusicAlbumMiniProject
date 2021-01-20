package com.rest.main.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rest.main.entity.MusicAlbum;
import com.rest.main.entity.Musicians;
import com.rest.main.service.IMusicAlbumService;

@RestController
@RequestMapping("/MusicAlbum")
public class MusicController 
{
	
	@Autowired
	private IMusicAlbumService albumService;
	
	@PostMapping("/createMusicAlbumWithMusicians")
	public String createData(@RequestBody MusicAlbum album)
	{
		return albumService.createMusicAlbumData(album , true);
	}
	
	@PutMapping("/updateMusicAlbumWithMusicians/{albumID}")
	public String updateData(@PathVariable Long albumID ,  @RequestBody MusicAlbum album)
	{
		return albumService.updateMusicAlbumData(albumID, album);
	}
	
	@GetMapping("/getMusicAlbumOrderByReleaseDate")
	public List<MusicAlbum> getMusicAlbumOrderByReleaseDate()
	{
		return albumService.findByOrderByAlbumReleaseDate();
	}
	
	@GetMapping("/getMusicAlbumOrderByPrice")
	public List<MusicAlbum> getMusicAlbumOrderByPrice()
	{
		return albumService.getMusicAlbumPriceAsc();
	}
	
	@GetMapping("/getMusicianOrderByName")
	public List<Musicians> getMusicianOrderByName()
	{
		return albumService.getMusicianOrderByName();
	}
}
