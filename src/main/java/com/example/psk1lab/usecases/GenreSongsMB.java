package com.example.psk1lab.usecases;

import static javax.faces.context.FacesContext.getCurrentInstance;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.example.psk1lab.mybatis.dao.GenreMapper;
import com.example.psk1lab.mybatis.dao.SongMapper;
import com.example.psk1lab.mybatis.dao.SongsGenreMapper;
import com.example.psk1lab.mybatis.model.Genre;
import com.example.psk1lab.mybatis.model.Song;
import com.example.psk1lab.mybatis.model.SongsGenre;
import lombok.Getter;
import lombok.Setter;




@Model
public class GenreSongsMB implements Serializable {

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
    public String addSongForGenre(Integer SongId) {
        if (songsGenreMapper.getResultCountBySongAndGenreId(SongId, this.genre.getId()) == 0) {
            SongsGenre SongsGenre = new SongsGenre();
            SongsGenre.setSongId(SongId);
            SongsGenre.setGenreId(this.genre.getId());
            songsGenreMapper.insert(SongsGenre);
        }
        return "/myBatis/genresAndSongs?faces-redirect=true";
    }

    @Transactional
    public String addNewSongForGenre() {
        if (songMapper.getResultCountBySongName(songToAdd.getSongName()) == 0) {
            songMapper.insert(songToAdd);
        }
        Song addedSong = songMapper.findByName(songToAdd.getSongName());
        SongsGenre SongsGenre = new SongsGenre();
        SongsGenre.setSongId(addedSong.getId());
        SongsGenre.setGenreId(this.genre.getId());
        songsGenreMapper.insert(SongsGenre);
        return "/myBatis/genresAndSongs?faces-redirect=true";
    }

    @PostConstruct
    private void init() {
        Map<String, String > requestParams = getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap();

        Integer genreId = Integer.parseInt(requestParams.get("genreId"));
        this.genre = genreMapper.selectByPrimaryKey(genreId);
        this.allExistingSongs = this.songMapper.selectAll();
    }
}

