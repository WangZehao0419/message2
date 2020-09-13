package cn.wzh.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * sample_info
 *
 * @author
 */
public class SampleInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 采样信息主键
     */
    private Integer id;

    /**
     * 样品编号
     */
    private String sampleId;

    /**
     * 农产品加工原料类别id
     */
    private Integer cropCategoryId;

    /**
     * 品种
     */
    private Integer breed;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 县
     */
    private String county;

    /**
     * 乡
     */
    private String township;

    /**
     * 村
     */
    private String village;

    /**
     * 户
     */
    private String household;

    /**
     * 收获时间
     */
    /*@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMt-8")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")*/
    private Date harvestTime;

    /**
     * 取样时间
     */
    /*@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMt-8")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")*/
    private Date samplingTime;

    /**
     * 取样人
     */
    private String samplingPeople;

    /**
     * 真菌污染率
     */
    private Float pollutionRate;

    /**
     * 创建时间
     */
    /*@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMt-8")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")*/
    private Date createTime;

    /**
     * 是否删除0未删除1删除
     */
    private Integer isdel;

    /**
     * 录入时间
     */
    /*@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMt-8")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")*/
    private Date inputTime;

    /**
     * 导入：是否取样
     */
    private Integer flag;

    /**
     * 录入人（信息管理员）
     */
    private Integer enterpeople;

    /**
     * 导入品种字段
     */
    private String varieties;

    /**
     * 采集时季节及气候特征
     */
    private String seasonal;

    /**
     * 采集地、环境信息描述
     */
    private String description;

    private SampleToxinInfo sampleToxinInfo;

    private AddressProvince addressProvince;

    private AddressCity addressCity;

    private AddressTown addressTown;

    private CropSpecies cropSpecies;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSampleId() {
        return sampleId;
    }

    public void setSampleId(String sampleId) {
        this.sampleId = sampleId;
    }

    public Integer getCropCategoryId() {
        return cropCategoryId;
    }

    public void setCropCategoryId(Integer cropCategoryId) {
        this.cropCategoryId = cropCategoryId;
    }

    public Integer getBreed() {
        return breed;
    }

    public void setBreed(Integer breed) {
        this.breed = breed;
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

    public String getTownship() {
        return township;
    }

    public void setTownship(String township) {
        this.township = township;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getHousehold() {
        return household;
    }

    public void setHousehold(String household) {
        this.household = household;
    }

    public Date getHarvestTime() {
        return harvestTime;
    }

    public void setHarvestTime(Date harvestTime) {
        this.harvestTime = harvestTime;
    }

    public Date getSamplingTime() {
        return samplingTime;
    }

    public void setSamplingTime(Date samplingTime) {
        this.samplingTime = samplingTime;
    }

    public String getSamplingPeople() {
        return samplingPeople;
    }

    public void setSamplingPeople(String samplingPeople) {
        this.samplingPeople = samplingPeople;
    }

    public Float getPollutionRate() {
        return pollutionRate;
    }

    public void setPollutionRate(Float pollutionRate) {
        this.pollutionRate = pollutionRate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    public Date getInputTime() {
        return inputTime;
    }

    public void setInputTime(Date inputTime) {
        this.inputTime = inputTime;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getEnterpeople() {
        return enterpeople;
    }

    public void setEnterpeople(Integer enterpeople) {
        this.enterpeople = enterpeople;
    }

    public String getVarieties() {
        return varieties;
    }

    public void setVarieties(String varieties) {
        this.varieties = varieties;
    }

    public String getSeasonal() {
        return seasonal;
    }

    public void setSeasonal(String seasonal) {
        this.seasonal = seasonal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SampleToxinInfo getSampleToxinInfo() {
        return sampleToxinInfo;
    }

    public void setSampleToxinInfo(SampleToxinInfo sampleToxinInfo) {
        this.sampleToxinInfo = sampleToxinInfo;
    }

    public AddressProvince getAddressProvince() {
        return addressProvince;
    }

    public void setAddressProvince(AddressProvince addressProvince) {
        this.addressProvince = addressProvince;
    }

    public AddressCity getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(AddressCity addressCity) {
        this.addressCity = addressCity;
    }

    public AddressTown getAddressTown() {
        return addressTown;
    }

    public void setAddressTown(AddressTown addressTown) {
        this.addressTown = addressTown;
    }

    public CropSpecies getCropSpecies() {
        return cropSpecies;
    }

    public void setCropSpecies(CropSpecies cropSpecies) {
        this.cropSpecies = cropSpecies;
    }


    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SampleInfo other = (SampleInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getSampleId() == null ? other.getSampleId() == null : this.getSampleId().equals(other.getSampleId()))
                && (this.getCropCategoryId() == null ? other.getCropCategoryId() == null : this.getCropCategoryId().equals(other.getCropCategoryId()))
                && (this.getBreed() == null ? other.getBreed() == null : this.getBreed().equals(other.getBreed()))
                && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
                && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
                && (this.getCounty() == null ? other.getCounty() == null : this.getCounty().equals(other.getCounty()))
                && (this.getTownship() == null ? other.getTownship() == null : this.getTownship().equals(other.getTownship()))
                && (this.getVillage() == null ? other.getVillage() == null : this.getVillage().equals(other.getVillage()))
                && (this.getHousehold() == null ? other.getHousehold() == null : this.getHousehold().equals(other.getHousehold()))
                && (this.getHarvestTime() == null ? other.getHarvestTime() == null : this.getHarvestTime().equals(other.getHarvestTime()))
                && (this.getSamplingTime() == null ? other.getSamplingTime() == null : this.getSamplingTime().equals(other.getSamplingTime()))
                && (this.getSamplingPeople() == null ? other.getSamplingPeople() == null : this.getSamplingPeople().equals(other.getSamplingPeople()))
                && (this.getPollutionRate() == null ? other.getPollutionRate() == null : this.getPollutionRate().equals(other.getPollutionRate()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getIsdel() == null ? other.getIsdel() == null : this.getIsdel().equals(other.getIsdel()))
                && (this.getInputTime() == null ? other.getInputTime() == null : this.getInputTime().equals(other.getInputTime()))
                && (this.getFlag() == null ? other.getFlag() == null : this.getFlag().equals(other.getFlag()))
                && (this.getEnterpeople() == null ? other.getEnterpeople() == null : this.getEnterpeople().equals(other.getEnterpeople()))
                && (this.getVarieties() == null ? other.getVarieties() == null : this.getVarieties().equals(other.getVarieties()))
                && (this.getSeasonal() == null ? other.getSeasonal() == null : this.getSeasonal().equals(other.getSeasonal()))
                && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSampleId() == null) ? 0 : getSampleId().hashCode());
        result = prime * result + ((getCropCategoryId() == null) ? 0 : getCropCategoryId().hashCode());
        result = prime * result + ((getBreed() == null) ? 0 : getBreed().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getCounty() == null) ? 0 : getCounty().hashCode());
        result = prime * result + ((getTownship() == null) ? 0 : getTownship().hashCode());
        result = prime * result + ((getVillage() == null) ? 0 : getVillage().hashCode());
        result = prime * result + ((getHousehold() == null) ? 0 : getHousehold().hashCode());
        result = prime * result + ((getHarvestTime() == null) ? 0 : getHarvestTime().hashCode());
        result = prime * result + ((getSamplingTime() == null) ? 0 : getSamplingTime().hashCode());
        result = prime * result + ((getSamplingPeople() == null) ? 0 : getSamplingPeople().hashCode());
        result = prime * result + ((getPollutionRate() == null) ? 0 : getPollutionRate().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getIsdel() == null) ? 0 : getIsdel().hashCode());
        result = prime * result + ((getInputTime() == null) ? 0 : getInputTime().hashCode());
        result = prime * result + ((getFlag() == null) ? 0 : getFlag().hashCode());
        result = prime * result + ((getEnterpeople() == null) ? 0 : getEnterpeople().hashCode());
        result = prime * result + ((getVarieties() == null) ? 0 : getVarieties().hashCode());
        result = prime * result + ((getSeasonal() == null) ? 0 : getSeasonal().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sampleId=").append(sampleId);
        sb.append(", cropCategoryId=").append(cropCategoryId);
        sb.append(", breed=").append(breed);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", county=").append(county);
        sb.append(", township=").append(township);
        sb.append(", village=").append(village);
        sb.append(", household=").append(household);
        sb.append(", harvestTime=").append(harvestTime);
        sb.append(", samplingTime=").append(samplingTime);
        sb.append(", samplingPeople=").append(samplingPeople);
        sb.append(", pollutionRate=").append(pollutionRate);
        sb.append(", createTime=").append(createTime);
        sb.append(", isdel=").append(isdel);
        sb.append(", inputTime=").append(inputTime);
        sb.append(", flag=").append(flag);
        sb.append(", enterpeople=").append(enterpeople);
        sb.append(", varieties=").append(varieties);
        sb.append(", seasonal=").append(seasonal);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}