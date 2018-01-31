package com.phongson.model;

/**
 * Created by QUYEN PHONG on 12/15/2017.
 */

public class MonHoc {
    private int maMH, tinChi, hocKy, maGV;
    private String tenMH,tenKhoa;

    public MonHoc() {

    }

    public MonHoc(int maMH, int tinChi, int hocKy, int maGV, String tenMH, String tenKhoa) {
        this.maMH = maMH;
        this.tinChi = tinChi;
        this.hocKy = hocKy;
        this.maGV = maGV;
        this.tenMH = tenMH;
        this.tenKhoa = tenKhoa;
    }

    public int getMaMH() {
        return maMH;
    }

    public void setMaMH(int maMH) {
        this.maMH = maMH;
    }

    public int getTinChi() {
        return tinChi;
    }

    public void setTinChi(int tinChi) {
        this.tinChi = tinChi;
    }

    public int getHocKy() {
        return hocKy;
    }

    public void setHocKy(int hocKy) {
        this.hocKy = hocKy;
    }

    public int getMaGV() {
        return maGV;
    }

    public void setMaGV(int maGV) {
        this.maGV = maGV;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }
}
