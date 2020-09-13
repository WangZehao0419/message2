package cn.wzh.entity;

import java.io.Serializable;

/**
 * sample_toxin
 *
 * @author
 */
public class SampleToxin implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 毒素id
     */
    private Integer toxinId;

    /**
     * 毒素含量
     */
    private Float toxinCount;

    /**
     * 样品信息id
     */
    private Integer sampleInfoId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getToxinId() {
        return toxinId;
    }

    public void setToxinId(Integer toxinId) {
        this.toxinId = toxinId;
    }

    public Float getToxinCount() {
        return toxinCount;
    }

    public void setToxinCount(Float toxinCount) {
        this.toxinCount = toxinCount;
    }

    public Integer getSampleInfoId() {
        return sampleInfoId;
    }

    public void setSampleInfoId(Integer sampleInfoId) {
        this.sampleInfoId = sampleInfoId;
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
        SampleToxin other = (SampleToxin) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getToxinId() == null ? other.getToxinId() == null : this.getToxinId().equals(other.getToxinId()))
                && (this.getToxinCount() == null ? other.getToxinCount() == null : this.getToxinCount().equals(other.getToxinCount()))
                && (this.getSampleInfoId() == null ? other.getSampleInfoId() == null : this.getSampleInfoId().equals(other.getSampleInfoId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getToxinId() == null) ? 0 : getToxinId().hashCode());
        result = prime * result + ((getToxinCount() == null) ? 0 : getToxinCount().hashCode());
        result = prime * result + ((getSampleInfoId() == null) ? 0 : getSampleInfoId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", toxinId=").append(toxinId);
        sb.append(", toxinCount=").append(toxinCount);
        sb.append(", sampleInfoId=").append(sampleInfoId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}