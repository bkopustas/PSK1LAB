package com.example.psk1lab.alternatives;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Alternative;

@Dependent
@Alternative
public class AltSongMessage implements Message{

    @Override
    public String WriteMessage(){
        return "Alternative song created";
    }
    public AltSongMessage(){}
}
