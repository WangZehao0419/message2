package cn.wzh.DTO;

import cn.wzh.entity.*;

public class SampleInfoDTO {
    private SampleInfo sampleInfo;

    private SampleToxinInfo sampleToxinInfo;

    private AddressProvince addressProvince;

    private AddressCity addressCity;

    private AddressTown addressTown;

    private CropSpecies cropSpecies;

    public SampleInfo getSampleInfo() {
        return sampleInfo;
    }

    public void setSampleInfo(SampleInfo sampleInfo) {
        this.sampleInfo = sampleInfo;
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
}
