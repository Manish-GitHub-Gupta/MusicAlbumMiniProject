package com.rest.main.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Musicians")
public class Musicians 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long musicianID;

	private String musicianName;
	
	private String musicianType;
	
	@ManyToMany(mappedBy = "musician")
	Set<MusicAlbum> musicAlbums = new LinkedHashSet<>();

	public Long getMusicianID() {
		return musicianID;
	}

	public void setMusicianID(Long musicianID) {
		this.musicianID = musicianID;
	}

	public String getMusicianName() {
		return musicianName;
	}

	public void setMusicianName(String musicianName) {
		this.musicianName = musicianName;
	}

	public String getMusicianType() {
		return musicianType;
	}

	public void setMusicianType(String musicianType) {
		this.musicianType = musicianType;
	}

//	public Set<MusicAlbum> getMusicAlbums() {
//		return musicAlbums;
//	}
//
//	public void setMusicAlbums(Set<MusicAlbum> musicAlbums) {
//		this.musicAlbums = musicAlbums;
//	}

	@Override
	public String toString() {
		return "Musicians [musicianID=" + musicianID + ", musicianName=" + musicianName + ", musicianType="
				+ musicianType + "]";
	}
	
	
}
