package com.example.listview_appirest.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.listview_appirest.Modelo.Producto;
import com.example.listview_appirest.R;

import java.util.ArrayList;

public class AdaptadorProducto extends ArrayAdapter<Producto> {
    public AdaptadorProducto(Context context, ArrayList<Producto> datos) {
        super(context, R.layout.ly_itemproducto, datos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.ly_itemproducto, null);

        ImageView imageView = item.findViewById(R.id.imgProduct);
        Glide.with(getContext())
                .load(getItem(position).getImage())
                .into(imageView);

        TextView lblCategoria = item.findViewById(R.id.lblCategoria);
        lblCategoria.setText(getItem(position).getCategory());

        TextView lblText1 = item.findViewById(R.id.lblText1);
        lblText1.setText(getItem(position).getTitle());

        TextView lblPrice = item.findViewById(R.id.lblPrice);
        lblPrice.setText(String.valueOf(getItem(position).getPrice()));

        TextView lblDesc = item.findViewById(R.id.lblDesc);
        lblDesc.setText(getItem(position).getDescription());

        return item;
    }
}