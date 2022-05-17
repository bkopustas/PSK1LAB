package com.example.psk1lab.usecases;

import com.example.psk1lab.mybatis.model.Song;
import com.example.psk1lab.mybatis.dao.GenreMapper;
import com.example.psk1lab.mybatis.dao.SongMapper;
import com.example.psk1lab.mybatis.dao.SongsGenreMapper;
import com.example.psk1lab.mybatis.model.Genre;
import com.example.psk1lab.mybatis.model.SongsGenre;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

import static javax.faces.context.FacesContext.getCurrentInstance;

@Model
public class GenreSongsMB {
    @Inject
    private SongMapper songMapper;

    @Inject
    private GenreMapper genreMapper;

    @Inject
    private SongsGenreMapper songsGenreMapper;

    @Getter
    @Setter
    private Genre genre;

    @Getter
    @Setter
    private Song songToAdd = new Song();

    @Getter
    private List<Song> allExistingSongs;

    @Transactional
    public String addSongForGenre(Long songId) {
        if (songsGenreMapper.getResultCountBySongAndGenreId(songId, this.genre.getId()) == 0) {
            SongsGenre songsGenre = new SongsGenre();
            songsGenre.setSongId(songId);
            songsGenre.setGenreId(this.genre.getId());
            songsGenreMapper.insert(songsGenre);
        }
        return "/myBatis/genresAndSongs?faces-redirect=true";
    }

    @Transactional
    public String addNewSongForGenre() {
        if (songMapper.getResultCountBySongTitle(songToAdd.getTitle()) == 0) {
            songMapper.insert(songToAdd);
        }
        Song addedSong = songMapper.findByName(songToAdd.getTitle());
        SongsGenre songsGenre = new SongsGenre();
        songsGenre.setSongId(addedSong.getId());
        songsGenre.setGenreId(this.genre.getId());
        songsGenreMapper.insert(songsGenre);
        return "/myBatis/genresAndSongs?faces-redirect=true";
    }

    @PostConstruct
    private void init() {
        Map<String, String > requestParams = getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap();

        Long genreId = Long.parseLong(requestParams.get("genreId"));
        this.genre = genreMapper.selectByPrimaryKey(genreId);
        this.allExistingSongs = this.songMapper.selectAll();
    }
}
