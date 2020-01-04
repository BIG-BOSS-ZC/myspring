package com.myspring.day5;

public class QuickSort {
    public static int[] quickSort(int[] arr,int low,int high){
        int p=arr[low];
        int i=low;
        int j=high;
        while (i<j){
            while (i < j && arr[i] < p) {
                i++;
            }
            while (i<j && arr[j]>p){
                j--;
            }
            if(arr[i]==arr[j] && i<j){
                i++;
            }else {
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
            if(low<i-1)quickSort(arr,low,i-1);
            if(high>j+1)quickSort(arr,j+1,high);

        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr={8,3,9,0,4,3,2,4};
        quickSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
