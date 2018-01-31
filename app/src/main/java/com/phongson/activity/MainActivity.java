package com.phongson.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.phongson.R;
import com.phongson.model.BangDiem;
import com.phongson.model.GiangVien;
import com.phongson.model.MonHoc;
import com.phongson.model.SinhVien;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText txtUserName, txtPassWord;
    Button btnLogin,btnExit;
    public static DatabaseReference mRoot = FirebaseDatabase.getInstance().getReference();
    public static ArrayList<SinhVien> listSinhVien = new ArrayList<>();
    int flag =0;
    public static SinhVien sinhVien;
    public static ArrayList<BangDiem> listBangDiem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addConTrols();
        txtUserName.setText("51401027");
        txtPassWord.setText("51401027");
        getdata();
        //setdataMH();
        //setdataGV();
        //setdataBangDiem();
        listBangDiem.clear();
        addEvents();



    }
    private void getDataBangDiem() {
        MainActivity.mRoot.child("BangDiem").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                BangDiem bangDiem = dataSnapshot.getValue(BangDiem.class);
                if (sinhVien.getMaSV()==bangDiem.getMaSSV()) {
                    listBangDiem.add(bangDiem);
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
    private void setdataBangDiem() {
        BangDiem bd1 = new BangDiem(5.5,1,51401029,"Cong Nghe Sinh Hoc");
        BangDiem bd2 = new BangDiem(7.0,4,51401027,"Tin học đại cương");
        BangDiem bd3 = new BangDiem(8.0,6,51401029,"Nuôi vi sinh vật");
        BangDiem bd4 = new BangDiem(9.5,10,51401027,"Quản trị csdl");
        BangDiem bd5 = new BangDiem(6.5,7,51401028,"Kinh doanh quốc tế");
        mRoot.child("BangDiem").push().setValue(bd1);
        mRoot.child("BangDiem").push().setValue(bd2);
        mRoot.child("BangDiem").push().setValue(bd3);
        mRoot.child("BangDiem").push().setValue(bd4);
        mRoot.child("BangDiem").push().setValue(bd5);
    }

    private void setdataGV() {
        GiangVien gv1 = new GiangVien(20,"Kha kha kha","09127375875");
        GiangVien gv2 = new GiangVien(21,"Nguyễn Chung Tú","0989898989");
        GiangVien gv3 = new GiangVien(22,"Thái Kim Thanh","0969696969");
        GiangVien gv4 = new GiangVien(23,"Hồ Tuyết Phương","0900000000");
        GiangVien gv5 = new GiangVien(24,"Nguyễn Văn Sinh","01645236478");
        mRoot.child("GiangVien").push().setValue(gv1);
        mRoot.child("GiangVien").push().setValue(gv2);
        mRoot.child("GiangVien").push().setValue(gv3);
        mRoot.child("GiangVien").push().setValue(gv4);
        mRoot.child("GiangVien").push().setValue(gv5);

    }

    private void setdataMH() {
        MonHoc mh1 = new MonHoc(11,5,4,21,"Lý Luận chính trị cuối khóa","Công nghệ thông tin");
        MonHoc mh2 = new MonHoc(12,3,2,20,"Kinh doanh quốc tế","Quản trị kinh doanh");
        MonHoc mh3 = new MonHoc(13,3,3,20,"Lập trình android","Công nghệ thông tin");
        MonHoc mh4 = new MonHoc(14,2,2,22,"Quản lý doanh nghiệp","Quản trị kinh doanh");
        MonHoc mh5 = new MonHoc(15,3,4,23,"Thống kê vĩ mô","Quản trị kinh doanh");
        MonHoc mh6 = new MonHoc(16,3,4,24,"Công nghệ mùi tổng hợp","Công nghệ thực phẩm");
        MonHoc mh7 = new MonHoc(17,2,1,21,"Nhập môn kế toán","Quản trị kinh doanh");
        MonHoc mh8 = new MonHoc(18,4,3,22,"Lập trình web","Công nghệ thông tin");
        MonHoc mh9 = new MonHoc(19,2,2,21,"Thuế nhà nước","Quản trị kinh doanh");
        MonHoc mh10 = new MonHoc(20,3,4,24,"Phương pháp lên men","Công nghệ thực phẩm");
        mRoot.child("MonHoc").push().setValue(mh1);
        mRoot.child("MonHoc").push().setValue(mh2);
        mRoot.child("MonHoc").push().setValue(mh3);
        mRoot.child("MonHoc").push().setValue(mh4);
        mRoot.child("MonHoc").push().setValue(mh5);
        mRoot.child("MonHoc").push().setValue(mh6);
        mRoot.child("MonHoc").push().setValue(mh7);
        mRoot.child("MonHoc").push().setValue(mh8);
        mRoot.child("MonHoc").push().setValue(mh9);
        mRoot.child("MonHoc").push().setValue(mh10);

    }

    private void getdata() {
        listSinhVien.clear();
       mRoot.child("SinhVien").addChildEventListener(new ChildEventListener() {
           @Override
           public void onChildAdded(DataSnapshot dataSnapshot, String s) {
               SinhVien sinhVien;
               sinhVien = dataSnapshot.getValue(SinhVien.class);
               addusertolist(sinhVien);

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

    private void setdata() {
        SinhVien sv1 = new SinhVien(51401027,2014,"Trần Vương Quyền Phong","0917250405", "Công nghệ thông tin");
        SinhVien sv2 = new SinhVien(51401028,2015,"Nguyễn Thùy Trang","0984658795", "Quản trị kinh doanh");
        SinhVien sv3 = new SinhVien(51401029,2016,"Phạm Tiến Đạt","090996699", "Công nghệ thực phẩm");
        SinhVien sv4 = new SinhVien(51401030,2014,"Võ Hoàng Sơn","0918746584", "Công nghệ thông tin");
        SinhVien sv5 = new SinhVien(51401031,2017,"Hari won","0969696969", "Quản trị kinh doanh");
        mRoot.child("SinhVien").push().setValue(sv1);
        mRoot.child("SinhVien").push().setValue(sv2);
        mRoot.child("SinhVien").push().setValue(sv3);
        mRoot.child("SinhVien").push().setValue(sv4);
        mRoot.child("SinhVien").push().setValue(sv5);
    }

    private void addEvents() {
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kiemtra();
                flag=0;
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        flag =0;
        listBangDiem.clear();
    }

    private void kiemtra() {
        final String id=txtUserName.getText().toString();
        final String password = txtPassWord.getText().toString();
        mRoot.child("SinhVien").addChildEventListener(new ChildEventListener() {

            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.d("aa",id);
                SinhVien sinhVien = dataSnapshot.getValue(SinhVien.class);
                if(id.equals(sinhVien.getMaSV()+"")&&password.equals(sinhVien.getMaSV()+""))
                {
                    login(sinhVien,sinhVien.getMaSV());
                }
                else if (flag==0&&id.compareTo(String.valueOf(sinhVien.getMaSV()))!=0&&password.compareTo(sinhVien.getMaSV()+"")!=0){
                    Toast.makeText(MainActivity.this, "Đăng Nhập Thất Bại!", Toast.LENGTH_SHORT).show();
                    flag =1;
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

    private void addusertolist(SinhVien sinhVien) {
        listSinhVien.add(sinhVien);
    }

    private void login(SinhVien sv, int MSSV) {
        flag =1;
        Intent intent =new Intent(MainActivity.this,TrangChuActivity.class);
        intent.putExtra("MSSV", MSSV);
        Toast.makeText(this, "Đăng Nhập Thành Công!", Toast.LENGTH_SHORT).show();
        sinhVien = sv;
        getDataBangDiem();
        startActivity(intent);
    }


    private void addConTrols() {
        txtPassWord = findViewById(R.id.etPassword);
        txtUserName = findViewById(R.id.txtUserName);
        btnLogin=findViewById(R.id.btnLogIn);
        btnExit = findViewById(R.id.btnExit);
        listSinhVien = new ArrayList<>();
        listBangDiem = new ArrayList<>();

    }
}
