package com.example.psk1lab.alternatives;

import javax.enterprise.context.Dependent;

@Dependent
public class SongMessage implements Message{

    @Override
    public String WriteMessage(){
        return "Song created";
    }
    public SongMessage(){}
}
