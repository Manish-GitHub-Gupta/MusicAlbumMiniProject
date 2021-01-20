package com.rest.main.exception;

public class MusicAlbumNotFoundException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	public MusicAlbumNotFoundException()
	{
		super();
	}
	public MusicAlbumNotFoundException(String msg)
	{
		super(msg);
	}
	
}
