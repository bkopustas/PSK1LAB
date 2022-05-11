package com.example.psk1lab.mybatis.dao;

import com.example.psk1lab.mybatis.model.SongsGenre;
import org.apache.ibatis.annotations.Param;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface SongsGenreMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SONGS_GENRE
     *
     * @mbg.generated Wed May 11 10:29:50 EEST 2022
     */
    int insert(SongsGenre record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SONGS_GENRE
     *
     * @mbg.generated Wed May 11 10:29:50 EEST 2022
     */
    List<SongsGenre> selectAll();

    int getResultCountBySongAndGenreId(@Param("songId") Integer songId, @Param("genreId") Integer genreId);
}