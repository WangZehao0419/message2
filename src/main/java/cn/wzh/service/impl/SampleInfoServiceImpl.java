package cn.wzh.service.impl;

import cn.wzh.DTO.SampleInfoDTO;
import cn.wzh.service.SampleInfoService;
import cn.wzh.util.PageUtil;
import cn.wzh.vo.ConditionQueryVo;
import cn.wzh.vo.SampleInfoVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleInfoServiceImpl implements SampleInfoService {
    @Autowired
    private SampleInfoDAO sampleInfoDAO;

    @Override
    public PageUtil findAll1(Integer pageNum, Integer pageSize) {
        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageNum(pageNum);
        pageUtil.setPageSize(pageSize);
        pageUtil.setTotal(sampleInfoDAO.selectCount());
        pageUtil.setResult(sampleInfoDAO.selectAll(pageUtil.getStartNum(), pageSize));
        return pageUtil;
    }

    @Override
    public PageUtil findAll2(Integer pageNum, Integer pageSize) {
        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageNum(pageNum);
        pageUtil.setPageSize(pageSize);
        pageUtil.setTotal(sampleInfoDAO.selectCount2());
        pageUtil.setResult(sampleInfoDAO.selectAll2(pageUtil.getStartNum(), pageSize));
        return pageUtil;
    }

    @Override
    public List<SampleInfoVO> findAll2() {
        return sampleInfoDAO.selectAll2(0, 0);
    }

    @Override
    public PageInfo<SampleInfoVO> findAll3(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SampleInfoVO> sampleInfoVOS = sampleInfoDAO.selectAll3();
        PageInfo<SampleInfoVO> pageInfo = new PageInfo<>(sampleInfoVOS);
        return pageInfo;
    }

    @Override
    public PageUtil findByCondition(Integer pageNum, Integer pageSize, ConditionQueryVo conditionQueryVo) {
        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageNum(pageNum);
        pageUtil.setPageSize(pageSize);
        pageUtil.setTotal(sampleInfoDAO.selectCountByCondition(conditionQueryVo));
        pageUtil.setResult(sampleInfoDAO.selectByCondition(pageUtil.getStartNum(), pageSize, conditionQueryVo));
        return pageUtil;
    }

    @Override
    public PageUtil findByCondition2(Integer pageNum, Integer pageSize, ConditionQueryVo conditionQueryVo) {
        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageNum(pageNum);
        pageUtil.setPageSize(pageSize);
        List<SampleInfoDTO> sampleInfoDTOS = sampleInfoDAO.selectByCondition2(pageUtil.getStartNum(), pageSize, conditionQueryVo);


        return null;
    }

    @Override
    public int add(SampleInfo sampleInfo) {
        return sampleInfoDAO.insert(sampleInfo);
    }
}
