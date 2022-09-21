package com.example.sorts.radixSort;

public class RadixSortLSD {

    public void sort (int [] array) {
        int max = getMax(array);
        int razr = 1;
        while (max / razr > 0) {
            subSort(array, razr);
            razr *= 10;
        }
    }

    private int getMax (int [] array) {
        int max = array[0];
        for (int j : array) {
            if (max < j) {
                max = j;
            }
        }
        return max;
    }


    private void subSort(int [] array, int razr) {

        int [] count = new int[10];
        int [] output = new int[array.length];

        for (int j : array)
            count[(j / razr) % 10]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = array.length - 1; i >= 0; i--) {
            output[count[(array[i] / razr) % 10] - 1] = array[i];
            count[(array[i] / razr) % 10]--;
        }
        System.arraycopy(output, 0, array, 0, array.length);
    }
}
