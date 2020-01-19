package com.yobo.yobo_algorithms.test2_1;

/**
 * Created by ZhangBoshi
 * on 2020-01-17
 */
public class Shell {

    private static int count = 0;
    private static int count1 = 0;
    private static int countX = 0;
    private static int countX1 = 0;
    private static int countInserrion = 0;
    private static int countInserrion1 = 0;

    /**
     * 希尔排序   h=3x+1
     */
    public static void sort(double[] a) {
        int N = a.length;
        int h = 1;
        // 3x+1 hment sequence: 1, 4, 13, 40, 121, 364, 1093, ...
        while (h < N / 3)
            h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h; j -= h) {
                    count++;
                    if (a[j] < a[j - h]) {
                        count1++;
                        exch(a, j, j - h);
                    } else {
                        break;
                    }
                }
            }
            h /= 3;
        }
    }

    /**
     * 希尔排序  h= N／2
     */
    public static void shell_sort(int array[]) {
        int temp = 0;
        int N = array.length;
        int h = N;

        do {
            h = h / 2;
            System.out.println("hX=" + h);
            for (int k = 0; k < h; k++) { // 根据增量分为若干子序列
                for (int i = k + h; i < N; i += h) {
                    for (int j = i; j > k; j -= h) {
                        countX++;
                        if (array[j] < array[j - h]) {
                            countX1++;
                            temp = array[j - h];
                            array[j - h] = array[j];
                            array[j] = temp;
                        } else {
                            break;
                        }
                    }
                }
            }
        } while (h != 1);
    }

    /**
     * 插入排序
     */
    public static void sortInserrion(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                countInserrion++;
                if (a[j] < a[j - 1]) {
                    countInserrion1++;
                    exch(a, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
    private static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void exch(double[] a, int i, int j) {
        double temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private static void show(int[] a) {
        System.out.println("\n");
        for (int item : a) {
            System.out.print(item + ",");
        }
    }

    public static void main(String[] args) {
        int[] a = { 55, 43, 23, 12, 13, 11, 7, 8, 88, 6, 4, 2, 3, 1, 9, 8, 7, 11, 56, 45, 22, 23,
                45, 66 };
//        sort(a);
        show(a);
        int[] b = { 55, 43, 23, 12, 13, 11, 7, 8, 88, 6, 4, 2, 3, 1, 9, 8, 7, 11, 56, 45, 22, 23,
                45, 66 };
        shell_sort(b);
        show(b);
        int[] c = { 55, 43, 23, 12, 13, 11, 7, 8, 88, 6, 4, 2, 3, 1, 9, 8, 7, 11, 56, 45, 22, 23,
                45, 66 };
        sortInserrion(c);
        show(c);

        System.out.println("\ncount=" + count);
        System.out.println("count1=" + count1);
        System.out.println("countX=" + countX);
        System.out.println("countX1=" + countX1);
        System.out.println("countInserrion=" + countInserrion);
        System.out.println("countInserrion1=" + countInserrion1);
    }

}
