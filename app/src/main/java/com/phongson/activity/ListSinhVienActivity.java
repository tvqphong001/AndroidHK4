package com.phongson.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.phongson.R;
import com.phongson.adapter.SinhVienAdapter;
import com.phongson.model.SinhVien;

import java.util.ArrayList;

public class ListSinhVienActivity extends AppCompatActivity {

    ListView lisSV;
    ArrayList<SinhVien> listSinhvien;

    SinhVienAdapter adapter;
    DatabaseReference mRoot = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_sinh_vien);
        lisSV = findViewById(R.id.lisSV);
        listSinhvien = new ArrayList<>();

        adapter = new SinhVienAdapter(this,R.layout.item_sv,listSinhvien);
        lisSV.setAdapter(adapter);
        SinhVien sv1 = new SinhVien(1,2013,"123123","0099","Desige");
        mRoot.child("SinhVien").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                SinhVien sinhVien = dataSnapshot.getValue(SinhVien.class);
                themSV(sinhVien);
                adapter.notifyDataSetChanged();
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
        listSinhvien.size();

    }

    private void themSV(SinhVien sinhVien) {
        listSinhvien.add(sinhVien);
    }
}
