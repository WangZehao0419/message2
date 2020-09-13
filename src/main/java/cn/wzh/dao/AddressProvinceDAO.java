package cn.wzh.dao;

import cn.wzh.entity.AddressProvince;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * AddressProvinceDAO继承基类
 */
@Repository
public interface AddressProvinceDAO extends MyBatisBaseDao<AddressProvince, Integer> {
    List<AddressProvince> selectAll();
}