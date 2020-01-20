package com.yobo.yobo_algorithms.test2_2;

import com.jimmysun.algorithms.chapter1_4.Stopwatch;
import com.yobo.yobo_algorithms.test2_1.Insertion;
import com.yobo.yobo_algorithms.test2_1.Shell;
import com.yobo.yobo_algorithms.test2_3.QuickInsertion;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class SortCompare {
	public static double time(int alg, double[] a) {
		Stopwatch timer = new Stopwatch();
		if (alg==1) {
			Merge.sort(a);
		}
		if (alg==2) {
			MergeX.sort(a);
		}
		if (alg==3){
			QuickInsertion.sort(a);
		}
		if (alg==4){
			Shell.sort(a);
		}
		if (alg==5){
			MergeX1.sort(a);
		}
		if (alg==6){
			Insertion.sort(a);
		}
		return timer.elapsedTime();
	}

	public static double timeRandomInput(int alg, int N, int T) {
		double total = 0.0;
		double[] a = new double[N];
		for (int t = 0; t < T; t++) {
			for (int i = 0; i < N; i++) {
				a[i] = StdRandom.uniform()*10000;
			}
			total += time(alg, a);
		}
		return total;
	}

	private static void show(double[] a) {
		System.out.println("\n");
		for (double item : a) {
			System.out.println(String.format("%6.2f",item) );
		}
	}

	public static void main(String[] args) {
		int N = 60000;
		int T = 100;
		double t1 = timeRandomInput(1, N, T);
		double t2 = timeRandomInput(2, N, T);
		double t3 = timeRandomInput(3, N, T);
		double t4 = timeRandomInput(4, N, T);
		double t5 = timeRandomInput(5, N, T);
		double t6 = timeRandomInput(6, N, T);
		StdOut.printf("For %d random Doubles\n  %s is", N, 2);
		StdOut.printf(" %.1f times faster than %s\n", t2 / t1, 1);
		StdOut.printf("For %d random Doubles\n  %s is", N, 3);
		StdOut.printf(" %.1f times faster than %s\n", t3 / t1, 1);
		StdOut.printf("For %d random Doubles\n  %s is", N, 4);
		StdOut.printf(" %.1f times faster than %s\n", t4 / t1, 1);
		StdOut.printf("For %d random Doubles\n  %s is", N, 5);
		StdOut.printf(" %.1f times faster than %s\n", t5 / t1, 1);
		StdOut.printf("For %d random Doubles\n  %s is", N, 6);
		StdOut.printf(" %.1f times faster than %s\n", t6 / t1, 1);

	}
}
