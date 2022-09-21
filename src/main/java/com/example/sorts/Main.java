package com.example.sorts;

import com.example.sorts.countingSort.CountingSort;
import com.example.sorts.heapSort.HeapSort;
import com.example.sorts.insertionSort.InsertionSort;
import com.example.sorts.mergeSort.MergeSort;
import com.example.sorts.quickSort.QuickSort;
import com.example.sorts.radixSort.RadixSortLSD;
import com.example.sorts.randomizer.Randomizer;
import com.example.sorts.shellSort.ShellSort;


public class Main {
    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        ShellSort shellSort = new ShellSort();
        MergeSort mergeSort = new MergeSort();
        QuickSort quickSort = new QuickSort();
        CountingSort countingSort = new CountingSort();
        RadixSortLSD radixSortLSD = new RadixSortLSD();
        HeapSort heapSort = new HeapSort();

        int[] array = new int[25];
        Randomizer.fillRandom(array);


    }
}
