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
import java.util.Comparator;
 
public class PriceSorter implements Comparator<Item> 
{
    @Override
    public int compare(Item o1, Item o2) {
        if (o1.getPrice() > o2.getPrice() )
                return 1; 
        else if (o1.getPrice() < o2.getPrice())
                return -1;
        else 
        return 0;
                
    } // end of compare
	
} // end of class