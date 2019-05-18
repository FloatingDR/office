package com.easy.office.mapper;

import com.easy.office.model.UserFileCollect;

import java.util.List;

/**
 * @author taylor
 * @date 2019.5.1
 */
public interface UserFileCollectMapper {

    /**
     * get file ids by userId
     * @param userId
     * @return
     */
    List<Integer>getFileIdsByUserId(Integer userId);

    int deleteByPrimaryKey(Integer id);

    int insert(UserFileCollect record);

    int insertSelective(UserFileCollect record);

    UserFileCollect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserFileCollect record);

    int updateByPrimaryKey(UserFileCollect record);
}