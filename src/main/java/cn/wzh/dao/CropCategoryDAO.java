package cn.wzh.dao;

import cn.wzh.entity.CropCategory;
import org.springframework.stereotype.Repository;

/**
 * CropCategoryDAO继承基类
 */
@Repository
public interface CropCategoryDAO extends MyBatisBaseDao<CropCategory, Integer> {
}