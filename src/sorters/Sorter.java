/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sorters;

import shapes.Shape;
import comparators.ShapeComparator;

/**
 *
 * @author user
 */
public abstract class Sorter<T extends Shape>{
    
    protected T[] data;
    protected int size; 
    protected ShapeComparator comparator;
    
    
    public Sorter(T[] data) {
        this.data = data;
        this.size = data.length;        
    }

    public Sorter(T[] data, ShapeComparator comparator) {
        this.data = data;
        this.size = data.length;        
        this.comparator = comparator;
    }
    
    public T[] getData() {
        return data;
    }

    public int getSize() {
        return size;
    }
      
    public void setData(T[] data) {
        this.data = data;
    }
        
    public abstract void heightDesc();
    
    
//    public void insertionSort() {    
//        for(int i = 1; i < this.size; i++) {
//            
//            T currentObj = data[i];            
//            int index = i;
//            
//            for(int j = i - 1; j >= 0; j--) {                
//                                                    // descending
//                if (currentObj.compareTo(this.data[j]) > 0) {                    
//                    data[index + 1] = data[index];
//                    index = j;                
//                    
//                } else {
//                    break;
//                }      
//                
//                data[index + 1] = currentObj;
//            }            
//        }        
//    }
//    
//    public void insertionSort2() {    
//        for(int i = 1; i < this.size; i++) {
//            
//            T currentObj = data[i];            
//            int index = i;
//            
//            for(int j = i - 1; j >= 0; j--) {                
//                                                    // descending
//                if (comparator.compare(currentObj, data[j]) > 0) {
//                    
//                    data[index] = data[j];
//                    index = j;                
//                    
//                } else {
//                    break;
//                }      
//                
//                data[index] = currentObj;
//            }            
//        }        
//    }
    
        

    
//    public void quickSort(int low, int high) {
//
//        if (low < high) {
//            int pivotIndex = partition(low, high);
//            quickSort(low, pivotIndex - 1);
//            quickSort(pivotIndex + 1, high);
//        }
//    }
//
//    private int partition(int low, int high) {
//        T pivot = data[high];
//        int i = low - 1;
//
//        for (int j = low; j < high; j++) {
//            if (data[j].compareTo(pivot) > 0) { 
//                i++;
//                swap(data, i, j);
//            }
//        }
//        swap(data, i + 1, high);
//        return i + 1;
//    }

//    public void QuickSort(int low, int high){
//        if(low >= high){
//            return;
//        }
//        T pivot=data[high];
//        int left=low;
//        int right=high;
//        while(left<right){
//            while(data[left].compareTo(pivot)<=0 && left < right){
//                left++;
//            }
//            while(data[right].compareTo(pivot)>=0 && left < right){
//                right--;
//            }
//            swap(data,left, right);//swap in case left > pivot and right < pivot
//        }
//        swap(data,left, high);//left right equal swap with pivot
//        QuickSort(low, left - 1);//left pointer is pivol so - 1 move before
//        QuickSort(left + 1, high);//move from left + 1. Before the pivot
//    }
//   
        
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
        

    

//    public void bubbleSort(){
//        for(int i = 0; i<size; i++){
//            for(int j=0; j<size; j++)
//            {
//                if(data[j-1]>data[j])
//                    swap(j-1, j);
//            }
//        }
//        
//    }

//    public void QuickSort2(int low, int high){
//        if(low >= high){
//            return;
//        }
//        T pivot=data[high];
//        int left=low;
//        int right=high;
//        while(left<right){
//            while(data[left].compareTo(pivot)<=0 && left < right){
//                left++;
//            }
//            while(data[right].compareTo(pivot)>=0 && left < right){
//                right--;
//            }
//            swap(data,left, right);//swap in case left > pivot and right < pivot
//        }
//        swap(data,left, high);//left right equal swap with pivot
//        QuickSort(low, left - 1);//left pointer is pivol so - 1 move before
//        QuickSort(left + 1, high);//move from left + 1. Before the pivot
//    }
    
    /*
    public void bubbleSort(){
        for(int i = 0; i<size; i++){
            for(int j=0; j<size; j++)
            {
                if(data[j-1]>data[j])
                    swap(j-1, j);
            }
        }
        
    }
    */
    
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
