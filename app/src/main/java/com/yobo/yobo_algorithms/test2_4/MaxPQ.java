package com.yobo.yobo_algorithms.test2_4;

/**
 * Created by ZhangBoshi
 * on 2020-01-20
 */
public class MaxPQ {

    private static double[] a;
    private static int N = 0;

    private MaxPQ(int lenght) {
        a = new double[lenght + 1];
    }
    public void insert(double item) {
        a[++N] = item;
        swim(N);
    }
    /**
     * 删除堆中最大的元素
     */
    public double delMax() {
        double maxItem = a[1];
        a[1] = a[N--];// 先拿到a[N]元素之后，N才会减一
        a[++N] = 0; // 如果这里是对象的话，可以用来置空释放对象的引用，防止对象游离
        sink(1);// 将新的根结点，下沉到合适位置，堆的重新排序

        return maxItem;
    }
    /**
     * 上浮
     */
    private void swim(int k) {

        while (k > 1) {
            if (a[k] > a[k / 2]) {
                exch(k, k / 2);// k/2获取到它的父结点
                k = k / 2;
            } else {
                break;
            }
        }
    }
    /**
     * 下沉
     */
    private void sink(int k) {

        while (2 * k <= N) {
            int j=2*k;
            if (j<N&&a[j]<a[j+1]) j++; //保证每次和a[k]比较的是它的两个子结点中较大的那个

            if (a[k]>a[j])break;

            exch(k,j);
            k=j;
        }
    }
    private void exch(int i, int j) {
        double temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static double[] getA() {
        return a;
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

        MaxPQ maxPQ = new MaxPQ(a.length);
        for (double item : a) {
            maxPQ.insert(item);
        }

        show(getA());
        for (int i=0;i<a.length;i++){
            maxPQ.delMax();
            show(getA());
        }
    }
}
