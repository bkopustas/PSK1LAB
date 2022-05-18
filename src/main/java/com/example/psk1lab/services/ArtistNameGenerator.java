package com.example.psk1lab.services;

import org.h2.result.SearchRow;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Random;

@ApplicationScoped
public class ArtistNameGenerator implements Serializable {
    public String generateArtistName() {
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
        Random random = new Random();
        String generatedArtistName = random.ints(97, 123)
                .limit(10)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedArtistName;
    }
}
