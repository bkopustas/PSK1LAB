package com.example.psk1lab.entities;

import lombok.Getter;
import lombok.Setter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@NamedQueries({
        @NamedQuery(name = "Song.findAll", query = "SELECT s FROM Song AS s")
})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "SONG")
public class Song implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name="ARTIST_ID")
    private Artist artist;

    @ManyToMany(mappedBy = "songs")
    List<Genre> genres;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Song song = (Song) o;
        return id.equals(song.id) && title.equals(song.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}