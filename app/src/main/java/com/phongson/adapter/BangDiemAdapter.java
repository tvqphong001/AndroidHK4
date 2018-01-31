package com.phongson.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.phongson.R;
import com.phongson.model.BangDiem;

import java.util.List;

/**
 * Created by QUYEN PHONG on 12/25/2017.
 */

public class BangDiemAdapter extends ArrayAdapter<BangDiem> {
    Activity context;
    int resource;
    List<BangDiem> objects;
    public BangDiemAdapter(@NonNull Activity context, int resource, @NonNull List<BangDiem> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view;
        BangDiem bangDiem = objects.get(position);
        view = this.context.getLayoutInflater().inflate(R.layout.item_diem,null);
        TextView txtTenMh = view.findViewById(R.id.txtTenMh);
        TextView txtDiem = view.findViewById(R.id.txtDiem);

        txtTenMh.setText(bangDiem.getTenMH());
        txtDiem.setText(bangDiem.getTongDiem()+"");
        return view;
    }
}
