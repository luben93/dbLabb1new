package model;

import java.util.ArrayList;

public class Artist {
private ArrayList<String> artists;

public Artist(String[] artist){
	artists= new ArrayList<String>();
	for(int i=0;i<artist.length;i++){
		this.artists.add(artist[i]);
	}
}

public Artist(){
	artists= new ArrayList<String>();
}

public ArrayList<String> getArtist(){
	return  (ArrayList<String>) artists.clone();
}


public void addArtist(String artist){
	artists.add(artist);
}
}