package com.example.psk1lab.mybatis.model;

public class Song {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.SONG.SONG_ID
     *
     * @mbg.generated Mon May 02 21:27:07 EEST 2022
     */
    private Integer songId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.SONG.ARTIST
     *
     * @mbg.generated Mon May 02 21:27:07 EEST 2022
     */
    private Integer artist;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.SONG.SONG_NAME
     *
     * @mbg.generated Mon May 02 21:27:07 EEST 2022
     */
    private String songName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.SONG.ALBUM_ID
     *
     * @mbg.generated Mon May 02 21:27:07 EEST 2022
     */
    private Integer albumId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.SONG.SONG_ID
     *
     * @return the value of PUBLIC.SONG.SONG_ID
     *
     * @mbg.generated Mon May 02 21:27:07 EEST 2022
     */
    public Integer getSongId() {
        return songId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.SONG.SONG_ID
     *
     * @param songId the value for PUBLIC.SONG.SONG_ID
     *
     * @mbg.generated Mon May 02 21:27:07 EEST 2022
     */
    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.SONG.ARTIST
     *
     * @return the value of PUBLIC.SONG.ARTIST
     *
     * @mbg.generated Mon May 02 21:27:07 EEST 2022
     */
    public Integer getArtist() {
        return artist;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.SONG.ARTIST
     *
     * @param artist the value for PUBLIC.SONG.ARTIST
     *
     * @mbg.generated Mon May 02 21:27:07 EEST 2022
     */
    public void setArtist(Integer artist) {
        this.artist = artist;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.SONG.SONG_NAME
     *
     * @return the value of PUBLIC.SONG.SONG_NAME
     *
     * @mbg.generated Mon May 02 21:27:07 EEST 2022
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
     * @mbg.generated Mon May 02 21:27:07 EEST 2022
     */
    public void setSongName(String songName) {
        this.songName = songName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.SONG.ALBUM_ID
     *
     * @return the value of PUBLIC.SONG.ALBUM_ID
     *
     * @mbg.generated Mon May 02 21:27:07 EEST 2022
     */
    public Integer getAlbumId() {
        return albumId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.SONG.ALBUM_ID
     *
     * @param albumId the value for PUBLIC.SONG.ALBUM_ID
     *
     * @mbg.generated Mon May 02 21:27:07 EEST 2022
     */
    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }
}