package com.example.sorts.heapSort;

import java.util.ArrayList;

public class Heap {
    private Node root;
    private int numElems;
    private final ArrayList<Integer> path = new ArrayList<>();
    int n;
    int j;

    public Heap() {
        this.numElems = 0;
    }

    public void insert(int data) {
        Node newnode = new Node(data);
        numElems++;

        if (root == null)
            root = newnode;
        else {
            n = numElems;
            j = 0;
            Node current = root;
            Node parent = current;

            while (n > 0) {
                path.add(n % 2);
                n /= 2;
            }

            for (int i = path.size() - 2; i >= 0; i--) {
                parent = current;
                if (path.get(i) == 0)
                    current = current.getLeftChild();
                else
                    current = current.getRightChild();
            }

            if (parent.getLeftChild() == null)
                parent.setLeftChild(newnode);
            else
                parent.setRightChild(newnode);

            newnode.setParent(parent);
            trickleUp(newnode);

            path.clear();

        }
    }

    private void trickleUp(Node curNode) {

        Node parent = curNode.getParent();

        while (parent != null) {
            if (parent.getData() > curNode.getData()) {
                swap(curNode, parent);
            } else
                break;

            parent = curNode.getParent();
        }
    }


    public Node remove() {

        if (root == null) {
            System.out.println("Heap is Empty!");
            return null;
        }

        Node retVal = root;

        Node last;
        n = numElems;
        Node current = root;
        Node parent = current;

        while (n > 0) {
            path.add(n % 2);
            n /= 2;
        }

        for (int i = path.size() - 2; i >= 0; i--) {
            parent = current;
            if (path.get(i) == 0)
                current = current.getLeftChild();
            else
                current = current.getRightChild();
        }

        if (current == parent.getLeftChild())
            parent.setLeftChild(null);
        else
            parent.setRightChild(null);

        Node leftChild = root.getLeftChild();
        Node rightChild = root.getRightChild();
        current.setParent(root.getParent());

        root = current;

        if (leftChild != null)
            leftChild.setParent(current);
        if (rightChild != null)
            rightChild.setParent(current);

        current.setLeftChild(leftChild);
        current.setRightChild(rightChild);

        trickleDown(current);

        numElems--;
        path.clear();
        return retVal;
    }

    public void changeValue(int index, int newValue) {

        if (index > numElems || index < 1) {
            System.out.println("Wrong index! Note index more then 1 or less then " + numElems);
            return;
        }

        Node current = root;

        while (index > 0) {
            path.add(index % 2);
            index /= 2;
        }

        for (int i = path.size() - 2; i >= 0; i--) {
            if (path.get(i) == 0)
                current = current.getLeftChild();
            else
                current = current.getRightChild();
        }

        if (newValue > current.getData()) {
            current.setData(newValue);
            trickleUp(current);
        } else {
            current.setData(newValue);
            trickleDown(current);
        }

        path.clear();
    }

    private void trickleDown(Node current) {
        Node largerChild;
        while (current.getLeftChild() != null) {
            if (current.getRightChild() != null)
                if (current.getLeftChild().getData() > current.getRightChild().getData())
                    largerChild = current.getRightChild();
                else
                    largerChild = current.getLeftChild();
            else
                largerChild = current.getLeftChild();

            if (largerChild.getData() < current.getData())
                swap(largerChild, current);
            else
                break;

            if (root == current)
                root = largerChild;
        }
    }

    private void swap(Node current, Node parent) {

        Node grandParent = parent.getParent();
        Node leftChild = current.getLeftChild();
        Node rightChild = current.getRightChild();

        if (current == parent.getLeftChild()) {
            current.setLeftChild(parent);
            current.setRightChild(parent.getRightChild());
        } else {
            current.setLeftChild(parent.getLeftChild());
            current.setRightChild(parent);
        }

        current.getLeftChild().setParent(current);

        if (current.getRightChild() != null)
            current.getRightChild().setParent(current);

        parent.setLeftChild(leftChild);
        parent.setRightChild(rightChild);

        if (leftChild != null)
            leftChild.setParent(parent);
        if (rightChild != null)
            rightChild.setParent(parent);

        current.setParent(grandParent);

        if (grandParent != null) {
            if (grandParent.getLeftChild() == parent)
                grandParent.setLeftChild(current);
            else
                grandParent.setRightChild(current);
        }

        if (parent == root)
            root = current;
    }

    public void dispHeapTree() {

        int a;
        Node current;
        for (int i = 1; i <= numElems; i++) {
            current = root;
            a = i;
            while (a > 0) {
                path.add(a % 2);
                a /= 2;
            }

            for (int j = path.size() - 2; j >= 0; j--) {
                if (path.get(j) == 0)
                    current = current.getLeftChild();
                else
                    current = current.getRightChild();
            }

            current.dispNode();
            path.clear();

        }
    }
}
