package cn.wzh.dao;

import cn.wzh.entity.SampleToxin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SampleToxinDAO继承基类
 */
@Repository
public interface SampleToxinDAO extends MyBatisBaseDao<SampleToxin, Integer> {
    int insertList(@Param("sampleToxinList") List<SampleToxin> sampleToxinList);
}