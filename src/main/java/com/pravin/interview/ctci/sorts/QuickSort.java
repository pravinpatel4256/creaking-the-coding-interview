package com.pravin.interview.ctci.sorts;

import java.util.Arrays;

public class QuickSort {

    public void quickSort(int [] arr){
        quickSort(arr, 0, arr.length-1);
    }

    private void quickSort(int[] arr, int left, int right) {

        if (left >= right) {
            return;
        }
        int pivot = arr[(left + right)/2];
        int index = partition(arr, left, right, pivot);
        quickSort(arr, left, index - 1 );
        quickSort(arr, index , right);
    }

    private int partition(int[] arr, int left, int right, int pivot) {

        while (left <= right) {
            while(arr[left] <  pivot){
                left++;
            }

            while (arr[right] > pivot) {
                right--;
            }

            if (left <= right) {
                swap(arr, left, right);
                left++;
                right --;
            }
        }

        return left;
    }

    private void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;

    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] a = new int[]{1, 10, 9, 2, 4};
        Arrays.stream(a).forEach(aa -> System.out.print(" "+aa));
        System.out.println();
        quickSort.quickSort(a);


        Arrays.stream(a).forEach(aa -> System.out.print(" "+aa));
    }

}
