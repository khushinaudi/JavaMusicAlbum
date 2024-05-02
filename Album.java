package com.khushi;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    //it's always a good practice to have an empty constructor, even if we don't use it
    public Album(){
    }

    //this will be of type Song -> check through the loop if song exists or not
    public Song findSong(String title){

        for(Song checkedSong: songs ){
            //if the song is already in the list, returnt the song
            if(checkedSong.getTitle().equals(title)){
                return checkedSong;
            }
        }
        //if song doesnt exist in the list -> return null
        return null;
    }

    public boolean addSong(String title, double duration){

        if(findSong(title)==null){    //if song doesn't already exist in our list -> we will add the song to the list
            songs.add(new Song(title,duration));
//            System.out.println(title + " successfully added to list");
            return true;
        }

        else {
//            System.out.println(title + "already exists in the list");
            return false;
        }
    }


    //adds the song ie already present in the album to the playList
    public boolean addToPlaylist(int trackNumber, LinkedList<Song>PlayList){
        //we need a LinkList as we want to track the prev song and the next song
        //index starts numbering from 0 but track_number starts numbering from 1
        int index = trackNumber -1;
        if(index>0 && index <= this.songs.size()){
            PlayList.add(this.songs.get(index));
            return true;
        }

//        System.out.println("This album doesn't have song with track_number " + trackNumber);
        return false;

    }

    //we have 2 addToPlaylist methods with different parameters
    //User can add songs with either trackNumber and PlayList or title and PlayList
    public boolean addToPlaylist(String title, LinkedList<Song>PlayList){
        for(Song checkedSong: this.songs){
            if(checkedSong.getTitle().equals(title)){
                PlayList.add(checkedSong);
                return true;
            }
        }
//        System.out.println("There is no such song with title " + title + " in the album");
        return false;
    }


}

