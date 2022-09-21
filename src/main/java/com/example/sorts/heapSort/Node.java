package com.example.sorts.heapSort;

class Node {
    private int Data;
    private Node leftChild;
    private Node rightChild;
    private Node parent;

    Node(int Data) {
        this.Data = Data;
    }

    public int getData() {
        return Data;
    }

    public void setData(int data) {
        Data = data;
    }

    public void dispNode() {
        System.out.print("/" + Data);
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
