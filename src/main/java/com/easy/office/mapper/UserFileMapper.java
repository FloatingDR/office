package com.easy.office.mapper;

import com.easy.office.model.UserFile;

import java.util.List;

/**
 * @author taylor
 * @date 2019.5.1
 */
public interface UserFileMapper {

    /**
     * get my file ids
     * @param userId
     * @return
     */
    List<Integer> getMyFileIds(Integer userId);

    int deleteByPrimaryKey(Integer id);

    int insert(UserFile record);

    int insertSelective(UserFile record);

    UserFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserFile record);

    int updateByPrimaryKey(UserFile record);
}