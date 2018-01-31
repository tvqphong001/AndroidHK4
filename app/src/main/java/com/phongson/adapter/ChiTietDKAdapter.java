package com.phongson.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.phongson.R;
import com.phongson.model.ChiTietDKMH;

import java.util.List;

/**
 * Created by QUYEN PHONG on 12/22/2017.
 */

public class ChiTietDKAdapter extends ArrayAdapter<ChiTietDKMH> {

    Activity context;
    int resource;
    List<ChiTietDKMH> objects;
    public ChiTietDKAdapter(@NonNull Activity context, int resource, @NonNull List<ChiTietDKMH> objects) {
        super(context, resource, objects);
        this.context = context;
        this.objects = objects;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View item;
        ChiTietDKMH chiTietDKMH = objects.get(position);
        item = this.context.getLayoutInflater().inflate(R.layout.item_chitiet,null);
        TextView txtTenMh = item.findViewById(R.id.txtTenMh);
        TextView txtSoTC = item.findViewById(R.id.txtSoTinChi);

        txtTenMh.setText(chiTietDKMH.getTenMH());
        txtSoTC.setText(chiTietDKMH.getSoTC()+"");
        return item;
    }
}
