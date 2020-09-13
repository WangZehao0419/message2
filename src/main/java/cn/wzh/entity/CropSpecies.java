package cn.wzh.entity;

import java.io.Serializable;

/**
 * crop_species
 *
 * @author
 */
public class CropSpecies implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 农作物种类主键
     */
    private Integer id;
    /**
     * 种类名称
     */
    private String cropSpecies;
    /**
     * 类别id
     */
    private Integer cropCategoryId;
    /**
     * 1是启用，0是禁用
     */
    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCropSpecies() {
        return cropSpecies;
    }

    public void setCropSpecies(String cropSpecies) {
        this.cropSpecies = cropSpecies;
    }

    public Integer getCropCategoryId() {
        return cropCategoryId;
    }

    public void setCropCategoryId(Integer cropCategoryId) {
        this.cropCategoryId = cropCategoryId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
        CropSpecies other = (CropSpecies) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getCropSpecies() == null ? other.getCropSpecies() == null : this.getCropSpecies().equals(other.getCropSpecies()))
                && (this.getCropCategoryId() == null ? other.getCropCategoryId() == null : this.getCropCategoryId().equals(other.getCropCategoryId()))
                && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCropSpecies() == null) ? 0 : getCropSpecies().hashCode());
        result = prime * result + ((getCropCategoryId() == null) ? 0 : getCropCategoryId().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", cropSpecies=").append(cropSpecies);
        sb.append(", cropCategoryId=").append(cropCategoryId);
        sb.append(", state=").append(state);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}