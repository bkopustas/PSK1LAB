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
import com.example.psk1lab.mybatis.model.Genre;
import com.example.psk1lab.mybatis.model.Song;
import com.example.psk1lab.mybatis.model.SongsGenre;
import lombok.Getter;
import lombok.Setter;




@Model
public class GenreSongsMB implements Serializable {

    @Inject
    private SongMapper SongMapper;

    @Inject
    private GenreMapper genreMapper;

    @Inject
    private com.example.psk1lab.mybatis.dao.SongsGenreMapper SongsGenreMapper;

    @Getter
    @Setter
    private Genre genre;

    @Getter
    @Setter
    private Song SongToAdd = new Song();

    @Getter
    private List<Song> allExistingSongs;

    @Transactional
    public String addSongForGenre(Integer SongId) {
        if (SongsGenreMapper.getResultCountBySongAndGenreId(SongId, this.genre.getId()) == 0) {
            SongsGenre SongsGenre = new SongsGenre();
            SongsGenre.setSongId(SongId);
            SongsGenre.setGenreId(this.genre.getId());
            SongsGenreMapper.insert(SongsGenre);
        }
        return "/myBatis/genresAndSongs?faces-redirect=true";
    }

    @Transactional
    public String addNewSongForGenre() {
        if (SongMapper.getResultCountBySongName(SongToAdd.getSongName()) == 0) {
            SongMapper.insert(SongToAdd);
        }
        Song addedSong = SongMapper.findByName(SongToAdd.getSongName());
        SongsGenre SongsGenre = new SongsGenre();
        SongsGenre.setSongId(addedSong.getId());
        SongsGenre.setGenreId(this.genre.getId());
        SongsGenreMapper.insert(SongsGenre);
        return "/myBatis/genresAndSongs?faces-redirect=true";
    }

    @PostConstruct
    private void init() {
        Map<String, String > requestParams = getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap();

        Long genreId = Long.parseLong(requestParams.get("genreId"));
        this.genre = genreMapper.selectByPrimaryKey(genreId);
        this.allExistingSongs = this.SongMapper.selectAll();
    }
}

