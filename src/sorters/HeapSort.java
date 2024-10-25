/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sorters;

import shapes.Shape;
import comparators.ShapeComparator;
import comparators.VolumeComparator;
import comparators.BaseComparator;


/**
 *
 * @author David Palacios
 */
public class HeapSort<T extends Shape> extends Sorter<T> {

    public HeapSort(T[] data) {
        super(data);
    }

    public HeapSort(T[] data, ShapeComparator comparator) {
        super(data, comparator);   
    }
    
    
    public void sortByHeight() {
        int n = data.length;
        
                            // Build heap (rearranging array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyWithByHeight(data, n, i);
        }

        // extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
                                            // Moves current root to end
            swap(data, 0, i);

            // Call max heapify on the reduced heap
            heapifyWithByHeight(data, i, 0);
        }
    }
    
    
    private void heapifyWithByHeight(T[] data, int n, int i) {
        int largest = i;                        // sets largest as root
        int left = 2 * i + 1;                   // left child
        int right = 2 * i + 2;                  // right child

        // heaps whether left or right child is larger than root
        if (left < n && data[left].compareTo(data[largest]) > 0) {
            largest = left;
        }

        if (right < n && data[right].compareTo(data[largest]) > 0) {
            largest = right;
        }

        // swaps if largest is not root
        if (largest != i) {
            swap(data, i, largest);

            // heapifies recursively the affected sub-tree
            heapifyWithComparator(data, n, largest);
        }
    }
   
    
    public void sortByVolumeOrBaseArea() {
        int n = data.length;
        
                            // Build heap (rearranging array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyWithComparator(data, n, i);
        }

        // extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
                                            // Moves current root to end
            swap(data, 0, i);

            // Call max heapify on the reduced heap
            heapifyWithComparator(data, i, 0);
        }
    }

    private void heapifyWithComparator(T[] data, int n, int i) {
        int largest = i;                        // sets largest as root
        int left = 2 * i + 1;                   // left child
        int right = 2 * i + 2;                  // right child

        // heaps whether left or right child is larger than root
        if (left < n && comparator.compare(data[left], data[largest]) > 0) {
            largest = left;
        }

        if (right < n && comparator.compare(data[right], data[largest]) > 0) {
            largest = right;
        }

        // swaps if largest is not root
        if (largest != i) {
            swap(data, i, largest);

            // heapifies recursively the affected sub-tree
            heapifyWithComparator(data, n, largest);
        }
    }

    private void swap(T[] data, int i, int j) {
        T temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
    
    
    @Override
    public void heightDesc() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
