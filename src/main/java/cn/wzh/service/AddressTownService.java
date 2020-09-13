package cn.wzh.service;

import java.util.List;

public interface AddressTownService {
    List<AddressTown> findByCityCode(String cityCodes);
}
