package com.yobo.yobo_algorithms.test2_4;

import java.util.Arrays;

public class Heap {

    public static void sort(double[] a){
        /**
         * 构建二叉堆的最大堆
         * 为什么从N/2的位置开始构建？
         * 因为 N/2的子结点就是N，在构建二叉堆的时候，我们会将父结点和子结点比较，
         * 如果子结点比父结点大，那么我们会将子结点换到父结点的位置，如果从比N/2大
         * 的地方进行构建，后面就没有子结点可以和它比较了。
         */
        int N=a.length;
        for (int k=N/2;k>=1;--k){
            sink(a,k,N);
        }
        //不断拿出二叉堆的最大元素，放在数组的末尾，然后将剩下的元素构建成最大堆
        while(N>1){
            exch(a,1,N--);
            sink(a,1,N);
        }
    }
    /**
     * 将下标为k的元素，不断和它子结点（2k）比较
     * 如果比自己子结点小，就把子结点换上来，否则就变成了最大堆（父结点大于等于子结点）
     */
    private static void sink(double[] a, int k, int N ) {
        while (2*k<N){
            int j=2*k;
            if (j<N&&less(a,j,j+1)) j++;
            if (!less(a,k,j)) break;
            exch(a,k,j);
            k=j;
        }
    }
    /**
     * 为什么都要减一？
     * 是因为我们定的二叉树的根节点在a[1]的位置，
     * 实际数组的根节点在a[0]
     */
    private static boolean less(double[] a,int i,int j){
        return a[i-1]<a[j-1];
    }
    private static void exch(double[] a, int i, int j) {
        double temp=a[i-1];
        a[i-1]=a[j-1];
        a[j-1]=temp;
    }
    private static void show(double[] a) {
        System.out.println("\n");
        for (double item : a) {
            System.out.print((int) item + ",");
        }
    }
    public static void main(String[] args) {
        double[] a = { 55, 43, 23, 12, 13, 11, 7, 8, 88, 6, 3, 2, 4, 1, 9, 8, 7, 11, 56, 45, 22, 23,
                45, 66 };
        sort(a);
        show(a);
        Arrays.sort(a);
    }
}
