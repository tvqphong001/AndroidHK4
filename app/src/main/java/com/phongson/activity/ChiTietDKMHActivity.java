package com.phongson.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.phongson.R;
import com.phongson.adapter.ChiTietDKAdapter;
import com.phongson.model.ChiTietDKMH;
import com.phongson.model.SinhVien;

import java.util.ArrayList;

public class ChiTietDKMHActivity extends AppCompatActivity {

    DatabaseReference mRoot = FirebaseDatabase.getInstance().getReference();
    Button btnDangKy,btnGioiThieu,btnLienHe;
    public static ArrayList<ChiTietDKMH> listChiTiet;
    SinhVien sinhVien ;
    ChiTietDKAdapter adapter;

    ListView lvChiTietDKMH;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_dkmh);
        sinhVien = TrangChuActivity.sinhVien;
        addConTrols();
        getData();
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
        lvChiTietDKMH.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ChiTietDKMHActivity.this,ChiTietMHDKActivity.class);
                intent.putExtra("ViTri",position);
                startActivity(intent);
                return false;
            }
        });
    }

    private void getData() {
        mRoot.child("ChiTietDKMH").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ChiTietDKMH chiTietDKMH = dataSnapshot.getValue(ChiTietDKMH.class);
                if (chiTietDKMH.getMSSV()==MainActivity.sinhVien.getMaSV()) {
                    listChiTiet.add(chiTietDKMH);
                    adapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                ChiTietDKMH chiTietDKMH = dataSnapshot.getValue(ChiTietDKMH.class);
                if (chiTietDKMH.getMSSV()==TrangChuActivity.MSSV) {
                    listChiTiet.add(chiTietDKMH);
                    adapter.notifyDataSetChanged();

                }
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
    private void addConTrols() {
        lvChiTietDKMH = findViewById(R.id.lvChiTietDKMH);
        btnDangKy = findViewById(R.id.btnDangKy);
        btnLienHe = findViewById(R.id.btnLienHe);
        btnGioiThieu = findViewById(R.id.btnGioiThieu);
        listChiTiet = TrangChuActivity.listCTDKMH;
        listChiTiet = new ArrayList<>();
        adapter = new ChiTietDKAdapter(this,R.layout.item_chitiet,listChiTiet);
        lvChiTietDKMH.setAdapter(adapter);

    }
}
