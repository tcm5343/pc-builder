/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author tcm5343
 */
public class Item {
    protected String name;
    protected String type;
    protected double price;
    protected int sku;
    protected int stock;
    
    // default constructor
    Item(){  
    }
    
    // custom constructor
    public Item(String name, String type, double price, int sku, int stock){
        this.name = name;
        this.type = type;
        this.price = price;
        this.sku = sku;
        this.stock = stock;
    }
    
    // accessor and mutator methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
