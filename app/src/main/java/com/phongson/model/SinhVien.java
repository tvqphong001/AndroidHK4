package com.phongson.model;

/**
 * Created by QUYEN PHONG on 12/15/2017.
 */

public class SinhVien {
    int maSV,namHoc;
    String tenSV, sdt,tenKhoa;

    public SinhVien(int namHoc, String tenSV, String sdt, String tenKhoa) {
        this.namHoc = namHoc;
        this.tenSV = tenSV;
        this.sdt = sdt;
        this.tenKhoa = tenKhoa;
    }

    public SinhVien() {
    }

    public SinhVien(int maSV, int namHoc, String tenSV, String sdt, String tenKhoa) {
        this.maSV = maSV;
        this.namHoc = namHoc;
        this.tenSV = tenSV;
        this.sdt = sdt;
        this.tenKhoa = tenKhoa;
    }

    public int getMaSV() {
        return maSV;
    }

    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }

    public int getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(int namHoc) {
        this.namHoc = namHoc;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }
}
