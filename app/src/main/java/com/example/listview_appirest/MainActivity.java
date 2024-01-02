package com.example.listview_appirest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.listview_appirest.Adaptador.AdaptadorProducto;
import com.example.listview_appirest.Modelo.Producto;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import WebServices.Asynchtask;
import WebServices.WebService;

public class MainActivity extends AppCompatActivity implements Asynchtask, AdapterView.OnItemClickListener {

    ListView lstOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstOpciones = findViewById(R.id.listProducto);

        Map<String, String> datos = new HashMap<>();
        WebService ws = new WebService("https://fakestoreapi.com/products",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        JSONArray JSONlistaProductos = new JSONArray(result);
        ArrayList<Producto> lstProductos = Producto.fromJsonArray(JSONlistaProductos);

        AdaptadorProducto adaptadorProductos = new AdaptadorProducto(this, lstProductos);
        lstOpciones.setAdapter(adaptadorProductos);

    }

     @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
         Intent intent = new Intent(MainActivity.this, MainActivity2.class);
         startActivity(intent);
    }


}