package com.rest.main.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.main.entity.MusicAlbum;
import com.rest.main.entity.Musicians;
import com.rest.main.exception.MusicAlbumCreationException;
import com.rest.main.exception.MusicAlbumNotFoundException;
import com.rest.main.repository.MusicAlbumRepository;
import com.rest.main.repository.MusiciansRepository;


@Service
public class MusicAlbumServiceImpl implements IMusicAlbumService 
{
	@Autowired
	private MusicAlbumRepository albumRepo;
	
	@Autowired
	private MusiciansRepository musicianRepo; 

	@Override
	public String createMusicAlbumData(MusicAlbum album , Boolean flag) 
	{
		if(album.getAlbumName() == null || album.getAlbumName().length() < 5)
			throw new MusicAlbumCreationException("Album Name is Mandatory and Album Name size should be greater than 5.");
		
		if(album.getAlbumReleaseDate() == null)
			throw new MusicAlbumCreationException("Album Release Date is Mandatory.");
		
		if(album.getAlbumPrice() == null || album.getAlbumPrice() > 1000.0 || album.getAlbumPrice() < 100.0)
			throw new MusicAlbumCreationException("Album Price is Mandatory and Price should not be less than 100.0 and not be more than 1000.0");

		Set<Musicians> setmusicians = album.getMusician();
		for(Musicians musicians : setmusicians)
		{
			if(musicians.getMusicianName().length() < 3)
				throw new MusicAlbumCreationException("Musician Name is Mandatory and Musician Name size should be 3 or more.");
		}
		if (flag == true)
		albumRepo.save(album);
		return "Music Album Id : " + album.getAlbumID() + " has been created.";
	}

	@Override
	public String updateMusicAlbumData(Long albumID , MusicAlbum updatedAlbumData) 
	{
		MusicAlbum albumData = albumRepo.findById(albumID).orElseThrow(() -> new MusicAlbumNotFoundException("Music Album ID : " + albumID + " Not Available."));
		
		if(updatedAlbumData.getAlbumName()!=null)
			albumData.setAlbumName(updatedAlbumData.getAlbumName());
		if(updatedAlbumData.getAlbumReleaseDate()!=null)
			albumData.setAlbumReleaseDate(updatedAlbumData.getAlbumReleaseDate());
		if(updatedAlbumData.getAlbumGenre()!=null)
			albumData.setAlbumGenre(updatedAlbumData.getAlbumGenre());
		if(updatedAlbumData.getAlbumPrice()!=null)
			albumData.setAlbumPrice(updatedAlbumData.getAlbumPrice());
		if(updatedAlbumData.getAlbumDescription()!=null)
			albumData.setAlbumDescription(updatedAlbumData.getAlbumDescription());
		
		//To check the Validations
		createMusicAlbumData(albumData , false);
		albumRepo.save(albumData);
		
		Set<Musicians> musicians = updatedAlbumData.getMusician();
		for(Musicians updatedMusician : musicians)
		{
			Musicians musicianData = musicianRepo.findById(updatedMusician.getMusicianID()).orElseThrow(() -> new MusicAlbumNotFoundException("Musician ID : " + updatedMusician.getMusicianID() + " Not Available."));
			if(updatedMusician.getMusicianName().length() < 3)
				throw new MusicAlbumCreationException("Musician Name is Mandatory and Musician Name size should be 3 or more.");
			if(updatedMusician.getMusicianName() != null)
				musicianData.setMusicianName(updatedMusician.getMusicianName());
			if(updatedMusician.getMusicianType()!=null)
				musicianData.setMusicianType(updatedMusician.getMusicianType());
			musicianRepo.save(musicianData);
		}
		
		return "Music Album Id : " + albumID + " has been updated.";
	}

	@Override
	public List<MusicAlbum> findByOrderByAlbumReleaseDate() 
	{
		return albumRepo.findByOrderByAlbumReleaseDate();
	}

	@Override
	public List<MusicAlbum> getMusicAlbumPriceAsc() 
	{
		return albumRepo.getMusicAlbumPriceAsc();
	}

	@Override
	public List<Musicians> getMusicianOrderByName() 
	{
		return albumRepo.getMusicianOrderByName();
	}
}
