package com.rest.main.exception;

public class MusicAlbumCreationException extends RuntimeException 
{

	private static final long serialVersionUID = 1L;
	public MusicAlbumCreationException()
	{
		super();
	}
	public MusicAlbumCreationException(String msg)
	{
		super(msg);
	}
	
	
}
