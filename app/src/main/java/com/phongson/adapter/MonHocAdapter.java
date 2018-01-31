package com.phongson.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.phongson.R;
import com.phongson.activity.DangKyMHActivity;
import com.phongson.model.MonHoc;

import java.util.List;

/**
 * Created by QUYEN PHONG on 12/15/2017.
 */

public class MonHocAdapter extends ArrayAdapter<MonHoc> {
    Activity context;
    int resource;
    List<MonHoc> objects;
    public MonHocAdapter(@NonNull Activity context, int resource, @NonNull List<MonHoc> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects= objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View item;
        MonHoc monHoc = objects.get(position);
        LayoutInflater inflater = this.context.getLayoutInflater();
        item = inflater.inflate(R.layout.item_dangky_monhoc,null);

        TextView txtTenMH = item.findViewById(R.id.txtMonHoc);
        TextView txtTinChi = item.findViewById(R.id.txtSoTinChi);

        txtTenMH.setText(monHoc.getTenMH());
        txtTinChi.setText(monHoc.getTinChi()+"");
        for (int i = 0; i< DangKyMHActivity.ViTri.size(); i++)
        {
            if (position==DangKyMHActivity.ViTri.get(i))
            {
                item.setBackgroundColor(Color.GRAY);
            }
        }
        return item;
    }
}
