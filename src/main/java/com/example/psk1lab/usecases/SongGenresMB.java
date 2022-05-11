package com.example.psk1lab.usecases;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Map;

import java.io.Serializable;
        import java.util.Map;

        import javax.annotation.PostConstruct;
        import javax.enterprise.inject.Model;
        import javax.faces.context.FacesContext;
        import javax.inject.Inject;

        import lombok.Getter;
        import lombok.Setter;
        import com.example.psk1lab.mybatis.dao.SongMapper;
        import com.example.psk1lab.mybatis.model.Song;

@Model
public class SongGenresMB implements Serializable {

    @Inject
    private SongMapper songMapper;

    @Getter
    @Setter
    private Song song;

    @Getter
    @Setter
    private Song songToCreate = new Song();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer songId = Integer.parseInt(requestParameters.get("songId"));
        this.song = songMapper.selectByPrimaryKey(songId);
    }

}