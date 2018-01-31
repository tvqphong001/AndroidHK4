package com.phongson.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.phongson.R;
import com.phongson.model.MonHoc;
import com.phongson.model.SinhVien;

public class ChiTietMHDKActivity extends AppCompatActivity {

    TextView txtMaMh,txtTenMh,txtTenKhoa,txtTinChi,txtHocKy,txtTenGV;
    Button btnDangKy,btnGioiThieu,btnLienHe;
    SinhVien sinhVien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_mhdk);
        sinhVien =TrangChuActivity.sinhVien;
        addConTrols();
        setData();
        addEvents();
    }

    private void addEvents() {
        btnGioiThieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Google_map.class);
                startActivity(intent);
            }
        });
        btnLienHe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LienHeActivity.class);
                startActivity(intent);
            }
        });
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DangKyMHActivity.class);
                startActivity(intent);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuhs,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.mnuDangXuat:
                Intent intent4 = new Intent(this,MainActivity.class);
                startActivity(intent4);
                break;
            case R.id.mnuTrangChu:
                Intent intent3 = new Intent(this,TrangChuActivity.class);
                startActivity(intent3);
                break;
            case R.id.mnuBangDiem:
                Intent intent2 = new Intent(this,BangDiemActivity.class);
                startActivity(intent2);
                break;
            case R.id.mnuAbout:
                TextView MSSV,TenSV,NamHoc,TenKhoa,SDT;
                final Dialog dialog = new Dialog(this);
                dialog.setContentView(R.layout.chitiet_sv);
                MSSV = dialog.findViewById(R.id.MSSV);
                TenSV = dialog.findViewById(R.id.TenSV);
                NamHoc = dialog.findViewById(R.id.NamHoc);
                TenKhoa = dialog.findViewById(R.id.TenKhoa);
                SDT = dialog.findViewById(R.id.SDT);
                MSSV.setText(sinhVien.getMaSV()+"");
                TenSV.setText(sinhVien.getTenSV());
                NamHoc.setText(sinhVien.getNamHoc()+"");
                TenKhoa.setText(sinhVien.getTenKhoa());
                SDT.setText(sinhVien.getSdt());

                dialog.show();
                break;
            case R.id.mnuBanDo:
                Intent intent = new Intent(this, Google_map.class);
                startActivity(intent);
                break;
            case R.id.mnuExit:
                Intent intent1 = new Intent(Intent.ACTION_MAIN);
                intent1.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent1);
                finish();

                break;
        }
        return super.onOptionsItemSelected(item);
    }


    private void setData() {
        Intent intent = getIntent();
        int vitri= intent.getIntExtra("ViTri",-1);

        MonHoc monHoc = getMonHoc(ChiTietDKMHActivity.listChiTiet.get(vitri).getMSMH());
        TrangChuActivity.listMonHoc.size();
        txtMaMh.setText(monHoc.getMaMH()+"");
        txtTenMh.setText(monHoc.getTenMH());
        txtTinChi.setText(monHoc.getTinChi()+"");
        txtHocKy.setText(monHoc.getHocKy()+"");
        txtTenKhoa.setText(monHoc.getTenKhoa());
        String tenGV = getTenGV(monHoc.getMaGV());
        txtTenGV.setText(tenGV);
    }
    private MonHoc getMonHoc(int mamh)
    {
        for (int i=0;i< TrangChuActivity.listMonHoc.size();i++)
        {
            if(TrangChuActivity.listMonHoc.get(i).getMaMH()==mamh)
            {
                return TrangChuActivity.listMonHoc.get(i);
            }
        }
        return null;
    }
    private String getTenGV(int maGV) {
        String tenGV = "";
        for (int i= (DangKyMHActivity.listGiangVien.size()-1);i>=0;i--)
        {
            if (DangKyMHActivity.listGiangVien.get(i).getMaGV()==maGV)
            {
                tenGV = DangKyMHActivity.listGiangVien.get(i).getTenGV();
                break;
            }
        }
        return tenGV;
    }

    private void addConTrols() {
        txtMaMh = findViewById(R.id.txtMaMh);
        txtTenMh = findViewById(R.id.txtTenMh);
        txtTinChi = findViewById(R.id.txtTinChi);
        txtHocKy = findViewById(R.id.txtHocKy);
        txtTenKhoa = findViewById(R.id.txtTenKhoa);
        txtTenGV = findViewById(R.id.txtTenGV);
        btnDangKy = findViewById(R.id.btnDangKy);
        btnLienHe = findViewById(R.id.btnLienHe);
        btnGioiThieu = findViewById(R.id.btnGioiThieu);


    }
}
