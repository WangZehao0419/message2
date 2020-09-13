package cn.wzh.controller;

import cn.wzh.entity.BacterialStrainInfo;
import cn.wzh.entity.SampleInfo;
import cn.wzh.entity.SampleToxin;
import cn.wzh.enums.ExcelHeaderEnum;
import cn.wzh.enums.Result;
import cn.wzh.service.*;
import cn.wzh.util.ExcelUtil;
import cn.wzh.util.PageUtil;
import cn.wzh.util.Upload;
import cn.wzh.vo.ConditionQueryVo;
import cn.wzh.vo.JSONResultVO;
import cn.wzh.vo.SampleInfoVO;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/sampleInfo")
public class SampleInfoController {
    @Autowired
    private SampleInfoService sampleInfoService;
    @Autowired
    private AddressProvinceService addressProvinceService;
    @Autowired
    private AddressCityService addressCityService;
    @Autowired
    private AddressTownService addressTownService;
    @Autowired
    private CropSpeciesService cropSpeciesService;
    @Autowired
    private SampleToxinInfoService sampleToxinInfoService;
    @Autowired
    private SampleToxinService sampleToxinService;
    @Autowired
    private BacterialStrainInfoService bacterialStrainInfoService;

    /**
     * 分页查询
     *
     * @param model
     * @param pageNum
     * @return
     */
    @GetMapping(value = "/indexList")
    public String indexList(Model model, @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum) {
        //model.addAttribute("pageUtil",sampleInfoService.findAll1(pageNum, 5));
        model.addAttribute("pageUtil", sampleInfoService.findAll2(pageNum, 5));
        //model.addAttribute("pageHelper",sampleInfoService.findAll3(pageNum, 5));
        return "IMajax";
    }

    /**
     * 条件查询并数据回显（同步方式）
     *
     * @param model
     * @param conditionQueryVo
     * @param pageNum
     * @return
     */
    @GetMapping(value = "/conditionQuery")
    public String conditionQuery(Model model,
                                 ConditionQueryVo conditionQueryVo,
                                 @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum) {
        if (conditionQueryVo != null) {
            // 拆分污染率
            if (conditionQueryVo.getPollutionRate() != null && !"".equals(conditionQueryVo.getPollutionRate())) {
                String[] pollutionRates = conditionQueryVo.getPollutionRate().split("-");
                conditionQueryVo.setBegin(pollutionRates[0]);
                conditionQueryVo.setEnd(pollutionRates[1]);
            }

            // 合并、格式化日期
            String date = "";
            // 验证日是否为空，如果日不为空，月和年必定不为空，因为三级联动。
            if (conditionQueryVo.getDay() != null && !"".equals(conditionQueryVo.getDay()) && !conditionQueryVo.getDay().equals("0")) {
                // 如果月的字符长度为1，则需要在前面补零，使其变成2位数的。
                if (conditionQueryVo.getMonth().length() == 1) {
                    date = conditionQueryVo.getYear() + "-0" + conditionQueryVo.getMonth();
                } else {
                    date = conditionQueryVo.getYear() + "-" + conditionQueryVo.getMonth();
                }

                // 如果日的字符长度为1，则需要在前面补零，使其变成2位数的。
                if (conditionQueryVo.getDay().length() == 1) {
                    date += "-0" + conditionQueryVo.getDay();
                } else {
                    date += "-" + conditionQueryVo.getDay();
                }
            } else if (conditionQueryVo.getMonth() != null && !"".equals(conditionQueryVo.getMonth()) && !conditionQueryVo.getMonth().equals("0")) {
                if (conditionQueryVo.getMonth().length() == 1) {
                    date += conditionQueryVo.getYear() + "-0" + conditionQueryVo.getMonth();
                } else {
                    date += conditionQueryVo.getYear() + "-" + conditionQueryVo.getMonth();
                }
            } else if (conditionQueryVo.getYear() != null && !"".equals(conditionQueryVo.getYear()) && !conditionQueryVo.getYear().equals("0")) {
                date += conditionQueryVo.getYear();
            }
            conditionQueryVo.setTime(date);

        }
        model.addAttribute("pageUtil", sampleInfoService.findByCondition(pageNum, 5, conditionQueryVo));
        model.addAttribute("conditionQueryVo", conditionQueryVo);
        return "IM";
    }

    /**
     * 三级联动
     *
     * @return
     */
    @GetMapping(value = "/findProvince", produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String findProvince() {
        return JSON.toJSONString(addressProvinceService.findAll());
    }

    @GetMapping(value = "/findCity", produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String findCity(@RequestParam("provinceCode") String provinceCode) {
        return JSON.toJSONString(addressCityService.findByProvinceCode(provinceCode));
    }

    @GetMapping(value = "/findCounty", produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String findCounty(@RequestParam("cityCode") String cityCode) {
        return JSON.toJSONString(addressTownService.findByCityCode(cityCode));
    }

    @GetMapping(value = "/findCropSpecies", produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String findCropSpecies() {
        return JSON.toJSONString(cropSpeciesService.findAll());
    }

    @GetMapping(value = "/findToxinType", produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String findToxinType() {
        return JSON.toJSONString(sampleToxinInfoService.findAll());
    }


    /**
     * 条件查询并数据回显（异步方式）
     *
     * @param conditionQueryVo
     * @param pageNum
     * @return
     */
    @RequestMapping(value = "/conditionQueryAsyn", produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public JSONResultVO<PageUtil> conditionQuery2(ConditionQueryVo conditionQueryVo,
                                                  @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum) {
        if (conditionQueryVo != null) {
            // 拆分污染率
            if (conditionQueryVo.getPollutionRate() != null && !"".equals(conditionQueryVo.getPollutionRate())) {
                String[] pollutionRates = conditionQueryVo.getPollutionRate().split("-");
                conditionQueryVo.setBegin(pollutionRates[0]);
                conditionQueryVo.setEnd(pollutionRates[1]);
            }

            // 合并、格式化日期
            String date = "";
            // 验证日是否为空，如果日不为空，月和年必定不为空，因为三级联动。
            if (conditionQueryVo.getDay() != null && !"".equals(conditionQueryVo.getDay()) && !conditionQueryVo.getDay().equals("0")) {
                // 如果月的字符长度为1，则需要在前面补零，使其变成2位数的。
                if (conditionQueryVo.getMonth().length() == 1) {
                    date = conditionQueryVo.getYear() + "-0" + conditionQueryVo.getMonth();
                } else {
                    date = conditionQueryVo.getYear() + "-" + conditionQueryVo.getMonth();
                }

                // 如果日的字符长度为1，则需要在前面补零，使其变成2位数的。
                if (conditionQueryVo.getDay().length() == 1) {
                    date += "-0" + conditionQueryVo.getDay();
                } else {
                    date += "-" + conditionQueryVo.getDay();
                }
            } else if (conditionQueryVo.getMonth() != null && !"".equals(conditionQueryVo.getMonth()) && !conditionQueryVo.getMonth().equals("0")) {
                if (conditionQueryVo.getMonth().length() == 1) {
                    date += conditionQueryVo.getYear() + "-0" + conditionQueryVo.getMonth();
                } else {
                    date += conditionQueryVo.getYear() + "-" + conditionQueryVo.getMonth();
                }
            } else if (conditionQueryVo.getYear() != null && !"".equals(conditionQueryVo.getYear()) && !conditionQueryVo.getYear().equals("0")) {
                date += conditionQueryVo.getYear();
            }
            conditionQueryVo.setTime(date);

        }

        JSONResultVO<PageUtil> jsonResultVO = null;
        /*if (pageUtil.getResult() == null || pageUtil.getResult() == "") {
            jsonResultVO = new JSONResultVO<>(Result.ERROR,null);
        }
        jsonResultVO = new JSONResultVO<>(Result.SUCCESS,pageUtil);*/
        try {
            jsonResultVO = new JSONResultVO<>(Result.SUCCESS, sampleInfoService.findByCondition(pageNum, 5, conditionQueryVo));
        } catch (Exception e) {
            e.printStackTrace();
            jsonResultVO = new JSONResultVO<>(Result.ERROR, null);
        }
        return jsonResultVO;
    }

    /**
     * 多级批量插入
     *
     * @param sampleInfo
     * @param listToxinId
     * @param listToxinCount
     * @param harvestTime
     * @param samplingTime
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public String add(SampleInfo sampleInfo,
                      @RequestParam("listToxinId") Integer[] listToxinId,// 如果无法找到，就替换成listToxinId[]
                      @RequestParam("listToxinCount") Float[] listToxinCount,
                      @RequestParam("harvest_Time") String harvestTime,
                      @RequestParam("sampling_Time") String samplingTime,
                      MultipartFile[] wordAddr, MultipartFile[] txtAddr, MultipartFile[] pictureAddr) {

        // 处理日期
        String[] strings = harvestTime.split("-");
        sampleInfo.setHarvestTime(new Calendar.Builder().setDate(Integer.parseInt(strings[0]), (Integer.parseInt(strings[1]) - 1), Integer.parseInt(strings[2])).build().getTime());
        String[] strings2 = samplingTime.split("-");
        sampleInfo.setSamplingTime(new Calendar.Builder().setDate(Integer.parseInt(strings2[0]), (Integer.parseInt(strings2[1]) - 1), Integer.parseInt(strings2[2])).build().getTime());
        int sampleInfoResult = sampleInfoService.add(sampleInfo);

        List<SampleToxin> sampleToxinList = new ArrayList<>();
        // listToxinId和listToxinCount的长度是一致的，因为页面上它们是俩俩一组生成的。
        for (int i = 0; i < listToxinId.length; i++) {
            SampleToxin sampleToxin = new SampleToxin();
            sampleToxin.setId(0);
            sampleToxin.setSampleInfoId(sampleInfo.getId());
            sampleToxin.setToxinId(listToxinId[i]);
            sampleToxin.setToxinCount(listToxinCount[i]);
            sampleToxinList.add(sampleToxin);
        }
        int sampleToxinResult = 0;
        // 只有在页面填充了数据才向数据库添加数据
        if (sampleToxinList.size() > 0) {
            sampleToxinResult = sampleToxinService.addList(sampleToxinList);
        }

        List<BacterialStrainInfo> bacterialStrainInfoList = new ArrayList<>();
        for (int i = 0; i < wordAddr.length; i++) {
            BacterialStrainInfo bacterialStrainInfo = new BacterialStrainInfo();
            bacterialStrainInfo.setId(0);
            bacterialStrainInfo.setSampleInfoId(sampleInfo.getId());
            bacterialStrainInfo.setWordAddr(Upload.shangChuan(wordAddr[i]));
            bacterialStrainInfo.setPictureAddr(Upload.shangChuan(pictureAddr[i]));
            bacterialStrainInfo.setTxtAddr(Upload.shangChuan(txtAddr[i]));
            bacterialStrainInfoList.add(bacterialStrainInfo);
        }
        int bacterialStrainInfoResult = 0;
        if (bacterialStrainInfoList.size() > 0) {
            bacterialStrainInfoResult = bacterialStrainInfoService.addList(bacterialStrainInfoList);
        }


        String result = "SampleInfo主数据添加失败！！";
        if (sampleInfoResult > 0) {
            result = "SampleInfo主数据添加成功！！";
            if (sampleToxinResult > 0) {
                result += String.format("；SampleToxin从数据一共%d条，增加成功%d条，失败%d条", listToxinId.length, sampleToxinResult, listToxinId.length - sampleToxinResult);
            } else {
                result += "；SampleToxin从数据添加失败！！";
            }
            if (bacterialStrainInfoResult > 0) {
                result += String.format("；BacterialStrainInfo从数据一共%d条，增加成功%d条，失败%d条", wordAddr.length, bacterialStrainInfoResult, wordAddr.length - bacterialStrainInfoResult);
            } else {
                result += "；BacterialStrainInfo从数据添加失败！！";
            }
        }
        return JSON.toJSONString(result);
    }


    @RequestMapping("exportAll")
    public String exportAll(HttpServletResponse response) throws Exception {
        String fileName = "cheshi.xls";
        try {
            fileName = URLEncoder.encode(fileName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        // 设置响应头的信息，用于给正在下载的文件赋名称。
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        // 设置内容类型，使其被判断为下载文件类型
        response.setContentType("multipart/form-data");
        List<SampleInfoVO> list = sampleInfoService.findAll2();
        String[] header = {ExcelHeaderEnum.SAMPLE_ID.getCommentName(),
                ExcelHeaderEnum.ADDRESS_NAME.getCommentName(),
                ExcelHeaderEnum.CROP_SPECIES.getCommentName(),
                ExcelHeaderEnum.SAMPLING_TIME.getCommentName(),
                ExcelHeaderEnum.INPUT_TIME.getCommentName(),
                ExcelHeaderEnum.POLLUTION_RATE.getCommentName(),
                ExcelHeaderEnum.TOXIN_TYPE.getCommentName()};
        ExcelUtil<SampleInfoVO> excelUtil = new ExcelUtil<>();
        excelUtil.exportExcel("sheet1", fileName, header, response, list, "yyyy-MM-dd HH:mm:ss");

        return "";
    }
}
