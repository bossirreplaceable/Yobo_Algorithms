package com.yobo.yobo_algorithms.test2_2;

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

    private static void sort(int[] a) {
        int N = a.length;
        int h = 1;
        // 3x+1 increment sequence: 1, 4, 13, 40, 121, 364, 1093, ...
        while (h < N / 3)
            h = 3 * h + 1;
        while (h >= 1) {
            System.out.println("h=" + h);
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

    public static void shell_sort(int array[]) {
        int temp = 0;
        int N = array.length;
        int incre = N;

        while (true) {
            incre = incre / 2;
            System.out.println("hX=" + incre);
            for (int k = 0; k < incre; k++) { // 根据增量分为若干子序列
                for (int i = k + incre; i < N; i += incre) {
                    for (int j = i; j > k; j -= incre) {
                        countX++;
                        if (array[j] < array[j - incre]) {
                            countX1++;
                            temp = array[j - incre];
                            array[j - incre] = array[j];
                            array[j] = temp;
                        } else {
                            break;
                        }
                    }
                }
            }
            if (incre == 1) {
                break;
            }
        }
    }

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

    private static void show(int[] a) {
        System.out.println("\n");
        for (int item : a) {
            System.out.print(item + ",");
        }
    }

    public static void main(String[] args) {
        int[] a = { 55, 43, 23, 12, 13, 11, 7, 8, 88, 6, 4, 2, 3, 1, 9, 8, 7, 11, 56, 45, 22, 23,
                45, 66 };
        sort(a);
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
