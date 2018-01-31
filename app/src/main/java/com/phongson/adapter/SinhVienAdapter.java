package com.phongson.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.phongson.R;
import com.phongson.model.SinhVien;

import java.util.List;

/**
 * Created by QUYEN PHONG on 12/20/2017.
 */

public class SinhVienAdapter extends ArrayAdapter<SinhVien> {

    Activity context;
    int resource;
    List<SinhVien> objects;
    public SinhVienAdapter(@NonNull Activity context, int resource, @NonNull List<SinhVien> objects) {
        super(context, resource, objects);
        this.context = context;
        this.objects = objects;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View item;
        SinhVien sinhVien = objects.get(position);
        item = this.context.getLayoutInflater().inflate(R.layout.item_sv,null);
        TextView txtTenSV = item.findViewById(R.id.txtTenSV);
        TextView txtMSSV = item.findViewById(R.id.txtMSSV);

        txtMSSV.setText(sinhVien.getMaSV()+"");
        txtTenSV.setText(sinhVien.getTenSV());
        return item;
    }
}
