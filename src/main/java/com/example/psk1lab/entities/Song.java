package com.example.psk1lab.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Song.findAll", query = "select s from Song as s ")
})
@Table(name = "SONG")
@Getter @Setter
public class Song implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "SONG_NAME", nullable = false)
    private String songName;

    @ManyToOne
    @JoinColumn(name = "ARTIST_ID")
    private Artist artist;

    @ManyToMany
    List<Genre> genre;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(id, song.id) && Objects.equals(songName, song.songName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, songName);
    }
}
