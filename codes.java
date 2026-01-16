#2 pointer


1.Two Sum - Pair with Given Sum
Given an array arr[] of integers and another integer target. Determine if there exist two distinct indices such that the sum of their elements is equal to the target.

class Solution {
    boolean twoSum(int arr[], int target) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}


2.Triplet Sum in Array


import java.util.Arrays;

class Solution {
    boolean hasTripletSum(int arr[], int target) {
        int n = arr.length;
        Arrays.sort(arr);

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == target) return true;
                else if (sum < target) left++;
                else right--;
            }
        }
        return false;
    }
}
