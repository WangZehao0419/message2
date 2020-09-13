package cn.wzh.service.impl;

import cn.wzh.service.AddressProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressProvinceServiceImpl implements AddressProvinceService {
    @Autowired
    private AddressProvinceDAO addressProvinceDAO;


    @Override
    public List<AddressProvince> findAll() {
        return addressProvinceDAO.selectAll();
    }
}
