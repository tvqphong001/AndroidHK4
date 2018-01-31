package com.phongson.model;

/**
 * Created by QUYEN PHONG on 12/15/2017.
 */

public class GiangVien {
    private int maGV;
    private String tenGV,sdt;

    public GiangVien() {
    }

    public GiangVien(int maGV, String tenGV, String sdt) {
        this.maGV = maGV;
        this.tenGV = tenGV;
        this.sdt = sdt;
    }

    public int getMaGV() {
        return maGV;
    }

    public void setMaGV(int maGV) {
        this.maGV = maGV;
    }

    public String getTenGV() {
        return tenGV;
    }

    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
