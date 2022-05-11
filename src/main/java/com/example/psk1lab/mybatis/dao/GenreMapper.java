package com.example.psk1lab.mybatis.dao;

import com.example.psk1lab.mybatis.model.Genre;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface GenreMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.GENRE
     *
     * @mbg.generated Wed May 11 10:29:50 EEST 2022
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.GENRE
     *
     * @mbg.generated Wed May 11 10:29:50 EEST 2022
     */
    int insert(Genre record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.GENRE
     *
     * @mbg.generated Wed May 11 10:29:50 EEST 2022
     */
    Genre selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.GENRE
     *
     * @mbg.generated Wed May 11 10:29:50 EEST 2022
     */
    List<Genre> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.GENRE
     *
     * @mbg.generated Wed May 11 10:29:50 EEST 2022
     */
    int updateByPrimaryKey(Genre record);
}