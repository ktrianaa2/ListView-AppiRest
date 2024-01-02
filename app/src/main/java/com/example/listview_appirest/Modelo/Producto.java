package com.example.listview_appirest.Modelo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
public class Producto implements Serializable {
     private int id;
     private String title;
     private double price;
     private String description;
     private String category;
     private String image;
     private double rating;
     private int ratingCount;

     public Producto(JSONObject jsonProducto) throws JSONException {
         id = jsonProducto.getInt("id");
         title = jsonProducto.getString("title");
         price = jsonProducto.getDouble("price");
         description = jsonProducto.getString("description");
         category = jsonProducto.getString("category");
         image = jsonProducto.getString("image");

         JSONObject jsonRating = jsonProducto.getJSONObject("rating");
         rating = jsonRating.getDouble("rate");
         ratingCount = jsonRating.getInt("count");
     }

     public static ArrayList<Producto> fromJsonArray(JSONArray jsonArray) throws JSONException {
         ArrayList<Producto> productos = new ArrayList<>();
         for (int i = 0; i < jsonArray.length() && i < 20; i++) {
             JSONObject jsonProducto = jsonArray.getJSONObject(i);
             productos.add(new Producto(jsonProducto));
         }
         return productos;
     }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getImage() {
        return image;
    }

    public double getRating() {
        return rating;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }
}
