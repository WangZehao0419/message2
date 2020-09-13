package cn.wzh.service.impl;

import cn.wzh.service.SampleToxinInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleToxinInfoServiceImpl implements SampleToxinInfoService {
    @Autowired
    private SampleToxinInfoDAO sampleToxinInfoDAO;

    @Override
    public List<SampleToxinInfo> findAll() {
        return sampleToxinInfoDAO.selectAll();
    }
}
