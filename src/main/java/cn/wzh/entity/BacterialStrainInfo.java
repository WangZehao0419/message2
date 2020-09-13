package cn.wzh.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * bacterial_strain_info
 *
 * @author
 */
public class BacterialStrainInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 产毒菌株id
     */
    private Integer id;
    private Integer sampleInfoId;
    /**
     * 样品id
     */
    private String sampleNum;
    /**
     * 菌株原始编号
     */
    private String originalNum;
    /**
     * 文献信息地址
     */
    private String wordAddr;
    /**
     * 文本地址
     */
    private String txtAddr;
    /**
     * 图片地址
     */
    private String pictureAddr;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 0： 显示  1 ；删除
     */
    private Integer isdel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSampleInfoId() {
        return sampleInfoId;
    }

    public void setSampleInfoId(Integer sampleInfoId) {
        this.sampleInfoId = sampleInfoId;
    }

    public String getSampleNum() {
        return sampleNum;
    }

    public void setSampleNum(String sampleNum) {
        this.sampleNum = sampleNum;
    }

    public String getOriginalNum() {
        return originalNum;
    }

    public void setOriginalNum(String originalNum) {
        this.originalNum = originalNum;
    }

    public String getWordAddr() {
        return wordAddr;
    }

    public void setWordAddr(String wordAddr) {
        this.wordAddr = wordAddr;
    }

    public String getTxtAddr() {
        return txtAddr;
    }

    public void setTxtAddr(String txtAddr) {
        this.txtAddr = txtAddr;
    }

    public String getPictureAddr() {
        return pictureAddr;
    }

    public void setPictureAddr(String pictureAddr) {
        this.pictureAddr = pictureAddr;
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
        BacterialStrainInfo other = (BacterialStrainInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getSampleInfoId() == null ? other.getSampleInfoId() == null : this.getSampleInfoId().equals(other.getSampleInfoId()))
                && (this.getSampleNum() == null ? other.getSampleNum() == null : this.getSampleNum().equals(other.getSampleNum()))
                && (this.getOriginalNum() == null ? other.getOriginalNum() == null : this.getOriginalNum().equals(other.getOriginalNum()))
                && (this.getWordAddr() == null ? other.getWordAddr() == null : this.getWordAddr().equals(other.getWordAddr()))
                && (this.getTxtAddr() == null ? other.getTxtAddr() == null : this.getTxtAddr().equals(other.getTxtAddr()))
                && (this.getPictureAddr() == null ? other.getPictureAddr() == null : this.getPictureAddr().equals(other.getPictureAddr()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getIsdel() == null ? other.getIsdel() == null : this.getIsdel().equals(other.getIsdel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSampleInfoId() == null) ? 0 : getSampleInfoId().hashCode());
        result = prime * result + ((getSampleNum() == null) ? 0 : getSampleNum().hashCode());
        result = prime * result + ((getOriginalNum() == null) ? 0 : getOriginalNum().hashCode());
        result = prime * result + ((getWordAddr() == null) ? 0 : getWordAddr().hashCode());
        result = prime * result + ((getTxtAddr() == null) ? 0 : getTxtAddr().hashCode());
        result = prime * result + ((getPictureAddr() == null) ? 0 : getPictureAddr().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getIsdel() == null) ? 0 : getIsdel().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sampleInfoId=").append(sampleInfoId);
        sb.append(", sampleNum=").append(sampleNum);
        sb.append(", originalNum=").append(originalNum);
        sb.append(", wordAddr=").append(wordAddr);
        sb.append(", txtAddr=").append(txtAddr);
        sb.append(", pictureAddr=").append(pictureAddr);
        sb.append(", createTime=").append(createTime);
        sb.append(", isdel=").append(isdel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}