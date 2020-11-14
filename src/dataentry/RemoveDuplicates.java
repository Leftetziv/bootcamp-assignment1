/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataentry;

import java.util.ArrayList;

/**
 *
 * @author Leyteris
 */
public class RemoveDuplicates <T> {
    
    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> mixed) {
        ArrayList<T> distinct = new ArrayList<>();

        for (T t : mixed) {
            if (!distinct.contains(t)) {
                distinct.add(t);
            }
        }

        return distinct;
    }  
}
