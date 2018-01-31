package com.phongson.model;

/**
 * Created by QUYEN PHONG on 12/15/2017.
 */

public class ChiTietDKMH {
    private int MSSV, MSMH,soTC;
    private String TenMH;

    public int getMSSV() {
        return MSSV;
    }

    public void setMSSV(int MSSV) {
        this.MSSV = MSSV;
    }

    public int getMSMH() {
        return MSMH;
    }

    public void setMSMH(int MSMH) {
        this.MSMH = MSMH;
    }

    public int getSoTC() {
        return soTC;
    }

    public void setSoTC(int soTC) {
        this.soTC = soTC;
    }

    public String getTenMH() {
        return TenMH;
    }

    public void setTenMH(String tenMH) {
        TenMH = tenMH;
    }

    public ChiTietDKMH() {
    }

    public ChiTietDKMH(int MSSV, int MSMH, int soTC, String tenMH) {
        this.MSSV = MSSV;
        this.MSMH = MSMH;
        this.soTC = soTC;
        TenMH = tenMH;
    }
}
