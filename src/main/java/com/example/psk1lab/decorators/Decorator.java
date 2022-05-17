package com.example.psk1lab.decorators;

import javax.enterprise.context.Dependent;

@Dependent
public class Decorator implements ArtistDecorator{

    @Override
    public Integer DecoratedInt (Integer integer){
        return integer;
    }

}
