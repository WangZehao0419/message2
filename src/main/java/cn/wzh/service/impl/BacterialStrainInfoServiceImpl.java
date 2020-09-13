package cn.wzh.service.impl;

import cn.wzh.service.BacterialStrainInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BacterialStrainInfoServiceImpl implements BacterialStrainInfoService {
    @Autowired
    private BacterialStrainInfoDao bacterialStrainInfoDao;

    @Override
    public int add(BacterialStrainInfo bacterialStrainInfo) {
        return bacterialStrainInfoDao.insert(bacterialStrainInfo);
    }

    @Override
    public int addList(List<BacterialStrainInfo> bacterialStrainInfoList) {
        return bacterialStrainInfoDao.insertList(bacterialStrainInfoList);
    }
}
