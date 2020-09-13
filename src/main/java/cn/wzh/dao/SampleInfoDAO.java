package cn.wzh.dao;

import cn.wzh.DTO.SampleInfoDTO;
import cn.wzh.entity.SampleInfo;
import cn.wzh.vo.ConditionQueryVo;
import cn.wzh.vo.SampleInfoVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SampleInfoDAO继承基类
 */
@Repository
public interface SampleInfoDAO extends MyBatisBaseDao<SampleInfo, Integer> {
    /**
     * 统计查询全部数量（使用实体类嵌套）
     *
     * @return
     */
    int selectCount();

    /**
     * 分页查询全部（多表，使用实体类嵌套 + 分页工具类）
     *
     * @param startNum
     * @param pageSize
     * @return
     */
    List<SampleInfo> selectAll(@Param("startNum") Integer startNum, @Param("pageSize") Integer pageSize);

    /**
     * 统计查询全部数量（使用VO类）
     *
     * @return
     */
    int selectCount2();

    /**
     * 分页查询全部（使用VO类 + 分页工具类）
     *
     * @return
     */
    List<SampleInfoVO> selectAll2(@Param("startNum") Integer startNum,
                                  @Param("pageSize") Integer pageSize);


    /**
     * 分页查询全部（使用VO类 + 分页插件）
     *
     * @return
     */
    List<SampleInfoVO> selectAll3();

    /**
     * 根据条件查询全部（使用VO类 + 分页工具类）
     *
     * @param startNum
     * @param pageSize
     * @param conditionQueryVo
     * @return
     */
    List<SampleInfoVO> selectByCondition(@Param("startNum") Integer startNum,
                                         @Param("pageSize") Integer pageSize,
                                         @Param("conditionQueryVo") ConditionQueryVo conditionQueryVo);

    /**
     * 根据条件统计查询全部数量（使用VO类）
     *
     * @param conditionQueryVo
     * @return
     */
    int selectCountByCondition(ConditionQueryVo conditionQueryVo);

    /**
     * 根据条件查询全部（单表，实体类嵌套）
     */
    List<SampleInfoDTO> selectByCondition2(@Param("startNum") Integer startNum,
                                           @Param("pageSize") Integer pageSize,
                                           @Param("conditionQueryVo") ConditionQueryVo conditionQueryVo);

    /**
     * 根据条件统计查询全部数量（单表，实体类嵌套）
     *
     * @param conditionQueryVo
     * @return
     */
    int selectCountByCondition2(ConditionQueryVo conditionQueryVo);


    int insert(SampleInfo sampleInfo);
}