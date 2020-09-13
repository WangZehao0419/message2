package cn.wzh.service.impl;

import cn.wzh.service.SampleToxinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleToxinServiceImpl implements SampleToxinService {
    @Autowired
    private SampleToxinDAO sampleToxinDAO;

    @Override
    public int addList(List<SampleToxin> sampleToxinList) {
        return sampleToxinDAO.insertList(sampleToxinList);
    }
}
