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
public class MOBO extends Item {
    private int size;
    private int ramType;
    private String socket;
    
    // this is to allow size to be stored as an int but to display a string
    // sorry it is hardcoded but these are the only sizes we will have
    private static final String[] NAMES 
            = new String[]{"mini-ITX","micro-ATX","ATX"};
    
    // default constructor
    MOBO(){
    }
    
    // custom constructor
    public MOBO(String name, String type, double price, int sku, int stock, int size, 
            int ramType, String socket){
        this.name = name;
        this.type = type;
        this.price = price;
        this.sku = sku;
        this.stock = stock;
        this.size = size;
        this.ramType = ramType;
        this.socket = socket;
    }

    // accessor and mutator methods
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getRamType() {
        return ramType;
    }

    public void setRamType(int ramType) {
        this.ramType = ramType;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }
    
    // this is the special method which uses NAMES
    public String getSizeName(int index){
        return NAMES[index];
    }
}
