package com.easy.office.mapper;

import com.easy.office.model.File;
import org.apache.ibatis.annotations.Param;

public interface FileMapper {


    /**
     * 根据fileId查询fileInfo
     * @param fileId
     * @return
     */
    File selectByPrimaryKey(Integer fileId);

    /**
     * get meetingId by meetingName or date.
     * @param path
     * @return
     */
    int getIdByPath(@Param("path") String path);


    int deleteByPrimaryKey(Integer fileId);

    int insert(File record);

    int insertSelective(File record);

    int updateByPrimaryKeySelective(File record);

    int updateByPrimaryKey(File record);
}