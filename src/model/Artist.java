package model;

import java.util.ArrayList;

public class Artist {
private ArrayList<String> artists;

public Artist(ArrayList<String> artist){
	//artists= new ArrayList<String>();
	artists= (ArrayList<String>) artist.clone();
}

public Artist(){
	artists= new ArrayList<String>();
}

public ArrayList<String> getAllArtist(){
	return  (ArrayList<String>) artists.clone();
}


public void addArtist(String artist){
	artists.add(artist);
}
}