package com.xxl.job.admin.dao;

import com.xxl.job.admin.core.model.XxlJobGroup;
import com.xxl.job.admin.core.model.XxlJobLogChild;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by xuxueli on 16/9/30.
 */
@Mapper
public interface XxlJobLogChildDao {

    public List<XxlJobLogChild> findByTimeAndChildId(Map map);

    public int insertByTimeAndChildId(List list);

    public int updateByTimeAndChildId(Map map);

    public int updateSubByTimeAndChildId(Map map);





    public List<XxlJobGroup> pageList(@Param("offset") int offset,
                                      @Param("pagesize") int pagesize);

    public int pageListCount(@Param("offset") int offset,
                             @Param("pagesize") int pagesize);

}
