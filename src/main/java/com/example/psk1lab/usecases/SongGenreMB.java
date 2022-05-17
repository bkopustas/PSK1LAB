package com.example.psk1lab.usecases;

import com.example.psk1lab.mybatis.model.Song;
import com.example.psk1lab.mybatis.dao.SongMapper;
import lombok.Getter;
import lombok.Setter;
import org.mybatis.cdi.Mapper;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Map;
@Mapper
public class SongGenreMB implements Serializable {
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
        Long songId = Long.parseLong(requestParameters.get("songId"));
        this.song = songMapper.selectByPrimaryKey(songId);
    }

}
