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
public class PSU extends Item {
    private int modular;
    private int power;
    
    // default constructor
    PSU(){
    }
    
    // custom constructor
    public PSU(String name, String type, double price, int sku, int stock, int modular, int power){
        this.name = name;
        this.type = type;
        this.price = price;
        this.sku = sku;
        this.stock = stock;
        this.modular = modular; // will be a one or zero
        this.power = power;
    }

    // accessor and mutator methods
    public Boolean isModular() {
        if (modular == 1){
            return true;
        }
        else {
            return false;
        }
    }

    public int getModular() {
        return modular;
    }

    public void setModular(int modular) {
        this.modular = modular;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
    
}
