package cn.wzh.vo;

public class ConditionQueryVo {
    /**
     * 样品编号
     */
    private String sampleId;

    /**
     * 污染率
     */
    private String pollutionRate;

    /**
     * 年、月、日
     */
    private String year;
    private String month;
    private String day;

    /**
     * 毒素（菌种）
     */
    private String toxinType;

    /**
     * 农作物种类
     */
    private String cropSpecies;

    /**
     * 省、市、县
     */
    private String province;
    private String city;
    private String county;

    /**
     * 用于拆分污染率
     */
    private String begin;
    private String end;

    /**
     * 用于合并年月日
     */
    private String time;

    public ConditionQueryVo() {
    }

    public String getSampleId() {
        return sampleId;
    }

    public void setSampleId(String sampleId) {
        this.sampleId = sampleId;
    }

    public String getPollutionRate() {
        return pollutionRate;
    }

    public void setPollutionRate(String pollutionRate) {
        this.pollutionRate = pollutionRate;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getToxinType() {
        return toxinType;
    }

    public void setToxinType(String toxinType) {
        this.toxinType = toxinType;
    }

    public String getCropSpecies() {
        return cropSpecies;
    }

    public void setCropSpecies(String cropSpecies) {
        this.cropSpecies = cropSpecies;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
