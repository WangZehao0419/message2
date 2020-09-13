package cn.wzh.service.impl;

import cn.wzh.service.AddressTownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressTownServiceImpl implements AddressTownService {
    @Autowired
    private AddressTownDAO addressTownDAO;

    @Override
    public List<AddressTown> findByCityCode(String cityCodes) {
        return addressTownDAO.selectByCityCode(cityCodes);
    }
}
