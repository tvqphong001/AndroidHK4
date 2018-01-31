package com.phongson.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.phongson.R;
import com.phongson.adapter.MonHocAdapter;
import com.phongson.model.BangDiem;
import com.phongson.model.ChiTietDKMH;
import com.phongson.model.GiangVien;
import com.phongson.model.MonHoc;
import com.phongson.model.SinhVien;

import java.util.ArrayList;

public class DangKyMHActivity extends AppCompatActivity {

    ListView lvDSMonHoc;
    LinearLayout LayDKMH;
    Button btnDangKyAc,btnGioiThieu,btnLienHe;
    ArrayList<BangDiem> listBangDiem;
    ArrayList<ChiTietDKMH> listChiTietDK;
    public static ArrayList<GiangVien> listGiangVien;
    public static ArrayList<Integer> ViTri = new ArrayList<>();
    SinhVien sinhVien;
    MonHocAdapter adapter;
    Button btnDangKy, btnChiTietDK;
    DatabaseReference mRoot = FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangky);
        sinhVien = TrangChuActivity.sinhVien;
        addConTrols();
        getdataGV();
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

    private void getdataGV() {
        mRoot.child("GiangVien").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                GiangVien giangVien = dataSnapshot.getValue(GiangVien.class);
                listGiangVien.add(giangVien);
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

    private void themGV(GiangVien giangVien) {
        listGiangVien.add(giangVien);
    }


    private void addEvent() {
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
        btnDangKyAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DangKyMHActivity.class);
                startActivity(intent);
            }
        });
        btnChiTietDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ChiTietDKMHActivity.class);
                startActivity(intent);
            }
        });
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(kiemTraDK()==1) {
                    dangkyMH();
                    Intent intent = new Intent(DangKyMHActivity.this, ChiTietDKMHActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(DangKyMHActivity.this, "Đăng ký không thành công!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        lvDSMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(DangKyMHActivity.this,ChiTietMonHocActivity.class);
                intent.putExtra("ViTri",position);
                startActivity(intent);
                return false;
            }
        });
        lvDSMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(kiemtrachon(position)==1)
                {
//                    for (int i = 0; i <lvDSMonHoc.getCount(); i++) {
//
//                        if(position == i ){
//                            lvDSMonHoc.getChildAt(i).setBackgroundColor(Color.WHITE);
//                        }
//
////                    else{
////                        lvDSMonHoc.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
////                    }
//                    }
                    view.setBackgroundColor(Color.WHITE);
                    xoaChiTiet(TrangChuActivity.listMonHoc.get(position));
                }
                else {
//                    for (int i = 0; i < lvDSMonHoc.getCount(); i++) {
//                        if (position == i) {
//                            lvDSMonHoc.getChildAt(i).setBackgroundColor(Color.GRAY);
//                            themVT(position);
//                            Toast.makeText(DangKyMHActivity.this, "Chon", Toast.LENGTH_SHORT).show();
//                            themCTMH(TrangChuActivity.listMonHoc.get(position));
//                        }
//
////                    else{
////                        lvDSMonHoc.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
////                    }
//                    }
                            view.setBackgroundColor(Color.GRAY);
                            themVT(position);
                            themCTMH(TrangChuActivity.listMonHoc.get(position));
                }
            }

        });

    }

    private int kiemTraDK() {
        int j=0,k=0;
        if (listChiTietDK.size()==0)
        {
            return 0;
        }
        for (int s=0;s<listChiTietDK.size();s++)
        {
            while (k<listBangDiem.size())
            {
                if (listChiTietDK.get(s).getMSMH()==listBangDiem.get(k).getMaMH())
                {
                    Toast.makeText(this, "Môn Học: " +listChiTietDK.get(s).getTenMH()+" Đã Học trước đó!" , Toast.LENGTH_SHORT).show();
                    return 0;

                }
                k++;
                if (k==listBangDiem.size())
                {
                    k=0;
                    break;
                }
            }
        }
        for(int i = (TrangChuActivity.listCTDKMH.size()-1);i>=0;i--)
        {

            while (j<listChiTietDK.size())
            {
                if (TrangChuActivity.listCTDKMH.get(i).getMSMH()==listChiTietDK.get(j).getMSMH())
                {
                    Toast.makeText(this, "Môn Học: " +TrangChuActivity.listCTDKMH.get(i).getTenMH()+" Đã Tồn Tại!" , Toast.LENGTH_SHORT).show();
                    return 0;

               }
                j++;
                if (j==listChiTietDK.size())
                {
                    j=0;
                    break;
                }
            }
        }
        return 1;
    }

    private void dangkyMH() {
        if(listChiTietDK.size()>6)
        {
            Toast.makeText(this, "Số lượng đăng ký quá quy định", Toast.LENGTH_SHORT).show();
            return;
        }
        for (int i = listChiTietDK.size()-1;i>=0;i--)
        {
            TrangChuActivity.listCTDKMH.add(listChiTietDK.get(i));
            mRoot.child("ChiTietDKMH").push().setValue(listChiTietDK.get(i));
        }
        listChiTietDK.clear();
        for (int i = 0; i < lvDSMonHoc.getChildCount(); i++) {

                lvDSMonHoc.getChildAt(i).setBackgroundColor(Color.WHITE);

        }
        ViTri.clear();
    }

    private void xoaChiTiet(MonHoc monHoc) {
        int mamh = monHoc.getMaMH();
        for (int i = listChiTietDK.size()-1;i>=0;i--)
        {
            if (listChiTietDK.get(i).getMSMH()==mamh)
            {
                listChiTietDK.remove(i);
                break;
            }
        }
    }

    private void themCTMH(MonHoc monHoc) {
        int mamh = monHoc.getMaMH();
        int mssv = sinhVien.getMaSV();
        int sotc = monHoc.getTinChi();
        String tenMH = monHoc.getTenMH();
        ChiTietDKMH chiTietDKMH = new ChiTietDKMH();
        chiTietDKMH.setMSSV(mssv);
        chiTietDKMH.setMSMH(mamh);
        chiTietDKMH.setTenMH(tenMH);
        chiTietDKMH.setSoTC(sotc);
        listChiTietDK.add(chiTietDKMH);


    }

    private int kiemtrachon(int position) {
        for (int i = ViTri.size()-1;i>=0;i--)
        {
            if (ViTri.get(i)==position) {
                ViTri.remove(i);
                return 1;
            }
        }
        return 0;
    }

    private void themVT(int position) {
        ViTri.add(position);


    }

    private void addConTrols() {
        lvDSMonHoc=findViewById(R.id.lvDanhSachMonHoc);
        btnDangKy=findViewById(R.id.btnDangKyMonHoc);
        LayDKMH = findViewById(R.id.LayDKMH);
        btnChiTietDK = findViewById(R.id.btnChiTietDK);
        btnDangKyAc = findViewById(R.id.btnDangKy);
        btnLienHe = findViewById(R.id.btnLienHe);
        btnGioiThieu = findViewById(R.id.btnGioiThieu);
        listBangDiem=MainActivity.listBangDiem;
        listGiangVien = new ArrayList<>();
        listChiTietDK = new ArrayList<>();
        listChiTietDK.clear();
        ViTri.clear();
        adapter = new MonHocAdapter(this,R.layout.item_dangky_monhoc,TrangChuActivity.listMonHoc);
        lvDSMonHoc.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }


}
