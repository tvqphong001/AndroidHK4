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

public class LienHeActivity extends AppCompatActivity {
    Button btnDangKy,btnGioiThieu,btnLienHe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lien_he);
        btnDangKy = findViewById(R.id.btnDangKy);
        btnLienHe = findViewById(R.id.btnLienHe);
        btnGioiThieu = findViewById(R.id.btnGioiThieu);
        addEvent();
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
                MSSV.setText(TrangChuActivity.sinhVien.getMaSV()+"");
                TenSV.setText(TrangChuActivity.sinhVien.getTenSV());
                NamHoc.setText(TrangChuActivity.sinhVien.getNamHoc()+"");
                TenKhoa.setText(TrangChuActivity.sinhVien.getTenKhoa());
                SDT.setText(TrangChuActivity.sinhVien.getSdt());

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
    private void addEvent() {
        btnGioiThieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LienHeActivity.this,Google_map.class);
                startActivity(intent);
            }
        });
        btnLienHe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LienHeActivity.this,LienHeActivity.class);
                startActivity(intent);
            }
        });
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LienHeActivity.this,DangKyMHActivity.class);
                startActivity(intent);
            }
        });
    }
}
