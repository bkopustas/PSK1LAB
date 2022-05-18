package com.example.psk1lab.rest;

import lombok.Getter;
import lombok.Setter;
import com.example.psk1lab.entities.Artist;
import com.example.psk1lab.persistence.ArtistDAO;
import com.example.psk1lab.rest.contracts.ArtistDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

@ApplicationScoped
@Path("/artists")
public class ArtistsController {
    @Inject
    @Getter @Setter
    private ArtistDAO artistDAO;

    @Inject
    private EntityManager entityManager;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Long id) {

        Artist artist = artistDAO.findOne(id);

        if (artist == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        ArtistDto artistDto = new ArtistDto();
        artistDto.setName(artist.getName());

        return Response.ok(artistDto).build();
    }

    // http://localhost:8080/PSK1LAB-1.0-SNAPSHOT/api/artists
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(ArtistDto artistDto) {

        try {
            if (artistDto == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            Artist artistToCreate = new Artist();
            artistToCreate.setName(artistDto.getName());
            artistDAO.persist(artistToCreate);

            URI location = UriBuilder.fromResource(ArtistsController.class)
                    .path("/{id}")
                    .resolveTemplate("id", artistToCreate.getId())
                    .build();

            return Response.created(location).build();
        } catch (OptimisticLockException e) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
