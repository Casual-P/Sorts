package com.example.sorts.mergeSort;

public class MergeSort {

    public void sort(int [] array, MergeSortType type) {
        switch (type) {
            case RECURSIVE: {
                int lowerBound = 0;
                int upperBound = array.length - 1;
                int[] workSpace = new int[array.length];
                recMergeSort(array, lowerBound, upperBound, workSpace);
                break;
            }
            case NOT_RECURSIVE: {
                int[] workSpace = new int[array.length];
                mergeSort(array, workSpace);
                break;
            }
        }
    }


//    public void StartSort (int [] array, int lowerBound, int upperBound, boolean recOrNot) {
//        if (recOrNot) {
//                int[] workSpace = new int[upperBound - lowerBound + 1];
//                recMergeSort(array, lowerBound, upperBound, workSpace);
//        }
//        else {
//            if (upperBound - lowerBound == array.length - 1) {
//                int[] workSpace = new int[array.length];
//                mergeSort(array, workSpace, lowerBound, upperBound);
//            } else {
//                int[] workSpace = new int[upperBound - lowerBound + 1];
//                mergeSort(array, workSpace, lowerBound, upperBound);
//            }
//        }
//    }


    private void recMergeSort (int [] array, int lowerBound, int upperBound, int [] workSpace) {
        if (upperBound - lowerBound >= 16) {
            int mid = (lowerBound + upperBound) / 2;
            recMergeSort(array, lowerBound, mid, workSpace);
            recMergeSort(array, mid + 1, upperBound, workSpace);
            merge(array,workSpace, lowerBound, mid, mid + 1, upperBound);
        }
        else {
            insertionSort(array, lowerBound, upperBound);
        }
    }


    private void mergeSort(int [] theArray, int [] workSpace) {
        for (int len = 1; len < theArray.length; len *= 2)
            for (int i = 0 ; i + len < theArray.length; i += (2*len))
                merge(theArray, workSpace, i, i + len - 1, i + len, Math.min(i + 2*len - 1, theArray.length - 1));
    }


    private void merge(int [] array, int [] workSpace, int firstArrayBegining, int firstArrayEnding, int secondArrayBegining, int secondArrayEnding) {
        int i = 0;
        int nElems = secondArrayEnding - firstArrayBegining + 1;
        int leftGr = firstArrayBegining;

        while (firstArrayBegining <= firstArrayEnding && secondArrayBegining <= secondArrayEnding) {

            if (array[firstArrayBegining] < array[secondArrayBegining])
                workSpace[i++] = array[firstArrayBegining++];
            else
                workSpace[i++] = array[secondArrayBegining++];

        }

        while (firstArrayBegining <= firstArrayEnding)
            workSpace[i++] = array[firstArrayBegining++];

        while (secondArrayBegining <= secondArrayEnding)
            workSpace[i++] = array[secondArrayBegining++];

        if (nElems >= 0) System.arraycopy(workSpace, 0, array, leftGr, nElems);
    }


    private void insertionSort (int [] array, int lowerBound, int upperBound) {
        for (int i = lowerBound + 1; i <= upperBound; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= lowerBound && array[j] >= key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}
