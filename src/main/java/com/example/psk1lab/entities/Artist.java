package com.example.psk1lab.entities;


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
        @NamedQuery(name = "Artist.findAll", query = "select art from Artist as art ")
})
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
@Table(name = "ARTIST")

public class Artist implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "ARTIST_NAME", nullable = false, unique = true)
    private String artistName;

    @OneToMany(mappedBy = "artist")
    private List<Song> songs = new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        Artist artist = (Artist) o;
        return id.equals(artist.id) && artistName.equals(artist.artistName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, artistName);
    }
}
