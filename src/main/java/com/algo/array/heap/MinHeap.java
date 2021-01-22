package com.algo.array.heap;

import java.util.Arrays;

public class MinHeap {
    int[] minHeap;
    int size;
    int current ;

    public MinHeap(int size) {
        minHeap=  new int[size];
        this.size =  size;
    }

    public int[] getValues() {
        return minHeap;
    }

    public int peek() {
        if (current == 0) return 0; // exception case;
        return minHeap[0];
    }


    public void push(int value) {
         if (current < size) {
            minHeap[current] = value;
            heapifyUp(current);
            ++current;
        } else {
             System.out.println("Heap already full, first remove from heap. Not inserting value " + value);
         }
    }

    public int pop() {
        if (current == 0) return 0; // exception case;
        current--;
        int value = minHeap[0];
        minHeap[0] = minHeap[current];
        heapifyDown(0);
        return value;
    }

    private void heapifyDown(int parent) {
        if (current <= 1 || parent >= current) return;
        int lChild = 2 * parent + 1;
        int rChild = lChild + 1;

        if (lChild >= current) return;

        if (minHeap[lChild] < minHeap[parent]
                && (rChild >= current ||  minHeap[lChild] < minHeap[rChild])) {
            swap(minHeap, parent, lChild);
            heapifyDown(lChild);
        } else if (rChild < current && minHeap[rChild]< minHeap[parent]
                && minHeap[rChild] < minHeap[lChild]) {
            swap(minHeap, parent, rChild);
            heapifyDown(rChild);
        }
    }

    private void heapifyUp(int current) {
        if (current == 0) return;
        int parent = (current -1) / 2;
        if (minHeap[parent] > minHeap[current]) {
            swap(minHeap, current, parent);
            heapifyUp(parent);
        }
    }
    public int size(){
        return current;
    }

    private void swap(int[] minHeap, int index1, int index2) {
        int t = minHeap[index1];
        minHeap[index1] = minHeap[index2];
        minHeap[index2] = t;
    }

    public static void main(String[] args) {
        /*MinHeap minHeap = new MinHeap(2);
        int[] data = {5, 1 , 10 };
        minHeap.insert(5);
        System.out.println(" Insert 5 " + Arrays.toString(minHeap.getValues()) + "  size " + minHeap.size() );
        minHeap.insert(1);
        System.out.println(" Insert 1 " + Arrays.toString(minHeap.getValues()) + "  size " + minHeap.size() );
        minHeap.remove();
        System.out.println(" Remove " + Arrays.toString(minHeap.getValues()) + "  size " + minHeap.size() );
        minHeap.insert(10);
        System.out.println(" Remove " + Arrays.toString(minHeap.getValues()) + "  size " + minHeap.size() );
        */
        test1();


    }

    public static void test1(){
        int[] data2 = {5, 1 , 10, 0, 8 };

        MinHeap minHeap = new MinHeap(2);
        minHeap.push(5);
        System.out.println(" Insert 5 " + Arrays.toString(minHeap.getValues()) + "  size " + minHeap.size() );
        minHeap.push(1);
        System.out.println(" Insert 1 " + Arrays.toString(minHeap.getValues()) + "  size " + minHeap.size() );
        minHeap.pop();
        System.out.println(" Remove " + Arrays.toString(minHeap.getValues()) + "  size " + minHeap.size() );
        minHeap.push(10);
        System.out.println(" Remove " + Arrays.toString(minHeap.getValues()) + "  size " + minHeap.size() );
        minHeap.pop();
        System.out.println(" Remove " + Arrays.toString(minHeap.getValues()) + "  size " + minHeap.size() );
        minHeap.push(8);
        System.out.println(" Insert 8 " + Arrays.toString(minHeap.getValues()) + "  size " + minHeap.size() );
    }

}
