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
public class GPU extends Item {
    private int power;
    
    // default constructor
    GPU(){
    }
    
    // custom constructor
    public GPU(String name, String type, double price, int sku, int stock, int power){
        this.name = name;
        this.type = type;
        this.price = price;
        this.sku = sku;
        this.stock = stock;
        this.power = power;
    }

    // accessor and mutator methods
    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
    
}
