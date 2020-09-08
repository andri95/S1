package com.company;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.QuickFindUF;

public class Percolation {

    private void calculateCoordinates(int N, int index){
        int row = index/N;
        int column = index % N;
        open(row, column);
        findAdjacentSquares(N, row, column);
    }
    private int caclulateIndex(int N, int row, int column){
        return row * N + column;
    }
    private int findAdjacentSquares(int N, int row, int column){
        int top = (row - 1) * N + column;
        int bottom = (row + 1) * N + column;
        int left = row * N + (column - 1);
        int right = row * N + (column + 1);
        return -1;
    }
    private void findRandomSquare(int N){
         calculateCoordinates(N, StdRandom.uniform(0, N));
    }

    public Percolation(int N){
        int board[] = new int[N * N];
        findRandomSquare(N);
    }

    // WQU probably useful
    public void open(int row, int col){
        StdRandom.uniform(0, N)
    }

    // WQU probably useful
    public boolean isOpen(int row, int col){
        return true;
    }

    // WQU probably useful
    public boolean isFull(int row, int col){
        return true;
    }

    // WQU probably useful
    public int numberOfOpenSites(){
        return -1;
    }

    // WQU probably useful
    public boolean percolates(){
        return true;
    }

    // Testing
    public static void main(String[] args) {
	// write your code here
    }
}
