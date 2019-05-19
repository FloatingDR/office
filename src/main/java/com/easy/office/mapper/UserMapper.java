package com.easy.office.mapper;

import com.easy.office.model.User;

/**
 * @author taylor
 */
public interface UserMapper {
    /**
     * 通过用户名查询所有信息
     *
     * @param username
     * @return
     */
    User getInfoByUsername(String username);

    /**
     * 插入用户
     *
     * @param record
     * @return
     */
    int insert(User record);

    /**
     * 查找是否已有该用户名的用户
     *
     * @param record
     * @return userId,-1
     */
    int selectByUsername(User record);

    /**
     * 更新用户信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 根据userId查询信息
     * @param userId
     * @return
     */
    User getInfoById(Integer userId);

    /**
     * 通过用户名得到权限角色
     * @param username
     * @return role_style
     */
    String getRoleStyle(String username);

    int deleteByPrimaryKey(Integer userId);

    int insertSelective(User record);

    int updateByPrimaryKey(User record);

}