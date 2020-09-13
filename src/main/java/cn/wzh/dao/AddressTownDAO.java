package cn.wzh.dao;

import cn.wzh.entity.AddressTown;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * AddressTownDAO继承基类
 */
@Repository
public interface AddressTownDAO extends MyBatisBaseDao<AddressTown, Integer> {
    List<AddressTown> selectByCityCode(String cityCode);
}