package cn.wzh.dao;

import cn.wzh.entity.BacterialStrainInfo;

import java.util.List;

public interface BacterialStrainInfoDao extends MyBatisBaseDao<BacterialStrainInfo, Integer> {
    int deleteByPrimaryKey(Integer id);

    int insert(BacterialStrainInfo record);

    int insertSelective(BacterialStrainInfo record);

    BacterialStrainInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BacterialStrainInfo record);

    int updateByPrimaryKey(BacterialStrainInfo record);

    int insertList(List<BacterialStrainInfo> bacterialStrainInfoList);
}