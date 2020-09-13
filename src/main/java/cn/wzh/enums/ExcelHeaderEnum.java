package cn.wzh.enums;

public enum ExcelHeaderEnum {
    SAMPLE_ID("sampleId", "样品编号"),
    ADDRESS_NAME("addressName", "地址"),
    CROP_SPECIES("cropSpecies", "农产品加工类型"),
    SAMPLING_TIME("samplingTime", "取样时间"),
    INPUT_TIME("inputTime", "录入时间"),
    POLLUTION_RATE("pollutionRate", "真菌污染率"),
    TOXIN_TYPE("toxinType", "主要毒素");

    private String propertyName;
    private String commentName;

    ExcelHeaderEnum(String propertyName, String commentName) {
        this.propertyName = propertyName;
        this.commentName = commentName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getCommentName() {
        return commentName;
    }

    public void setCommentName(String commentName) {
        this.commentName = commentName;
    }
}
