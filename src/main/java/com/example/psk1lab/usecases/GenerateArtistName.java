package com.example.psk1lab.usecases;

import com.example.psk1lab.interceptors.LoggedInvocation;
import com.example.psk1lab.services.ArtistNameGenerator;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class GenerateArtistName implements Serializable{
    @Inject
    ArtistNameGenerator artistNameGenerator;

    private CompletableFuture<String> artistNameGenerationTask = null;

    @LoggedInvocation
    public String generateNewArtistName(){
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        artistNameGenerationTask = CompletableFuture.supplyAsync(() -> artistNameGenerator.generateArtistName());

        return "artistDetails?faces-redirect=true&artistId=" + requestParameters.get("artistId");
    }

    public boolean isArtistNameGenerationRunning(){
        return artistNameGenerationTask != null && !artistNameGenerationTask.isDone();
    }

    public String getArtistNameGeneratorStatus() throws ExecutionException, InterruptedException {
        if (artistNameGenerationTask == null) {
            return null;
        } else if (isArtistNameGenerationRunning()){
            return "First Name Generator in progress";
        }
        return "Suggested name: " + artistNameGenerationTask.get();
    }
}
