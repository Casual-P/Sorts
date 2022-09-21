package com.example.sorts.countingSort;

public class CountingSort {

   public void sort(int [] array) {
       int [] count = new int[getMax(array) + 1];
       int [] output = new int[array.length];

       for (int j : array) {
           count[j]++;
       }

       for (int i = 1; i < count.length; i++) {
           count[i] = count[i] + count[i - 1];
       }

       for (int i = array.length - 1; i >= 0; i--) {
           output[count[array[i]] - 1] = array[i];
           count[array[i]]--;
       }

       System.arraycopy(output, 0, array, 0, array.length);
   }

   private int getMax (int [] array) {
       int max = array[0];
       for (int j : array) {
           if (max < j)
               max = j;
       }
       return max;
   }
}
