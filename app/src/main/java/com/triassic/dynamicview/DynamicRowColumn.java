package com.triassic.dynamicview;

import android.util.Log;

/**
 * Created by Lijo Joseph on 08-02-2017.
 */

public class DynamicRowColumn {
    int totalCount;
    int row = 1;
    int column = 1;

    public DynamicRowColumn(int totalCount){
        this.totalCount = totalCount;
        generateRowColumn(totalCount);
    }



    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    private void generateRowColumn(int totalCount){
        Log.d(this.getClass().getName(), "getClosestPerfectSquare: "+getClosestPerfectSquare(totalCount));
        switch (totalCount){
            case 1:
                row = 1; column =1;
            break;
            case 2:
                row = 1; column =2;
                break;
            case 3:
            case 4:
                row = 2; column = 2;
                break;
            case 5:
            case 6:
                row = 2; column = 3;
                break;
            case 7:
            case 8:
                row = 2; column = 4;
                break;
            case 9:
                row = 3 ; column = 3;
                break;
            case 10:
            case 11:
            case 12:
                row = 3 ; column = 4;
                break;
            case 13:
            case 14:
            case 15:
            case 16:
                row = 4 ; column = 4;
                break;
            case 17:
            case 18:
            case 19:
            case 20:
                row = 4 ; column = 5;
                break;
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                row = 5 ; column = 5;
                break;
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
                row = 5 ; column = 6;
                break;
            default:
                int perfectSqr = getClosestPerfectSquare(totalCount);
                row = (int) Math.sqrt(perfectSqr); column = (int) Math.sqrt(perfectSqr);
                break;
        }
    }

    public int getClosestPerfectSquare(int x) {
        int min = findMinSquareRoot(x, 1, x);

        int a = min * min;
        int b = (min + 1) * (min + 1);

        if (x - a < b - x) {
            return a;
        } else if (x - a > b - x) {
            return b;
        } else {
            return x;
        }
    }

    private int findMinSquareRoot(int x, int left, int right) {
        if (left > right) {
            return -1;
        }
        if (left * left <= x && x <= (left + 1) * (left + 1)) {
            return left;
        }

        int mid = left + (right - left) / 2;
        int midSquare = mid * mid;
        int midOneSquare = (mid + 1) * (mid + 1);

        if (x > midOneSquare) {
            return findMinSquareRoot(x, mid + 1, right);
        } else if (x < midSquare) {
            return findMinSquareRoot(x, left + 1, mid);
        } else {
            return mid;
        }
    }
}
