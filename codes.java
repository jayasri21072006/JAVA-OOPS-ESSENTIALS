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





RECURSION

1.Given a number n, print a sequence of numbers starting from n. Each next number in the sequence is n - 5, and this continues recursively until the number becomes less than or equal to 0. After that, print the sequence in reverse order, adding 5 each time, until it reaches back to the original number n.
Note: You must not use loops.
Input: n = 10
Output: [10, 5, 0, 5, 10]
Explanation: The value decreases until it is greater or equal to 0. After that it increases and stops when it becomes 10 again.



    


    class Solution {
    public ArrayList<Integer> pattern(int n) {
        ArrayList<Integer> result = new ArrayList<>();

        // Edge case
        if (n <= 0) {
            result.add(n);
            return result;
        }

        helper(n, result);
        return result;
    }

    private void helper(int current, ArrayList<Integer> result) {
        // Add current value while going down
        result.add(current);

        // Base condition
        if (current <= 0) {
            return;
        }

        // Recursive call
        helper(current - 5, result);

        // Add current value while coming back up
        result.add(current);
    }
}


2.pascals triangle Given a positive integer n, return the nth row of pascal's triangle.
Pascal's triangle is a triangular array of the binomial coefficients formed by summing up the elements of previous row.


import java.util.*;
class Solution {
    ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        ArrayList<Integer>result=new ArrayList<>();
       result.add(1);
       int formula=1;
        for(int i=1;i<n-1;i++){
          formula=formula*(n-i)/i;
          result.add(formula);
          
            
        }
        if (n!=1){
        result.add(1);}
        
        return result;
        
    }
}


TO PRINT FULL TRIANGLE:
import java.util.*;

public class Main {
    public static void main(String[] args) {

        int n = 5;   // number of rows

        for (int i = 0; i < n; i++) {

            // 1️⃣ Print leading spaces (for centering)
            for (int space = 0; space < n - i - 1; space++) {
                System.out.print("  ");   // two spaces
            }

            // 2️⃣ Print Pascal values
            long value = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(value + "   "); // space between numbers
                value = value * (i - j) / (j + 1);
            }

            // 3️⃣ Move to next line
            System.out.println();
        }
    }
}



BINARY SEARCH::

1.Sorted Array Search

Given an array, arr[] sorted in ascending order and an integer k. Return true if k is present in the array, otherwise, false.

Examples:

Input: arr[] = [1, 2, 3, 4, 6], k = 6
Output: true
Exlpanation: Since, 6 is present in the array at index 4 (0-based indexing), output is true.
Input: arr[] = [1, 2, 4, 5, 6], k = 3
Output: false
Exlpanation: Since, 3 is not present in the array, output is false.




    class Solution {
    static boolean searchInSorted(int arr[], int k) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {  
            int mid = left + (right - left) / 2;

            if (arr[mid] == k) {
                return true;
            } 
            else if (arr[mid] > k) {
                right = mid - 1;
            } 
            else {
                left = mid + 1;
            }
        }

        return false;
    }
}


Given a sorted array arr[] and an integer x, find the index (0-based) of the largest element in arr[] that is less than or equal to x. This element is called the floor of x. If such an element does not exist, return -1.



Input: arr[] = [1, 2, 8, 10, 10, 12, 19], x = 5
Output: 1
Explanation: Largest number less than or equal to 5 is 2, whose index is 1



    class Solution {
    public int findFloor(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int floorIndex = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] <= x) {
                floorIndex = mid;   // valid floor found
                low = mid + 1;      // move right for last occurrence
            } else {
                high = mid - 1;     // move left
            }
        }

        return floorIndex;
    }
}




Problem statement
You are given an infinite array consisting of only ones and zeroes, in sorted order. You have to find the index of the first occurrence of 1.

Example:
If the array is 0 0 0 0 1 1 1 1… then, the first occurrence of 1 will be at index 4 therefore the answer here is 4.
Note:
As the array size is infinite, the actual array won’t be given to you. Instead, you will be able to access the array elements by calling a method named ‘get’.

get(i) : returns the value present at index I.

Indexing is 0-based. 

Instead of representing an infinite array in the input, we give the index of the first occurrence of 1 in the input itself. However, this input will be completely hidden from the user.

It is guaranteed that the answer will fit in a 64-bit integer.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
0 <= ARR[i] <= 1

Time limit: 1sec
Sample Input 1:
10
Sample Output 1:
10
Sample Input 2:
1
Sample Output 2:
1




    public static long firstOne() {
    long low = 0;
    long high = 1;

    // Step 1: Find range
    while (get(high) == 0) {
        low = high;
        high = high * 2;
    }

    // Step 2: Binary Search
    long ans = -1;
    while (low <= high) {
        long mid = low + (high - low) / 2;

        if (get(mid) == 1) {
            ans = mid;
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return ans;
}








SUPER IMPORTATNT QUESTION 


    MAXIMIMIZE MIN/// MINIMIZE MAX SUMS::   approacgh binary search
You are given an array with unique elements of stalls[], which denote the positions of stalls. You are also given an integer k which denotes the number of aggressive cows. The task is to assign stalls to k cows such that the minimum distance between any two of them is the maximum possible.






import java.util.Arrays;

class Solution {

    public int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];
        int answer = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlace(stalls, k, mid)) {
                answer = mid;
                low = mid + 1;   // try larger distance
            } else {
                high = mid - 1;  // try smaller distance
            }
        }

        return answer;
    }

    private boolean canPlace(int[] stalls, int k, int distance) {
        int count = 1; // first cow placed
        int lastPosition = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= distance) {
                count++;
                lastPosition = stalls[i];

                if (count == k)
                    return true;
            }
        }

        return false;
    }
}







Given an array arr[] of integers, where each element arr[i] represents the number of pages in the i-th book. You also have an integer k representing the number of students. The task is to allocate books to each student such that:

Each student receives atleast one book.
Each student is assigned a contiguous sequence of books.
No book is assigned to more than one student.
The objective is to minimize the maximum number of pages assigned to any student. In other words, out of all possible allocations, find the arrangement where the student who receives the most pages still has the smallest possible maximum.

Note: If it is not possible to allocate books to all students, return -1.




import java.util.*;

class Solution {

    public int findPages(int[] arr, int k) {
        
        int n = arr.length;
        
        // If students are more than books → impossible
        if (k > n) return -1;

        int low = 0;      // minimum possible maximum
        int high = 0;     // maximum possible maximum
        
        // Calculate low and high
        for (int pages : arr) {
            low = Math.max(low, pages); // largest single book
            high += pages;              // total sum of pages
        }

        int answer = -1;

        // Binary Search
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canAllocate(arr, k, mid)) {
                answer = mid;        // possible solution
                high = mid - 1;      // try smaller maximum
            } else {
                low = mid + 1;       // increase limit
            }
        }

        return answer;
    }

    private boolean canAllocate(int[] arr, int k, int maxPages) {
        
        int studentCount = 1;
        int currentPages = 0;

        for (int pages : arr) {

Examples:
            // If adding this book exceeds maxPages
            if (currentPages + pages > maxPages) {
                studentCount++;
                currentPages = pages;

                if (studentCount > k)
                    return false;
            } else {
                currentPages += pages;
            }
        }

        return true;
    }
}


3.Given an array arr[] where each element denotes the length of a board, and an integer k representing the number of painters available. Each painter takes 1 unit of time to paint 1 unit length of a board.

Determine the minimum amount of time required to paint all the boards, under the constraint that each painter can paint only a contiguous sequence of boards (no skipping or splitting allowed).

Examples:

Input: arr[] = [5, 10, 30, 20, 15], k = 3
Output: 35
Explanation: The optimal allocation of boards among 3 painters is - 
Painter 1 → [5, 10] → time = 15
Painter 2 → [30] → time = 30
Painter 3 → [20, 15] → time = 35
Job will be done when all painters finish i.e. at time = max(15, 30, 35) = 35
Input: arr[] = [10, 20, 30, 40], k = 2
Output: 60
Explanation: A valid optimal partition is - 
Painter 1 → [10, 20, 30] → time = 60
Painter 2 → [40] → time = 40
Job will be complete at time = max(60, 40) = 60
Input: arr[] = [100, 200, 300, 400], k = 1
Output: 1000
Explanation: There is only one painter, so the painter must paint all boards sequentially. The total time taken will be the sum of all board lengths, i.e., 100 + 200 + 300 + 400 = 1000.



    import java.util.*;

class Solution {

    public int minTime(int[] arr, int k) {
        
        int n = arr.length;
        
        // If painters are more than boards,
        // still valid (some painters may remain idle)
        
        int low = 0;
        int high = 0;
        
        // Define search space
        for (int length : arr) {
            low = Math.max(low, length);  // largest single board
            high += length;               // total sum of boards
        }

        int answer = high;

        // Binary Search
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPaint(arr, k, mid)) {
                answer = mid;      // possible solution
                high = mid - 1;    // try smaller maximum time
            } else {
                low = mid + 1;     // increase allowed time
            }
        }

        return answer;
    }

    private boolean canPaint(int[] arr, int k, int maxTime) {
        
        int painterCount = 1;
        int currentTime = 0;

        for (int length : arr) {

            if (currentTime + length > maxTime) {
                painterCount++;
                currentTime = length;

                if (painterCount > k)
                    return false;
            } else {
                currentTime += length;
            }
        }

        return true;
    }
}


