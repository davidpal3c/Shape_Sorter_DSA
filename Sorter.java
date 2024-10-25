/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appDomain;

import comparators.baseComparator;
import shapes.Shape;

/**
 *
 * @author user
 */
public class Sorter<T extends Comparable<T>>{
    
    private T[] data;
    private int size; 
//    private baseComparator comparator;
    
    public Sorter(T[] data) {
        this.data = data;
        this.size = data.length;        
    }

//    public Sorter(T[] data, baseComparator comparator) {
//        this.data = data;
//        this.size = data.length;        
//    }
//    
    public T[] getData() {
        return data;
    }

    public int getSize() {
        return size;
    }
      
    public void setData(T[] data) {
        this.data = data;
    }
        
    
    public void insertionSort() {
    
        for(int i = 1; i < this.size; i++) {
            
            T currentObj = data[i];            
            int index = i;
            
            for(int j = i - 1; j >= 0; j--) {                
                                                    // descending
                if (currentObj.compareTo(this.data[j]) > 0) {
                    
                    data[index + 1] = data[index];
                    index = j;                
                    
                } else {
                    break;
                }      
                
                data[index + 1] = currentObj;
            }            
        }
    }  
    

    public void quickSort(int low, int high) {

        if (low < high) {
            int pivotIndex = partition(low, high);
            quickSort(low, pivotIndex - 1);
            quickSort(pivotIndex + 1, high);
        }
    }

    private int partition(int low, int high) {
        T pivot = data[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (data[j].compareTo(pivot) > 0) { 
                i++;
                swap(data, i, j);
            }
        }
        swap(data, i + 1, high);
        return i + 1;
    }

    private void swap(T[] data,int i, int j) {
        T temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
    
    /*
     public void quickSort(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            quickSort(low, pivotIndex - 1);
            quickSort(pivotIndex + 1, high);
        }
    }
    */

//        for(int i = 1; i < this.size; i++) {
//            
//            T currentObj = data[i];            
//            int index = i;
//            
//            for(int j = i - 1; j >= 0; j--) {                
//                                                    // ascending
//                if (currentObj.compareTo(this.data[j]) < 0) {
//                    
//                    data[index + 1] = data[index];
//                    index = j;                
//                }         
//                
//                data[index + 1] = currentObj;
//            }            
//        }   
        
        
    
    public void selectionSort() {        
        int n = this.size;
        
        for (int i = 0; i < n-1; i++) {            
            T minObj = this.data[i]; 
            int minIndex = i;
            
            // find smallest element from that point on 
            for (int j = i+1; j < n; j++) { 
                                                // descending / change minObj should actually be 'maxObj'
                if(minObj.compareTo(this.data[j]) < 0) {
                    
                    minObj = this.data[j];  
                    minIndex = j;                             
                }                                                                            
            } 
            if (minIndex != 1)
                swap(this.data, i, minIndex);             
        }                           
    }  
    
    
    public void swap( int a, int b) {
        
        T temp = data[a];
        data[a] = data[b];
        data[b] = temp; 
    }
    

    
//    public void insertionSort() {
//    
//        for(int i = 1; i < this.size; i++) {
//            
//            T currentObj = data[i];            
//            int index = i;
//            
//            for(int j = i - 1; j >= 0; j--) {
//                
//                if(this.data[index] < this.data[j]) {
//                    
//                    swap(this.data, index, j);
//                    index = j;
//                
//                }            
//            }
//            
//        }
//    
//    }

    
//        public void selectionSort(Integer[] nums) {        
//        int n = nums.length;
//        
//        for (int i = 0; i < n-1; i++) {            
//            int min = nums[i]; 
//            int minIndex = i;
//            
//            // find smallest element from that point on 
//            for (int j = i+1; j < n; j++) {                
//                if(nums[j] < min) {                    
//                    min = nums[j];  
//                    minIndex = j;
//                }             
//            }                          
//            
//            swap(nums, nums[i], nums[minIndex]); 
//            
//        }                           
//    }  
    

    
}