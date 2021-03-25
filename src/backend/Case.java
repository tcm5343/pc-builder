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
public class Case extends Item {
    private int size;
    private static final String[] NAMES 
            = new String[]{"mini-ITX","micro-ATX","ATX"};
    
    // default constructor
    Case(){
    }
    
    // custom constructor
    public Case(String name, String type, double price, int sku, int stock, int size){
        this.name = name;
        this.type = type;
        this.price = price;
        this.sku = sku;
        this.stock = stock;
        this.size = size;
    }

    // accessor and mutator methods
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    // this is the special method which uses NAMES
    public String getSizeName(int index){
        return NAMES[index];
    }
}
