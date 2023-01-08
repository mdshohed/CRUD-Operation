package com.example.crud.entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;

public class Information {
    public SimpleIntegerProperty id;
    public SimpleStringProperty product;
    public SimpleStringProperty seller;
    public SimpleStringProperty price;
    public Button edit;
    public Button delete;

    Information(Integer id1, String product1, String seller1, String price1, Button edit1, Button delete1){
        this.id = new SimpleIntegerProperty(id1);
        this.product = new SimpleStringProperty(product1);
        this.seller = new SimpleStringProperty(seller1);
        this.price = new SimpleStringProperty(price1);
        this.edit = edit1;
        this.delete = delete1;
    }

    public Integer getId(){
        return id.get();
    }

    public String getProduct(){
        return product.get();
    }

    public String getSeller(){
        return seller.get();
    }

    public String getPrice(){
        return price.get();
    }

    public Button getEdit(){
        return edit;
    }

    public Button getDelete(){
        return  delete;
    }
}
