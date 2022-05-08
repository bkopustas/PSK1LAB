package com.example.psk1lab.mybatis.dao;

import com.example.psk1lab.mybatis.model.Album;
import com.example.psk1lab.mybatis.model.Artist;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface AlbumMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ALBUM
     *
     * @mbg.generated Mon May 02 21:27:07 EEST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ALBUM
     *
     * @mbg.generated Mon May 02 21:27:07 EEST 2022
     */
    int insert(Album record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ALBUM
     *
     * @mbg.generated Mon May 02 21:27:07 EEST 2022
     */
    Album selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ALBUM
     *
     * @mbg.generated Mon May 02 21:27:07 EEST 2022
     */
    List<Album> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ALBUM
     *
     * @mbg.generated Mon May 02 21:27:07 EEST 2022
     */
    int updateByPrimaryKey(Album record);

    Artist getAlbumArtist(Integer id);
}