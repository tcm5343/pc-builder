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
public class RAM extends Item {
    private int ramType;
    
    // default constructor
    RAM(){
    }
    
    // custom constructor
    public RAM(String name, String type, double price, int sku, int stock, int ramType){
       this.name = name;
       this.type = type;
       this.price = price;
       this.sku = sku;
       this.stock = stock;
       this.ramType = ramType;
    }

    // accessor and mutator methods
    public int getRamType() {
        return ramType;
    }

    public void setRamType(int ramType) {
        this.ramType = ramType;
    }
}
