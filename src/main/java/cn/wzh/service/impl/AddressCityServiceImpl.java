package cn.wzh.service.impl;

import cn.wzh.service.AddressCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressCityServiceImpl implements AddressCityService {
    @Autowired
    private AddressCityDAO addressCityDAO;

    @Override
    public List<AddressCity> findByProvinceCode(String provinceCode) {
        return addressCityDAO.selectByProvinceCode(provinceCode);
    }
}
