package com.example.psk1lab.mybatis.model;

public class SongsGenre {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.SONGS_GENRE.GENRE_ID
     *
     * @mbg.generated Wed May 11 10:29:50 EEST 2022
     */
    private Integer genreId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.SONGS_GENRE.SONG_ID
     *
     * @mbg.generated Wed May 11 10:29:50 EEST 2022
     */
    private Integer songId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.SONGS_GENRE.GENRE_ID
     *
     * @return the value of PUBLIC.SONGS_GENRE.GENRE_ID
     *
     * @mbg.generated Wed May 11 10:29:50 EEST 2022
     */
    public Integer getGenreId() {
        return genreId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.SONGS_GENRE.GENRE_ID
     *
     * @param genreId the value for PUBLIC.SONGS_GENRE.GENRE_ID
     *
     * @mbg.generated Wed May 11 10:29:50 EEST 2022
     */
    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.SONGS_GENRE.SONG_ID
     *
     * @return the value of PUBLIC.SONGS_GENRE.SONG_ID
     *
     * @mbg.generated Wed May 11 10:29:50 EEST 2022
     */
    public Integer getSongId() {
        return songId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.SONGS_GENRE.SONG_ID
     *
     * @param songId the value for PUBLIC.SONGS_GENRE.SONG_ID
     *
     * @mbg.generated Wed May 11 10:29:50 EEST 2022
     */
    public void setSongId(Integer songId) {
        this.songId = songId;
    }
}