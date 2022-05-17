package com.example.psk1lab.qualifiers;


import javax.enterprise.context.Dependent;

@Cd
@Dependent
public class CdSongType implements SongTypeProcessor{
    @Override
    public String SongType(){
        return "Song type is CD";
    }
}
