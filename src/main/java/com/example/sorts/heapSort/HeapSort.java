package com.example.sorts.heapSort;

public class HeapSort {

    private final Heap heap;

    public HeapSort() {
        this.heap = new Heap();
    }

    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            heap.insert((int) (Math.random() * 1000));
        }

        for (int j = 0; j < array.length; j++) {
            Node node = heap.remove();
            array[j] = node.getData();
        }
    }
}


