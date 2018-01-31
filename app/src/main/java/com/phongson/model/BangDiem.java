package com.phongson.model;

/**
 * Created by QUYEN PHONG on 12/15/2017.
 */

public class BangDiem {
    private double tongDiem;
    private int maMH,maSSV;
    private String tenMH;

    public BangDiem(double tongDiem, int maMH, int maSSV, String tenMH) {
        this.tongDiem = tongDiem;
        this.maMH = maMH;
        this.maSSV = maSSV;
        this.tenMH = tenMH;
    }

    public BangDiem() {
    }

    public double getTongDiem() {
        return tongDiem;
    }

    public void setTongDiem(double tongDiem) {
        this.tongDiem = tongDiem;
    }

    public int getMaMH() {
        return maMH;
    }

    public void setMaMH(int maMH) {
        this.maMH = maMH;
    }

    public int getMaSSV() {
        return maSSV;
    }

    public void setMaSSV(int maSSV) {
        this.maSSV = maSSV;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }
}
