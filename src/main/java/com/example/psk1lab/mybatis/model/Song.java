package com.example.psk1lab.mybatis.model;

public class Song {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.SONG.ID
     *
     * @mbg.generated Wed May 11 10:29:50 EEST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.SONG.SONG_NAME
     *
     * @mbg.generated Wed May 11 10:29:50 EEST 2022
     */
    private String songName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.SONG.ARTIST_ID
     *
     * @mbg.generated Wed May 11 10:29:50 EEST 2022
     */
    private Integer artistId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.SONG.ID
     *
     * @return the value of PUBLIC.SONG.ID
     *
     * @mbg.generated Wed May 11 10:29:50 EEST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.SONG.ID
     *
     * @param id the value for PUBLIC.SONG.ID
     *
     * @mbg.generated Wed May 11 10:29:50 EEST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.SONG.SONG_NAME
     *
     * @return the value of PUBLIC.SONG.SONG_NAME
     *
     * @mbg.generated Wed May 11 10:29:50 EEST 2022
     */
    public String getSongName() {
        return songName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.SONG.SONG_NAME
     *
     * @param songName the value for PUBLIC.SONG.SONG_NAME
     *
     * @mbg.generated Wed May 11 10:29:50 EEST 2022
     */
    public void setSongName(String songName) {
        this.songName = songName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.SONG.ARTIST_ID
     *
     * @return the value of PUBLIC.SONG.ARTIST_ID
     *
     * @mbg.generated Wed May 11 10:29:50 EEST 2022
     */
    public Integer getArtistId() {
        return artistId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.SONG.ARTIST_ID
     *
     * @param artistId the value for PUBLIC.SONG.ARTIST_ID
     *
     * @mbg.generated Wed May 11 10:29:50 EEST 2022
     */
    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }
}