/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sorters;
import comparators.ShapeComparator;
import comparators.VolumeComparator;
import comparators.BaseComparator;
import shapes.Shape;
import java.util.Arrays;

/**
 *
 * @author David Palacios 
 */
public class MergeSort<T extends Shape> extends Sorter<T> {
    
    
        public MergeSort(T[] data) {
            super(data);
        }

        public MergeSort(T[] data, ShapeComparator comparator) {
            super(data, comparator);
        }

        public void heightDesc(T[] data) {

            if (data == null || data.length <= 1) {
                return; 
            }

            //divide into two halves
            int mid = data.length / 2;
            
            T[] l_half = Arrays.copyOfRange(data, 0, mid);
            T[] r_half = Arrays.copyOfRange(data, mid, data.length);

//            T[] l_half = copyArrayByRange(data, 0, mid);
//            T[] r_half = copyArrayByRange(data, mid, data.length);
            
            // keep dividing array recursively 
            heightDesc(l_half);
            heightDesc(r_half);
            
            mergeHeightDesc(this.data, l_half,r_half);
           
        }
        
        public void mergeHeightDesc(T[] data, T[] left, T[] right) {
                
            int i = 0;                  //original subarray index
            int j = 0;                  // left subarray index
            int k = 0;                  // right subarray index
            
            // compare l and r and merge in order
            while(j < left.length && k < right.length) {     
                
                if (left[j] != null && right[k] != null) {
                    if (left[j].compareTo(right[k]) >= 0) {
                        data[i++] = left[j++];
                    } 
                    else {
                        data[i++] = right[k++];
                    }
                }
                else if (left[j] == null) {
                    data[i++] = right[k++];
                } else {
                    j++;
                }
                
            } 
           
                                                    // copy any remaining elements 
            while (j < left.length) {
                if (left[j] != null) {
                    data[i++] = left[j++];
                } else {
                    j++;
                }
            }

            while (k < right.length) {
                if (right[k] != null) {
                    data[i++] = right[k++];
                } else {
                    k++;
                }
            }
        
        }
        
        public void sortByVolOrBaseDesc(T[] data) {

            if (data.length <= 1) {
                return; // data is already sorted 
            }

            //divide into two halves
            int mid = data.length / 2;

            T[] l_half = Arrays.copyOfRange(data, 0, mid);
            T[] r_half = Arrays.copyOfRange(data, mid, data.length);
            
            // recursive call to 
            sortByVolOrBaseDesc(l_half);
            sortByVolOrBaseDesc(r_half);
            
            mergeDescUsingComparator(data, l_half,r_half);
           
        }
        

        public void mergeDescUsingComparator(T[] data, T[] left, T[] right) {
                
            int i = 0;                  //original subarray index
            int j = 0;                  // left subarray index
            int k = 0;                  // right subarray index
            
            // compare l and r and merge in order
            while(j < left.length && k < right.length) {     
                
                if (left[j] != null && right[k] != null) {
                    if (comparator != null && comparator.compare(left[j], right[k]) <= 0) {
                        data[i++] = left[j++];
                    } 
                    else {
                        data[i++] = right[k++];
                    }
                }
                else if (left[j] == null) {
                    data[i++] = right[k++];
                } else {
                    j++;
                }
                
            } 
           
                                                    // copy any remaining elements 
            while (j < left.length) {
                if (left[j] != null) {
                    data[i++] = left[j++];
                } else {
                    j++;
                }
            }

            while (k < right.length) {
                if (right[k] != null) {
                    data[i++] = right[k++];
                } else {
                    k++;
                }
            }
        }

        
        public T[] copyArrayByRange(T[] data, int start, int end) {
            
            if (start == 0 && end == data.length) {
                return data;
            }
            
            int newLength = end-start;
            
            if (newLength < 0) {
                throw new IllegalArgumentException("Start index " + start + " is greater than end index " + end);
            }
            
            T[] copy = (T[]) new Shape[newLength];
            
            return copy;
    
        }
        
        
    @Override
    public void heightDesc() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        
        
}
