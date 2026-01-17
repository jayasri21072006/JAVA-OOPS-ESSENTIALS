#2 pointer


1.Two Sum - Pair with Given Sum
Given an array arr[] of integers and another integer target. Determine if there exist two distinct indices such that the sum of their elements is equal to the target.




2-POINTER:


class Solution {
    boolean twoSum(int arr[], int target) {

        Arrays.sort(arr);   // required

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }
}




BRUTE FORCE::
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







3.Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        if (n < 4) return result;

        Arrays.sort(nums); 

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;     
                int right = n - 1;    
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(
                                nums[i], nums[j], nums[left], nums[right]
                        ));

                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    }
                    else if (sum < target) {
                        left++;
                    }
                    else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}



4.Find triplets with zero sum

Given an array arr[] of integers, determine whether it contains a triplet whose sum equals zero. Return true if such a triplet exists, otherwise, return false.

    
import java.util.*;

class Solution {
    public boolean findTriplets(int[] arr) {

        int n = arr.length;
        if (n < 3) return false;

        Arrays.sort(arr);

        for (int i = 0; i < n - 2; i++) {

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == 0) {
                    return true;
                }
                else if (sum > 0) {
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        return false;
    }
}






5.Count the triplets

Given an array arr, count the number of distinct triplets (a, b, c) such that:

a + b = c

Each triplet is counted only once, regardless of the order of a and b.


import java.util.*;

class Solution {
    int countTriplet(int arr[]) {

        int n = arr.length;
        int count = 0;

        Arrays.sort(arr);

        // Fix c one by one (from largest to smallest)
        for (int i = n - 1; i >= 2; i--) {

            int left = 0;
            int right = i - 1;

            while (left < right) {

                int sum = arr[left] + arr[right];

                if (sum == arr[i]) {
                    count++;
                    left++;
                    right--;
                }
                else if (sum < arr[i]) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return count;
    }
}










6.Union of Arrays with Duplicates
You are given two arrays a[] and b[], return the Union of both the arrays in any order.

The Union of two arrays is a collection of all distinct elements present in either of the arrays. If an element appears more than once in one or both arrays, it should be included only once in the result.

Note: Elements of a[] and b[] are not necessarily distinct.


    import java.util.*;

class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {

        Arrays.sort(a);
        Arrays.sort(b);

        ArrayList<Integer> result = new ArrayList<>();

        int i = 0, j = 0;
        int n = a.length, m = b.length;

        while (i < n && j < m) {

            if (a[i] < b[j]) {
                if (result.size() == 0 || result.get(result.size() - 1) != a[i]) {
                    result.add(a[i]);
                }
                i++;
            }
            else if (a[i] > b[j]) {
                if (result.size() == 0 || result.get(result.size() - 1) != b[j]) {
                    result.add(b[j]);
                }
                j++;
            }
            else { // a[i] == b[j]
                if (result.size() == 0 || result.get(result.size() - 1) != a[i]) {
                    result.add(a[i]);
                }
                i++;
                j++;
            }
        }

        // remaining elements in a
        while (i < n) {
            if (result.get(result.size() - 1) != a[i]) {
                result.add(a[i]);
            }
            i++;
        }

        // remaining elements in b
        while (j < m) {
            if (result.get(result.size() - 1) != b[j]) {
                result.add(b[j]);
            }
            j++;
        }

        return result;
    }
}






7.Intersection of Arrays with Distinct

Given two unsorted integer arrays a[] and b[] each consisting of distinct elements, the task is to return the count of elements in the intersection (or common elements) of the two arrays.

Intersection of two arrays can be defined as the set containing distinct common elements between the two arrays. 



import java.util.*;

class Solution {
    public static int intersectSize(int a[], int b[]) {

        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0, j = 0;
        int count = 0;

        while (i < a.length && j < b.length) {

            if (a[i] < b[j]) {
                i++;
            }
            else if (a[i] > b[j]) {
                j++;
            }
            else { // a[i] == b[j]
                count++;
                i++;
                j++;
            }
        }
        return count;
    }
}






8.Remove Duplicates Sorted Array

You are given a sorted array arr[] containing positive integers. Your task is to remove all duplicate elements from this array such that each element appears only once. Return an array containing these distinct el


import java.util.*;

class Solution {
    ArrayList<Integer> removeDuplicates(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;
        if (n == 0) return result;

        result.add(arr[0]); // first element always added

        int i = 1; // pointer to traverse array
        while (i < n) {
            if (arr[i] != arr[i - 1]) {
                result.add(arr[i]);
            }
            i++;
        }

        return result;
    }
}





9.K-th element of two Arrays
Given two sorted arrays a[] and b[] and an element k, the task is to find the element that would be at the kth position of the combined sorted array.
    

import java.util.*;
class Solution {
    public int kthElement(int a[], int b[], int k) {
        int n = a.length;
        int m = b.length;
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;  // initialize pointers

        // merge arrays until one is finished
        while (i < n && j < m) {
            if (a[i] < b[j]) {
                result.add(a[i]);
                i++;
            } else {
                result.add(b[j]);
                j++;
            }
        }

        // add remaining elements from a[]
        while (i < n) {
            result.add(a[i]);
            i++;
        }

        // add remaining elements from b[]
        while (j < m) {
            result.add(b[j]);
            j++;
        }

        // kth element (1-based)
        return result.get(k - 1);
    }
}



10.Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.



    



class Solution {
    public int trap(int[] height) {
        
        
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
                right--;
            }
        }
        return water;

        
    }
}
```







