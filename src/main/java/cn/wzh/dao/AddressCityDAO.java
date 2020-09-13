package cn.wzh.dao;

import cn.wzh.entity.AddressCity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * AddressCityDAO继承基类
 */
@Repository
public interface AddressCityDAO extends MyBatisBaseDao<AddressCity, Integer> {
    List<AddressCity> selectByProvinceCode(String provinceCode);
}