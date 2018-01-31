package com.phongson.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.phongson.R;
import com.phongson.model.SinhVien;

public class Google_map extends AppCompatActivity implements OnMapReadyCallback {

    SinhVien sinhVien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);
        sinhVien = TrangChuActivity.sinhVien;
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng dhcnsg = new LatLng(10.738258, 106.677964);
        googleMap.addMarker(new MarkerOptions().position(dhcnsg)
                .title("Marker in Saigon University Technology"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(dhcnsg));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(dhcnsg,17));
    }
}
