
# Shape Sorter Program 
(Complexity Analysis)

**Authors:** David Palacios, Ngoc Tam Nguyen  
**Date:** October 1, 2024  

---

## Overview

The Shape Sorter Program is a powerful tool designed to sort an array of `Shape` objects and generics using various sorting algorithms. This program allows users to specify different criteria for comparison, including height, volume, or base area. This program exemplifies OOP concepts such as polymorphism, abstraction, encapsulation, inheritance and generic types and it is a revamped version from a class assignment. 

After executing a sorting operation, the program will output a sorted array along with an approximation of the time taken for the selected sorting algorithm to complete, measured in nanoseconds.

This program is executed through a Java Archive file (.jar) via the command line interface, located in the `/dist` directory of the program.


# Features

- **Multiple Comparison Options:** Sort shapes based on height, volume, or base area.
- **Diverse Sorting Algorithms:** Choose from various algorithms, including Bubble Sort, Insertion Sort, Selection Sort, Quick Sort, Merge Sort, and Heap Sort.
- **Performance Measurement:** Get an approximation of sorting time to evaluate algorithm efficiency.

---
## Command Line Interface

### Program Flags and Command Options

- `-f`: Specifies the input file name. The program supports several file path formats:
  - `'res/shapes1.txt'`
  - `'shapes1.txt'`
  - `'C:\temp\shapes1.txt'`
  - `'shapes1'`
  
- `-t`: Specifies the comparison type used for sorting. Accepted command options are:
  - `'h'`: Compare by Height
  - `'v'`: Compare by Volume
  - `'a'`: Compare by Base Area

- `-s`: Specifies the sorting algorithm to use. Available command options include:
  - `'b'`: Bubble Sort
  - `'i'`: Insertion Sort
  - `'s'`: Selection Sort
  - `'q'`: Quick Sort
  - `'m'`: Merge Sort
  - `'h'`: Heap Sort

---

## How to Run

To execute the program, navigate to the `/dist` directory in your terminal. Use the following command format, replacing the placeholders with your chosen sorting algorithm and comparison type:

```bash
java -jar Sort.jar -f<file_name> -t<compare_type> -s<sorting_algorithm>



Example1: using Bubble sort and comparing by Height 
java -jar Sort.jar -fshapes1.txt -th -sb

Example2: using Select sort and comparing by Volume
java -jar Sort.jar -fshapes1.txt -th -sb


*** Note: The order of the flag does not matter as long as their corresponding values are entered respectively. 	
