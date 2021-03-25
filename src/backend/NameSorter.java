package backend;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tcm5343
 */
import java.util.Comparator;
 
public class NameSorter implements Comparator<Item> 
{
    @Override
    public int compare(Item o1, Item o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    } // end of compare
	
} // end of class
