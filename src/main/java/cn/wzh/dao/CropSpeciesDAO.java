package cn.wzh.dao;

import cn.wzh.entity.CropSpecies;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * CropSpeciesDAO继承基类
 */
@Repository
public interface CropSpeciesDAO extends MyBatisBaseDao<CropSpecies, Integer> {
    List<CropSpecies> findAll();
}