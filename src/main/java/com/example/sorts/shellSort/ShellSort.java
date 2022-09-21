package com.example.sorts.shellSort;

public class ShellSort {
    public void sort(int[] array) {
        divideAndSort(array.length, array);
    }

    public void divideAndSort(int h, int[] array) {
        if (h > 1) {
            h = h / 3 + 1;
            subSort(h, array);
            divideAndSort(h, array);
        }
    }
    private void subSort(int h, int[] array) {
        for (int i = h; i < array.length; i++) {
            int j = i;
            int temp = array[i];
            while (j > h - 1 && temp <= array[j - h]) {
                array[j] = array[j - h];
                j-= h;
            }
            array[j] = temp;
        }
    }
}
