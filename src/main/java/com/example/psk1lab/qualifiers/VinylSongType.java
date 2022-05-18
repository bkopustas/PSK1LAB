package com.example.psk1lab.qualifiers;


import javax.enterprise.context.Dependent;

@Vinyl
@Dependent
public class VinylSongType implements SongTypeProcessor{
    public String SongType(){
        return "Song type is vinyl";
    }
}
