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
public class CPU extends Item {
    private String socket;
    private int power;
    
    // default constructor
    CPU(){
    }
    
    // custom constructor
    public CPU(String name, String type, double price, int sku, int stock, String socket, 
            int power){
        this.name = name;
        this.type = type;
        this.price = price;
        this.sku = sku;
        this.stock = stock;
        this.socket = socket;
        this.power = power;
    }

       
    

    // accessor and mutator methods
    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
    
    public String toString(){
        return name + "    " + type + " " + price + "       " + sku + "         " + stock;
    }
}
