package com.example.psk1lab.rest;


import com.example.psk1lab.entities.Artist;
import com.example.psk1lab.entities.Song;
import com.example.psk1lab.persistence.SongDAO;
import com.example.psk1lab.rest.contracts.SongDto;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@ApplicationScoped
@Path("/songs")
public class SongsController {
    @Inject
    @Getter
    @Setter
    private SongDAO songDAO;

    @Getter @Setter
    private Artist artist;

    // http://localhost:8080/PSK-TP-1-1.0-SNAPSHOT/api/songs/1
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Long id) {
        Song song = songDAO.findOne(id);

        if (song == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        SongDto songDto = new SongDto();
        songDto.setSongName(song.getTitle());
        songDto.setArtistName(song.getArtist().getName());

        return Response.ok(songDto).build();
    }

    // http://localhost:8080/PSK1LAB-1.0-SNAPSHOT/api/songs/1
    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") final Long songId, SongDto songDto) {
        try {
            Song existingSong = songDAO.findOne(songId);
            if (existingSong == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingSong.setTitle(songDto.getSongName());
            existingSong.getArtist().setName(songDto.getArtistName());
            songDAO.update(existingSong);
            return Response.ok().build();
        } catch (OptimisticLockException e) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
