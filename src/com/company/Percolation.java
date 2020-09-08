package com.company;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.QuickFindUF;

public class Percolation {
    private int size;
    private int[] grid;
    private int openSquares = 0;

    private int[] calculateCoordinates(int index){
        int row = index/size;
        int column = index % size;
        int coordinates[] = {row, column};
        return coordinates;

    }
    private int calculateIndex(int row, int column){
        return row * size + column;
    }
    private int findAdjacentSquares(int N, int row, int column){
        int top = (row - 1) * N + column;
        int bottom = (row + 1) * N + column;
        int left = row * N + (column - 1);
        int right = row * N + (column + 1);
        return -1;
    }
    private void findRandomSquare(){
         int[] square = calculateCoordinates(StdRandom.uniform(0, size));
         boolean open_check = isOpen(square[0], square[1]);
         if(open_check == false){
             open(square[0], square[1]);
         }
    }

    public Percolation(int N){
        size = N;
        grid = new int[N * N];
    }

    // WQU probably useful
    public void open(int row, int col){
        int curr_index = calculateIndex(row, col);
        grid[curr_index] = 1;

    }

    // WQU probably useful
    public boolean isOpen(int row, int col){
        int curr_index = calculateIndex(row, col);
        if(grid[curr_index] > 0){
            return true;
        } else {
            return false;
        }
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
