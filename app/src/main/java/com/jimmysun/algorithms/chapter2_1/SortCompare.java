package com.jimmysun.algorithms.chapter2_1;

import com.jimmysun.algorithms.chapter1_4.Stopwatch;
import com.jimmysun.algorithms.chapter2_3.Quick;
import com.jimmysun.algorithms.chapter2_4.Heap;

import edu.princeton.cs.algs4.InsertionX;
import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.MergeX;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class SortCompare {
	public static double time(String alg, Double[] a) {
		Stopwatch timer = new Stopwatch();
		if (alg.equals("Insertion")) {
			Insertion.sort(a);
		}
		if (alg.equals("InsertionX")) {
			InsertionX.sort(a);
		}
		if (alg.equals("Selection")) {
			Selection.sort(a);
		}
		if (alg.equals("Shell")) {
			Shell.sort(a);
		}
		if (alg.equals("MergeX")) {
			MergeX.sort(a);
		}
		if (alg.equals("Merge")) {
			Merge.sort(a);
		}
		if (alg.equals("MergeX1")) {
			MergeX.sort(a);
		}
		if (alg.equals("Quick")) {
			Quick.sort(a);
		}
		if (alg.equals("Heap")) {
			Heap.sort(a);
		}
		// Exercise 2.1.24

		// Exercise 2.1.25
		if (alg.equals("Ex25")) {
			Ex25.sort(a);
		}
		return timer.elapsedTime();
	}

	public static double timeRandomInput(String alg, int N, int T) {
		double total = 0.0;
		Double[] a = new Double[N];
		for (int t = 0; t < T; t++) {
			for (int i = 0; i < N; i++) {
				a[i] = StdRandom.uniform();
			}
			total += time(alg, a);
		}
		return total;
	}

	public static void main(String[] args) {
		String alg1 = "Merge";
		String alg2 = "MergeX";
		String alg3 = "MergeX1";
		int N = 30000;
		int T = 100;
		double t1 = timeRandomInput(alg1, N, T);
		double t2 = timeRandomInput(alg2, N, T);
		double t3 = timeRandomInput(alg3, N, T);
		StdOut.printf("For %d random Doubles\n  %s is", N, alg1);
		StdOut.printf(" %.1f times faster than %s\n", t2 / t1, alg2);
		StdOut.printf("For %d random Doubles\n  %s is", N, alg3);
		StdOut.printf(" %.1f times faster than %s\n", t2 / t3, alg2);
	}
}
