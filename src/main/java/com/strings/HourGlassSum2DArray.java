package com.strings;

public class HourGlassSum2DArray {
    public static void main(String[] args) {

    }

    private static int hourglassSum(int[][] arr) {
        int maxRow = 6, maxCol = 6, rowIndex = 0, columnIndex = 0, maxValue = 0;
        while(true) {
            //Hour Glass Sum
            int rowOne = sumRow(rowIndex, columnIndex, columnIndex + 2, arr);
            int rowTwo = arr[rowIndex + 1] [columnIndex + 1];
            int rowThree = sumRow(rowIndex + 2, columnIndex, columnIndex + 2, arr);

            int total = rowOne + rowTwo + rowThree;

            if((rowIndex == 0 && columnIndex == 0 ) || maxValue < total) {
                maxValue = total;
            }

            columnIndex++;
            if(columnIndex >= maxCol - 2) {
                rowIndex++;
                columnIndex = 0;
            }
            if(rowIndex >= maxRow - 2 )
                break;
        }
        return maxValue;
    }

    private static int sumRow(int rowIndex, int startColIndex, int endcolIndex, int[][] array) {

        int sum = 0;
        for(int col = startColIndex; col <= endcolIndex; col ++ ) {
            sum = sum + array[rowIndex][col];
        }
        return sum;
    }
}
