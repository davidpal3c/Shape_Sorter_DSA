/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sorters;

import comparators.ShapeComparator;
import shapes.Shape;

/**
 *
 * @author user
 */
public class QuickSort<T extends Shape> extends Sorter<T>  {

    public QuickSort(T[] data) {
        super(data);
    }
    public QuickSort(T[] data,ShapeComparator comparator) {
        super(data,comparator);
    }
    public void swap(T[] data, int a, int b) {
        
        T temp = this.data[a];
        this.data[a] = data[b];
        this.data[b] = temp; 
    }
    public void swap(int a, int b) {
        
        T temp = this.data[a];
        this.data[a] = data[b];
        this.data[b] = temp; 
    }
    public void QuickSortDescByHeight(int low, int high) {
        if(low >= high){
            return;
        }
        T pivot=data[high];
        int left=low;
        int right=high;
        while(left<right){
            while(data[left].compareTo(pivot)>=0 && left < right){
                left++;
            }
            while(data[right].compareTo(pivot)<=0 && left < right){
                right--;
            }
            swap(left, right);//swap in case left > pivot and right < pivot
        }
        swap(left, high);//left right equal swap with pivot
        QuickSortDescByHeight(low, left - 1);//left pointer is pivol so - 1 move before
        QuickSortDescByHeight(left + 1, high);//move from left + 1. Before the pivot
    }
    
    
    public void QuickSortDescByVolumeAndBase(int low, int high) {
        if(low >= high){
            return;
        }

        T pivot=data[high];
        int left=low;
        int right=high;

        while(left<right){
            while(comparator.compare(data[left], pivot)>=0 && left < right){
                left++;
            }
            while(comparator.compare(data[left], pivot)<=0 && left < right){
                right--;
            }
            swap(left, right);//swap in case left < pivot and right > pivot
        }

        swap(left, high);//left right equal swap with pivot
        QuickSortDescByVolumeAndBase(low, left - 1);//left pointer is pivol so - 1 move before
        QuickSortDescByVolumeAndBase(left + 1, high);//move from left + 1. Before the pivot

    }
 

    @Override
    public void heightDesc() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
