package com.rest.main.entity;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MusicAlbum")
public class MusicAlbum 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long albumID;
	
	private String albumName;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date albumReleaseDate;
	
	private String albumGenre;
	
	private Double albumPrice;
	
	private String albumDescription;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Album_Musician",joinColumns = @JoinColumn(name = "MusicAlbum_ID",referencedColumnName = "albumID"),
	inverseJoinColumns = @JoinColumn(name="Musician_ID",referencedColumnName = "musicianID"))
	Set<Musicians> musician = new LinkedHashSet<>();

	public Long getAlbumID() {
		return albumID;
	}

	public void setAlbumID(Long albumID) {
		this.albumID = albumID;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public Date getAlbumReleaseDate() {
		return albumReleaseDate;
	}

	public void setAlbumReleaseDate(Date albumReleaseDate) {
		this.albumReleaseDate = albumReleaseDate;
	}

	public String getAlbumGenre() {
		return albumGenre;
	}

	public void setAlbumGenre(String albumGenre) {
		this.albumGenre = albumGenre;
	}

	public Double getAlbumPrice() {
		return albumPrice;
	}

	public void setAlbumPrice(Double albumPrice) {
		this.albumPrice = albumPrice;
	}

	public String getAlbumDescription() {
		return albumDescription;
	}

	public void setAlbumDescription(String albumDescription) {
		this.albumDescription = albumDescription;
	}

	public Set<Musicians> getMusician() {
		return musician;
	}

	public void setMusician(Set<Musicians> musician) {
		this.musician = musician;
	}

	@Override
	public String toString() {
		return "MusicAlbum [albumID=" + albumID + ", albumName=" + albumName + ", albumReleaseDate=" + albumReleaseDate
				+ ", albumGenre=" + albumGenre + ", albumPrice=" + albumPrice + ", albumDescription=" + albumDescription
				+ ", musician=" + musician + "]";
	}
	
	
}
