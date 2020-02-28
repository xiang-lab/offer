package com.zhangxiang.offer;

public class main {
    public static void main(String[] args) {
        Solution3 solution1 = new Solution3();
        int tmp[][] = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        boolean b =  solution1.Find(5, tmp);
        System.out.println(b);
    }
}

// 自作答案
class Solution1 {
    public boolean Find(int target, int[][] array) {

        int len = array[0].length;
        if (len == 0) {
            return false;
        }

        for (int[] a : array) {
            if (a[0] <= target && a[len-1] >= target) {
                if (a[0] == target || a[len-1] == target) {
                    return true;
                }
                int i = 0, j = len-1;
                while (i <= j) {
                    if (a[(j+i)/2] > target) {
                        j = (j+i)/2 - 1;
                    } else if (a[(j+i)/2] < target) {
                        i = (j+i)/2 + 1;
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

// 网上答案
class Solution2 {
    public boolean Find(int target, int[][] array) {

        int len = array[0].length;
        if (len == 0) {
            return false;
        }

        int len2 = array.length;
        for (int i = len2 -1; i >= 0 ; i--) {
            if (array[i][0] <= target) {
                if (array[i][len-1] < target) {
                    return false;
                }
                int a = 0, b = len-1;
                while (a <= b) {
                    if (array[i][(b+a)/2] > target) {
                        b = (b+a)/2 - 1;
                    } else if (array[i][(b+a)/2] < target) {
                        a = (b+a)/2 + 1;
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

// 书上答案
class Solution3 {
    public boolean Find(int target, int[][] array) {

        int col = array[0].length -1;
        int row = 0;

        while (row < array.length && col > -1) {
            if (array[row][col] > target) {
                col--;
            } else if (array[row][col] < target) {
                row++;
            } else {
                return true;
            }
        }

        return false;
    }
}