package cn.wzh.service.impl;

import cn.wzh.service.CropSpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CropSpeciesServiceImpl implements CropSpeciesService {
    @Autowired
    private CropSpeciesDAO cropSpeciesDAO;

    @Override
    public List<CropSpecies> findAll() {
        return cropSpeciesDAO.findAll();
    }
}
