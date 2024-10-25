# assignment1StartingCode
 
/**
* Complexity and Sorting Program - CPRG304
* Authors: Emily Thieu, Ngoc Tam Nguyen, Yaling Wei, David Palacios
* Instructor: Hani Mohammed
* Date: October 24, 2024
/




====================================
ASSIGNMENT 1: COMPLEXITY AND SORTING
====================================


DESCRIPTION: 

This program provides different sorting algorithms to sort an array of objects of type Shape, while also providing different options for comparison in order to sort (by height, volume, or base area). The program will provide a sorted array with an approximation of the time it takes for the algorithm to sort the array in nano seconds.

The program is run through the executable Java Archive file (.jar) from the command line interface, found in the /dist folder of the program.


PROGRAM FLAGS AND COMMAND OPTIONS:

-f   	Denotes the file name. After this flag, the program expects the file name in the 		following formats:
		'res/shapes1.txt' or 'shapes1.txt' or 'C:\temp\shapes1.txt' or 'shapes1'
		'res/shapes2.txt' or 'shapes2.txt' or 'C:\temp\shapes2.txt' or 'shapes2'
		'res/shapes3.txt' or 'shapes3.txt' or 'C:\temp\shapes3.txt' or 'shapes3'
		
-t     	Denotes the type of comparison used by the algorithm to sort the array. After this flag, 	the program expects one of the following 'compare by' commands:
		'h' 	Comparing by Height
		'v' 	Comparing by Volume
		'a' 	Comparing by Base Area

-s	Denotes the type of sorting algorithm to be used by the program: After this flag, the 		program expects one of the following sorting algorithm commands.
		'b'	Bubble Sort
		'i'	Insertion Sort
		's'	Selection Sort
		'q'	Quick Sort
		'm'	Merge Sort
		'h'	Heap Sort	



HOW TO RUN:

Open /dist directory in your terminal and run the following command replacing each <...> with the selected type of sorting algorithm and comparison type as explained previously.


java -jar Sort.jar -f<file_name> -t<compare_type> -s<sorting_algorithm>


Example1: using Bubble sort and comparing by Height 
java -jar Sort.jar -fshapes1.txt -th -sb

Example2: using Select sort and comparing by Volume
java -jar Sort.jar -fshapes1.txt -th -sb


*** Note: The order of the flag does not matter as long as their respective values are entered respectively. 	
