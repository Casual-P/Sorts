package com.example.sorts.quickSort;

public class QuickSort {

    private int [] array;

    public void sort(int [] theArray) {
        array = theArray;
        int lowerBound = 0;
        int upperBound = array.length - 1;
        if (upperBound - lowerBound > 0) {
            quickSort(lowerBound, upperBound);
        }
        else {
            System.out.println("Array already sorted");
        }
    }


    private void quickSort(int lowerBound, int upperBound) {
        int size = upperBound - lowerBound + 1;

        if (size <= 16) {
            insertionSort(lowerBound, upperBound);
        } else {
            int pivot = median(lowerBound, upperBound);
            int partition = partitionIt(lowerBound, upperBound, pivot);
            quickSort(lowerBound, partition - 1);
            quickSort(partition + 1, upperBound);
        }
    }


    private int partitionIt (int lowerBound, int upperBound, int pivot) {
        int leftPtr = lowerBound;
        int rightPtr = upperBound - 1;

        while (true) {
            while (array[++leftPtr] < pivot)
                ;
            while (array[--rightPtr] > pivot)
                ;
            if (leftPtr < rightPtr)
                swap(leftPtr, rightPtr);
            else {
                break;
            }
        }
        swap(leftPtr, upperBound - 1);
        return leftPtr;
    }


    private void insertionSort(int lowerBound, int upperBound) {
        for (int i = lowerBound + 1; i <= upperBound; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= lowerBound && key < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array [j + 1] = key;
        }
    }

    private int median(int lowerBound, int upperBound) {
        int mid = (upperBound + lowerBound) / 2;

        if (array[lowerBound] > array[mid])
            swap(lowerBound, mid);

        if (array[lowerBound] > array[upperBound])
            swap(lowerBound, upperBound);

        if (array[mid] > array[upperBound])
            swap(mid, upperBound);

        swap(mid, upperBound - 1);

        return array[upperBound - 1];
    }

    private void swap(int firstElem, int secondElem) {
        int temp = array[firstElem];
        array[firstElem] = array[secondElem];
        array[secondElem] = temp;
    }

}
