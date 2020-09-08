package com.company;

import edu.princeton.cs.algs4.*;
import java.lang.IndexOutOfBoundsException;
import java.lang.IllegalArgumentException;

public class Percolation {
    private int size;
    private int[] grid;
    private WeightedQuickUnionUF WQU;
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
    private int[][] findAdjacentSquares(int row, int column){
        int adjacentSquares[][] = new int[4][2];
        int top[] = {(row - 1), column};
        adjacentSquares[0][0] = top[0];
        adjacentSquares[0][1] = top[1];
        int bottom[] = {(row + 1),column};
        adjacentSquares[1][0] = bottom[0];
        adjacentSquares[1][1] = bottom[1];
        int left[] = {row, (column - 1)};
        adjacentSquares[2][0] = left[0];
        adjacentSquares[2][1] = left[1];
        int right[] = {row, (column + 1)};
        adjacentSquares[3][0] = right[0];
        adjacentSquares[3][1] = right[1];
        return adjacentSquares;
    }
    private void findRandomSquare(){
         int[] square = calculateCoordinates(StdRandom.uniform(0, size*size));
         boolean open_check = isOpen(square[0], square[1]);
         if(open_check == false){
             open(square[0], square[1]);
             openSquares = openSquares + 1;
         }
         unionAdjacent(square[0], square[1]);
    }
    private void unionAdjacent(int row, int col){
        int adjacentSquares[][] = findAdjacentSquares(row, col);
        for(int i = 0; i < adjacentSquares.length; i++){
            if(adjacentSquares[i][0] >= 0 && adjacentSquares[i][0] < size) {
                if(adjacentSquares[i][1] >= 0 && adjacentSquares[i][1] < size) {
                    if (isOpen(adjacentSquares[i][0], adjacentSquares[i][1]) == true)
                        WQU.union(calculateIndex(row, col), calculateIndex(adjacentSquares[i][0], adjacentSquares[i][1]));
                }
            }
        }
    }
    private boolean isUnion(int index){
        if(index >= 0 && index < size * size) {
            for (int i = 0; i < size; i++) {
                if (WQU.connected(index, i)) {
                    return true;
                }
            }
            return false;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
    /*------------------------------------------
    private void run(){
        boolean doesItPercolate = percolates();
        while (!doesItPercolate){
            findRandomSquare();
            doesItPercolate = percolates();
        }
        StdOut.println(openSquares);
    }
     -------------------------------------------*/

    public Percolation(int N){
        size = N;
        WQU = new WeightedQuickUnionUF(size * size);
        grid = new int[N * N];
        //run();
    }

    // WQU probably useful
    public void open(int row, int col){
        int curr_index = calculateIndex(row, col);
        if(curr_index >= 0 && curr_index < size*size){
            grid[curr_index] = 1;
            unionAdjacent(row, col);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    // WQU probably useful
    public boolean isOpen(int row, int col){
        int curr_index = calculateIndex(row, col);
        if(curr_index >= 0 && curr_index < size*size) {
            if (grid[curr_index] > 0) {
                return true;
            } else {
                return false;
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    // WQU probably useful
    public boolean isFull(int row, int col){
        return isUnion(calculateIndex(row, col));
    }

    // WQU probably useful
    public int numberOfOpenSites(){
        return openSquares;
    }

    // WQU probably useful
    public boolean percolates(){
        for(int i = size*size - 4; i < size*size; i++){
            if(isUnion(i) == true){
                return true;
            }
        }
        return false;
    }

    // Testing
    public static void main(String[] args) {
        /*---------------------------------------
        StdOut.println("Enter grid size:");
        int N = StdIn.readInt();
        if(N > 0){
            new Percolation(N);
        } else {
            throw new IllegalArgumentException();
        }

         ---------------------------------------*/

    }
}

