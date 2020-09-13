package cn.wzh.service;

import cn.wzh.entity.BacterialStrainInfo;

import java.util.List;

public interface BacterialStrainInfoService {
    int add(BacterialStrainInfo bacterialStrainInfo);

    int addList(List<BacterialStrainInfo> bacterialStrainInfoList);
}
