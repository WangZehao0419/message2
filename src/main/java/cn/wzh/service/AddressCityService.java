package cn.wzh.service;

import java.util.List;

public interface AddressCityService {
    List<AddressCity> findByProvinceCode(String provinceCode);
}
