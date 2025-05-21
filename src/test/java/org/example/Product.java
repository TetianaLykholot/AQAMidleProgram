package org.example;

public class Product {

    private int quantity;
    private String id;

    public Product( String idOfProduct, int quantity) {
        this.quantity = quantity;
        this.id = idOfProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
