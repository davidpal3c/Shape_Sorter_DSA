/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sorters;

import comparators.ShapeComparator;
import comparators.VolumeComparator;
import comparators.BaseComparator;
import shapes.Shape;

/**
 *
 * @author user
 */
public class SelectionSort<T extends Shape> extends Sorter<T> {

    public SelectionSort(T[] data) {
        super(data);
    }   
    
    public SelectionSort(T[] data, ShapeComparator comparator) {
        super(data, comparator);
    }    
    
    
    public void swap(int a, int b) {
        T temp = this.data[a];
        this.data[a] = this.data[b];
        this.data[b] = temp; 
    }
 
    public void heightDesc() {                        
        int n = this.size;

        for (int i = 0; i < n-1; i++) {            
            T maxObj = this.data[i]; 
            int maxIndex = i;

            // find smallest element from that point on 
            for (int j = i+1; j < n; j++) { 
                                                // descending / change minObj should actually be 'maxObj'
                if(maxObj.compareTo(this.data[j]) < 0) {                    
                    maxObj = this.data[j];  
                    maxIndex = j;                             
                }                                                                            
            } 
            if (maxIndex != i)                          // swap only if new max obj
                swap(i, maxIndex);             
        }                           
    }   
    
    public void volumeDesc() {                 
        int n = this.size;

        for (int i = 0; i < n - 1; i++) {            
            int maxIndex = i;

            for (int j = i + 1; j < n; j++) { 
                if (comparator != null && comparator.compare(this.data[maxIndex], this.data[j]) < 0) {     
                    maxIndex = j;   
                    System.out.println("Current Max Index: " + maxIndex);
                }                                                                            
            } 

            if (maxIndex != i) {
                swap(i, maxIndex);             
            }                           
        }       
        
        
        
//        for (int i = 0; i < n - 1; i++) {            
//            T maxObj = this.data[i]; 
//            int maxIndex = i;
//
//            for (int j = i + 1; j < n; j++) { 
//                if (comparator != null && comparator.compare(maxObj, this.data[j]) < 0) {    
//                    maxObj = this.data[j];  
//                    maxIndex = j;                             
//                }                                                                            
//            } 
//
//            if (maxIndex != i) {
//                swap(this.data, i, maxIndex);             
//            }                           
//        }                           
    }
    
    public void baseAreaDesc() {         
        int n = this.size;

        for (int i = 0; i < n - 1; i++) {            
            int maxIndex = i;

            for (int j = i + 1; j < n; j++) { 
                if (comparator != null && comparator.compare(this.data[j], this.data[maxIndex]) > 0) {                    
                    maxIndex = j;        
                    System.out.println("Current Max Index: " + maxIndex);
                }                                                                            
            } 

            if (maxIndex != i) {
                swap(i, maxIndex);             
            }                           
        }   

//        for (int i = 0; i < n-1; i++) {            
//            T maxObj = this.data[i]; 
//            int maxIndex = i;
//
//            // find smallest element from that point on 
//            for (int j = i+1; j < n; j++) { 
//                                                // descending / change minObj should actually be 'maxObj'
//                if(comparator.compare(maxObj, this.data[j]) < 0) {                    
//                    maxObj = this.data[j];  
//                    maxIndex = j;                             
//                }                                                                            
//            } 
//            
//            if (maxIndex != i)                          // swap only if new max obj
//                swap(i, maxIndex);             
//        }                           
    }   
    
}
