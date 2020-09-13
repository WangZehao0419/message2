package cn.wzh.service;

import cn.wzh.entity.SampleInfo;
import cn.wzh.util.PageUtil;
import cn.wzh.vo.ConditionQueryVo;
import cn.wzh.vo.SampleInfoVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SampleInfoService {

    PageUtil findAll1(Integer pageNum, Integer pageSize);

    PageUtil findAll2(Integer pageNum, Integer pageSize);

    List<SampleInfoVO> findAll2();

    PageInfo<SampleInfoVO> findAll3(Integer pageNum, Integer pageSize);

    PageUtil findByCondition(Integer pageNum, Integer pageSize, ConditionQueryVo conditionQueryVo);

    PageUtil findByCondition2(Integer pageNum, Integer pageSize, ConditionQueryVo conditionQueryVo);

    int add(SampleInfo sampleInfo);
}
