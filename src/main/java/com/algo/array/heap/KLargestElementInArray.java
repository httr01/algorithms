package com.algo.array.heap;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
 * Question: Write an efficient program for printing k largest elements in an array. Elements in array can be in any order.
 * For example, if given array is [1, 23, 12, 9, 30, 2, 50] and you are asked for the largest 3 elements i.e., k = 3 then your program should print 50, 30 and 23.
 * Steps
 * We will use Min Heap which will keep minimum element on the top.
 * We will keep replacing this minimum element on top of min heap if we have element larger than this.
 *
 * N : Total elements in array
 * K : Max K elements
 *
 * Time complexity : N log (K)
 * Space Complexity : O(K)
 */
public class KLargestElementInArray {

    public int[] largestKElement(int[] elements, int k) {
        MinHeap minHeap =  new MinHeap(k);

        for (int i = 0 ;i< elements.length ; ++i) {
            // keep inserting in in heap till we have inserted k elements.
            if (minHeap.size() < k ) {
                minHeap.push(elements[i]);
                continue;
            }
            // if The current element is bigger than smallest element in min heap, we will put current element in min heap.
            if (minHeap.peek() < elements[i]) {
                minHeap.pop();
                minHeap.push(elements[i]);
            }
        }
        return minHeap.getValues();
    }


    public  static void main(String[] args) {
        KLargestElementInArray example = new KLargestElementInArray();
        int[] data = {5, 1 , 10 };
        int[] maxK = example.largestKElement(data, 2);
        System.out.println(" Input " + Arrays.toString(data) + " Max :" + Arrays.toString(maxK));


        int[] data2 = {5, 1 , 10, 0, 8 };
        maxK = example.largestKElement(data2, 2);
        System.out.println(" Input " + Arrays.toString(data2) + " Max :" + Arrays.toString(maxK));

        int[] data3 = {5, 1 , 10, 0, 8 };
        maxK = example.largestKElement(data3, 3);
        System.out.println(" Input " + Arrays.toString(data3) + " Max :" + Arrays.toString(maxK));

        int[] data4 = {2, 13, 4, 5, 1 , 10, 0, 8 };
        maxK = example.largestKElement(data4, 3);
        System.out.println(" Input " + Arrays.toString(data4) + " Max :" + Arrays.toString(maxK));

        int[] data5 = {2};
        maxK = example.largestKElement(data5, 1);
        System.out.println(" Input " + Arrays.toString(data5) + " Max :" + Arrays.toString(maxK));
    }
}
