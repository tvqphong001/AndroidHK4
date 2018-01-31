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

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.phongson.R;
import com.phongson.model.ChiTietDKMH;
import com.phongson.model.MonHoc;
import com.phongson.model.SinhVien;

import java.util.ArrayList;

public class TrangChuActivity extends AppCompatActivity {

    public static int MSSV;
    public static String TenKhoa;
    public static SinhVien sinhVien;
    Button btnDangKy,btnGioiThieu,btnLienHe;
    public static ArrayList<ChiTietDKMH> listCTDKMH;
    public static ArrayList<MonHoc> listMonHoc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trang_chu);
        setData();
        addControls();
        addEvents();
        getDataCTDKMH();
        getData();




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
    private void getDataCTDKMH() {
        listCTDKMH.clear();
        MainActivity.mRoot.child("ChiTietDKMH").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                ChiTietDKMH chiTietDKMH = dataSnapshot.getValue(ChiTietDKMH.class);
                if (sinhVien.getMaSV()==chiTietDKMH.getMSSV()) {
                    addtoChiTiet(chiTietDKMH);
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void addtoChiTiet(ChiTietDKMH chiTietDKMH) {
        listCTDKMH.add(chiTietDKMH);
    }


    private void getData() {
        listMonHoc.clear();
        MainActivity.mRoot.child("MonHoc").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                MonHoc monHoc = dataSnapshot.getValue(MonHoc.class);
                addToList(monHoc);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    private void addToList(MonHoc monHoc) {
        if (monHoc.getTenKhoa().compareTo(sinhVien.getTenKhoa())==0) {
            listMonHoc.add(monHoc);

        }
    }
    private void setData() {
        sinhVien = MainActivity.sinhVien;
       Intent intent = getIntent();
       MSSV = intent.getIntExtra("MSSV",-1);
       // Toast.makeText(this, String.valueOf(MSSV), Toast.LENGTH_SHORT).show();
    }


    private void addEvents() {
        btnGioiThieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrangChuActivity.this,Google_map.class);
                startActivity(intent);
            }
        });
        btnLienHe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrangChuActivity.this,LienHeActivity.class);
                startActivity(intent);
            }
        });
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrangChuActivity.this,DangKyMHActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addControls() {
        btnDangKy = findViewById(R.id.btnDangKy);
        btnLienHe = findViewById(R.id.btnLienHe);
        btnGioiThieu = findViewById(R.id.btnGioiThieu);
        //btnTrangChu = findViewById(R.id.btnTrangchu);
        listMonHoc = new ArrayList<>();
        listCTDKMH = new ArrayList<>();

    }
}
