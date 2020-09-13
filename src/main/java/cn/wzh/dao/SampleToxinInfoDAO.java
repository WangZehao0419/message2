package cn.wzh.dao;

import cn.wzh.entity.SampleToxinInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SampleToxinInfoDAO继承基类
 */
@Repository
public interface SampleToxinInfoDAO extends MyBatisBaseDao<SampleToxinInfo, Integer> {
    List<SampleToxinInfo> selectAll();
}