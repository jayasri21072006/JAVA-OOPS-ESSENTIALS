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

split Array Largest Sum
Difficulty: HardAccuracy: 58.9%Submissions: 64K+Points: 8
Given an array arr[] and an integer k, divide the array into k contiguous subarrays such that the maximum sum among these subarrays is minimized. Find this minimum possible maximum sum.

Examples:

Input: arr[] = [1, 2, 3, 4], k = 3
Output: 4
Explanation: Optimal Split is [1, 2], [3], [4]. Maximum sum of all subarrays is 4, which is minimum possible for 3 splits.
Input: arr[] = [1, 1, 2], k = 2
Output: 2
Explanation: Splitting the array as [1, 1] and [2] is optimal. This results in a maximum sum subarray of 2.

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







LINKED LIST:
    Search in Linked List
Difficulty: EasyAccuracy: 65.4%Submissions: 129K+Points: 2Average Time: 10m
Given a linked list with the head node and a key, the task is to check if the key is present in the linked list or not. Return true if key is present, else return false.

Example:

Input: key = 3,
      
Output: true
Explanation: 3 is present in Linked List.

Input: key = 4,
   
Output: false
Explanation: 4 is not present in Linked List.







    class Solution {
    public boolean searchKey(Node head, int key) {
        
        Node current = head;
        
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        
        return false;
    }
}






Reverse a linked list
Difficulty: EasyAccuracy: 73.11%Submissions: 381K+Points: 2Average Time: 30m
You are given the head of a singly linked list. You have to reverse the linked list and return the head of the reversed list.

Examples:

Input:
      
Output: 4 -> 3 -> 2 -> 1
Explanation: After reversing the linkedList
      
Input: 




class Solution {
    public Node reverseList(Node head) {
        
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while (current != null) {
            
            next = current.next;   // Step 1: store next
            
            current.next = prev;   // Step 2: reverse link
            
            prev = current;        // Step 3: move prev forward
            current = next;        // move current forward
        }
        
        return prev;  // new head
    }
}






Palindrome Linked List
Difficulty: MediumAccuracy: 41.48%Submissions: 388K+Points: 4Average Time: 20m
You are given the head of a singly linked list of positive integers. You have to check if the given linked list is palindrome or not.

Examples:

Input:
   
Output: true
Explanation: The given linked list is 1 -> 2 -> 1 -> 1 -> 2 -> 1, which is a palindrome.
Input:




class Solution {
    public boolean isPalindrome(Node head) {
        
        // Edge case
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find middle
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        Node prev = null;
        Node curr = slow;

        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        // Step 3: Compare both halves
        Node left = head;
        Node right = prev;

        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }
}




Intersection in Y Shaped Lists
Difficulty: MediumAccuracy: 44.67%Submissions: 324K+Points: 4Average Time: 45m
You are given the heads of two non-empty singly linked lists, head1 and head2, that intersect at a certain point. Return that Node where these two linked lists intersect.

Note: It is guaranteed that the intersected node always exists.

In the custom input you have to give input for CommonList which pointed at the end of both head1 and head2 to form a Y-shaped linked list.
Examples:

Input: head1: 10 -> 15 -> 30, head2: 3 -> 6 -> 9 -> 15 -> 30
Output: 15
Explanation: From the above image, it is clearly seen that the common part is 15 -> 30, whose starting point is 15.
    
Input: head1: 4 -> 1 -> 8 -> 5, head2: 5 -> 6 -> 1 -> 8 -> 5
Output: 1
Explanation: From the above image, it is clearly seen that the common part is 1 -> 8 -> 5, whose starting point is 1.




    sol:
Ultra Simple Mental Model

Imagine two people walking different paths that merge.

If both walk the same total distance,
they must step onto the merge point at the same time.



    class Solution {
    public Node intersectPoint(Node head1, Node head2) {
        
        Node p1 = head1;
        Node p2 = head2;
        
        // Traverse until both pointers meet
        while (p1 != p2) {
            
            // If p1 reaches end, switch to head2
            if (p1 == null) {
                p1 = head2;
            } else {
                p1 = p1.next;
            }
            
            // If p2 reaches end, switch to head1
            if (p2 == null) {
                p2 = head1;
            } else {
                p2 = p2.next;
            }
        }
        
        // Either intersection node OR null (if no intersection)
        return p1;
    }
}
[ 2 pointer approach]




TREE SET -pattern for linked list

    Union of Two Linked Lists
Difficulty: MediumAccuracy: 58.65%Submissions: 63K+Points: 4Average Time: 20m
Given two linked lists (L1 & L2), your task is to complete the function makeUnion(), which returns the union list of two linked lists. This union list should include all the distinct elements only and it should be sorted in ascending order.

Examples:

Input: L1 = 9->6->4->2->3->8, L2 = 1->2->8->6->2
Output: 1 -> 2 -> 3 -> 4 -> 6 -> 8 -> 9

Explanation: All the distinct numbers from two lists, when sorted form the list in the output. 


    import java.util.*;

class Solution {
    public static Node findUnion(Node head1, Node head2) {
        
        // TreeSet removes duplicates and keeps sorted order
        TreeSet<Integer> set = new TreeSet<>();
        
        Node temp = head1;
        
        // Add elements of first list
        while (temp != null) {
            set.add(temp.data);
            temp = temp.next;
        }
        
        temp = head2;
        
        // Add elements of second list
        while (temp != null) {
            set.add(temp.data);
            temp = temp.next;
        }
        
        // Create new sorted linked list
        Node dummy = new Node(0);
        Node current = dummy;
        
        for (int val : set) {
            Node n = new Node(val);
            current = current.next;
        }
        
        return dummy.next;
    }
}





Delete without head pointer


    
Difficulty: MediumAccuracy: 78.57%Submissions: 224K+Points: 4
You are given a node del_node of a Singly Linked List where you have to delete this given node from the linked list but you are not given the head of the list.

After deleting the given node:

The number of nodes in the linked list should decrease by one.
All the values before & after the del_node node should be in the same order.
Note: It is guaranteed that there exists a node with a value equal to the del_node value and it will not be the last node of the linked list.

Examples:

Input: Linked List = 1 -> 2, del_node = 1
Output: 2
Explanation: After deleting 1 from the linked list, we have remaining nodes as 2.




    class Solution {
 
    void deleteNode(Node del_node) {
        
        // Copy data from next node
        del_node.data = del_node.next.data;
        
        // Skip the next node
        del_node.next = del_node.next.next;
    }
}




Count Pairs whose sum is equal to X
Difficulty: EasyAccuracy: 39.61%Submissions: 112K+Points: 2Average Time: 20m
Given two linked lists head1 and head2 with distinct elements, determine the count of all distinct pairs from both lists whose sum equals the given value x.

Note: A valid pair would be in the form (x, y) where x is from the first linked list and y is from the second linked list. (1, 3) and (3, 1) are considered different.

Examples:

Input: head1 = 1->2->3->4->5->6, head2 = 11->12->13, x = 15

Output: 3
Explanation: There are total 3 pairs whose sum is 15 : (4,11) , (3,12) and (2,13)
Input: head1 = 7->5->1->3, head2 = 3->5->2->8, x = 10

Output: 2
Explanation: There are total 2 pairs whose sum is 10 : (7,3) and (5,5)





    import java.util.HashSet;

class Solution {
    // Function to count pairs in two linked lists whose sum is equal to x
    public int countPairs(Node head1, Node head2, int x) {
        
        HashSet<Integer> set = new HashSet<>();
        
        // Store elements of second linked list
        Node temp2 = head2;
        while (temp2 != null) {
            set.add(temp2.data);
            temp2 = temp2.next;
        }
        
        int count = 0;
        
        // Traverse first linked list
        Node temp1 = head1;
        while (temp1 != null) {
            
            int complement = x - temp1.data;
            
            if (set.contains(complement)) {
                count++;
            }
            
            temp1 = temp1.next;
        }
        
        return count;
    }
}


TORTOISE AND HARE ALGORITHM::
    Detect Loop in linked list
Difficulty: MediumAccuracy: 43.49%Submissions: 517K+Points: 4Average Time: 20m
You are given the head of a singly linked list. You have to determine whether the given linked list contains a loop or not. A loop exists in a linked list if the next pointer of the last node points to any other node in the list (including itself), rather than being null.

Note: Internally, pos(1 based index) is used to denote the position of the node that tail's next pointer is connected to. If pos = 0, it means the last node points to null. Note that pos is not passed as a parameter.

Examples:

Input: pos = 2,
   
Output: true
Explanation: There exists a loop as last node is connected back to the second node.
Input: pos = 0,
   
Output: false
Explanation: There exists no loop in given linked list.



    class Solution {
    public boolean detectLoop(Node head) {
        
        if (head == null || head.next == null)
            return false;
        
        Node slow = head;
        Node fast = head;
        
        while (fast != null && fast.next != null) {
            
            slow = slow.next;          // move 1 step
            fast = fast.next.next;     // move 2 steps
            
            if (slow == fast) {
                return true;           // loop found
            }
        }
        
        return false;                  // no loop
    }
}




Find length of Loop
Difficulty: MediumAccuracy: 44.26%Submissions: 303K+Points: 4Average Time: 30m
Given the head of a linked list, determine whether the list contains a loop. If a loop is present, return the number of nodes in the loop, otherwise return 0.

Note: Internally, pos(1 based index) is used to denote the position of the node that tail's next pointer is connected to. If pos = 0, it means the last node points to null, indicating there is no loop. Note that pos is not passed as a parameter.

Examples:

Input: pos = 2,
   
Output: 4
Explanation: There exists a loop in the linked list and the length of the loop is 4.
Input: pos = 3,
   
Output: 3
Explanation: The loop is from 19 to 10. So length of loop is 19 → 33 → 10 = 3.



    class Solution {
    public int lengthOfLoop(Node head) {
        
        if (head == null || head.next == null)
            return 0;
        
        Node slow = head;
        Node fast = head;
        
        // Step 1: Detect Loop
        while (fast != null && fast.next != null) {
            
            slow = slow.next;
            fast = fast.next.next;
            
            // Loop detected
            if (slow == fast) {
                
                int count = 1;
                Node temp = slow.next;
                
                // Step 2: Count loop length
                while (temp != slow) {
                    count++;
                    temp = temp.next;
                }
                
                return count;
            }
        }
        
        // No loop
        return 0;
    }
}



First Node of Loop in Linked List
Difficulty: MediumAccuracy: 55.49%Submissions: 97K+Points: 4
You are given the head of a singly linked list. If a loop is present in the linked list then return the first node of the loop else return -1.

Note: Internally, pos(1 based index) is used to denote the position of the node that tail's next pointer is connected to. If pos = 0, it means the last node points to null, indicating there is no loop. Note that pos is not passed as a parameter.

Examples:

Input: pos = 2,
   
Output: 3
Explanation: We can see that there exists a loop in the given linked list and the first node of the loop is 3.


    class Solution {
    public int cycleStart(Node head) {
        
        if (head == null || head.next == null)
            return -1;
        
        Node slow = head;
        Node fast = head;
        
        // Step 1: Detect Loop
        while (fast != null && fast.next != null) {
            
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                
                // Step 2: Find Start of Loop
                slow = head;
                
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                
                return slow.data;   // Return value of start node
            }
        }
        
        return -1;  // No loop
    }
}








Remove loop in Linked List
Difficulty: MediumAccuracy: 27.66%Submissions: 549K+Points: 4Average Time: 45m
Given the head of a singly linked list, the task is to remove a cycle if present. A cycle exists when a node's next pointer points back to a previous node, forming a loop. Internally, a variable pos denotes the index of the node where the cycle starts, but it is not passed as a parameter. The terminal will print true if a cycle is removed otherwise, it will print false.

Examples:

Input: head = 1 -> 3 -> 4, pos = 2
Output: true
Explanation: The linked list looks like

A loop is present in the list, and it is removed.




    class Solution {
    public void removeLoop(Node head) {

        if (head == null || head.next == null)
            return;

        Node slow = head;
        Node fast = head;

        // Step 1: Detect loop
        boolean hasLoop = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                hasLoop = true;
                break;
            }
        }

        if (!hasLoop)
            return;

        // Step 2: Find start of loop
        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        Node loopStart = slow;

        // Step 3: Find last node of loop
        Node temp = loopStart;

        while (temp.next != loopStart) {
            temp = temp.next;
        }

        // Break the loop
        temp.next = null;
    }
}










Linked List Group Reverse
Difficulty: HardAccuracy: 57.08%Submissions: 271K+Points: 8Average Time: 30m
You are given the head of a Singly linked list. You have to reverse every k node in the linked list and return the head of the modified list.
Note: If the number of nodes is not a multiple of k then the left-out nodes at the end, should be considered as a group and must be reversed.

Examples:

Input: k = 2,
   

Output: 2 -> 1 -> 4 -> 3 -> 6 -> 5
Explanation: Linked List is reversed in a group of size k = 2.





    

class Solution {

    public Node reverseKGroup(Node head, int k) {
        if (head == null) return null;

        Node temp = head;
        Node prev = null;
        Node front = null;
        int count = 0;

        // Reverse first k nodes
        while (temp != null && count < k) {
            front = temp.next;   // store next node
            temp.next = prev;    // reverse link
            prev = temp;         // move prev forward
            temp = front;        // move temp forward
            count++;
        }

        // Recursively reverse remaining list
        if (temp != null) {
            head.next = reverseKGroup(temp, k);
        }

        // prev becomes new head of this group
        return prev;
    }
}





sorting
    Sort a linked list of 0s, 1s and 2s
Difficulty: MediumAccuracy: 60.75%Submissions: 287K+Points: 4Average Time: 30m
Given the head of a linked list where nodes can contain values 0s, 1s, and 2s only. Your task is to rearrange the list so that all 0s appear at the beginning, followed by all 1s, and all 2s are placed at the end.

Examples:

Input: head = 1 → 2 → 2 → 1 → 2 → 0 → 2 → 2
   
Output: 0 → 1 → 1 → 2 → 2 → 2 → 2 → 2
Explanation: All the 0s are segregated to the left end of the linked list, 2s to the right end of the list, and 1s in between. The final list will be:
   
Input: head = 2 → 2 → 0 → 1
   
Output: 0 → 1 → 2 → 2
Explanation: After arranging all the 0s, 1s and 2s in the given format, the output will be:






class Solution {
    public Node segregate(Node head) {
        
        if (head == null) return null;

        // Dummy heads
        Node zeroDummy = new Node(-1);
        Node oneDummy = new Node(-1);
        Node twoDummy = new Node(-1);

        // Tail pointers
        Node zero = zeroDummy;
        Node one = oneDummy;
        Node two = twoDummy;

        Node temp = head;

        // Step 1: Distribute nodes
        while (temp != null) {
            if (temp.data == 0) {
                zero.next = temp;
                zero = zero.next;
            } 
            else if (temp.data == 1) {
                one.next = temp;
                one = one.next;
            } 
            else {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }

        // Step 2: Connect lists
        zero.next = (oneDummy.next != null) ? oneDummy.next : twoDummy.next;
        one.next = twoDummy.next;
        two.next = null;

        // Step 3: Return new head
        return zeroDummy.next;
    }
}







Pairwise swap elements of a linked list
Difficulty: EasyAccuracy: 52.06%Submissions: 132K+Points: 2Average Time: 20m
Given a singly linked list. The task is to swap elements in the linked list pairwise. For example, if the input list is 1 2 3 4, the resulting list after swaps will be 2 1 4 3.

Note: You need to swap the nodes, not only the data. If only data is swapped then the driver code will print -1.

Examples:

Input: LinkedList: 1->2->2->4->5->6->7->8
Output: 2->1->4->2->6->5->8->7





    class Solution {
    public Node pairwiseSwap(Node head) {
        
        if (head == null || head.next == null)
            return head;

        // New head will be second node
        Node newHead = head.next;

        Node prev = null;
        Node current = head;

        while (current != null && current.next != null) {

            Node nextPair = current.next.next;
            Node second = current.next;

            // Swap
            second.next = current;
            current.next = nextPair;

            if (prev != null) {
                prev.next = second;
            }

            // Move prev and current
            prev = current;
            current = nextPair;
        }

        return newHead;
    }
}


Merge two sorted linked lists
Difficulty: MediumAccuracy: 62.91%Submissions: 206K+Points: 4Average Time: 30m
Given the head of two sorted linked lists consisting of nodes respectively. Merge both lists and return the head of the sorted merged list.

Examples:

Input:
  
Output: 2 -> 3 -> 5 -> 10 -> 15 -> 20 -> 40
Explanation:
   
Input:
  
Output: 1 -> 1 -> 2 -> 4
Explanation:
  
Constraints:
1 ≤ list1.size, list2.size ≤ 103
0 ≤ node->data ≤ 105





    class Solution {
    public Node sortedMerge(Node head1, Node head2) {
        
        // Dummy node to simplify edge cases
        Node dummy = new Node(-1);
        Node tail = dummy;

        Node t1 = head1;
        Node t2 = head2;

        while (t1 != null && t2 != null) {
            
            if (t1.data <= t2.data) {
                tail.next = t1;
                t1 = t1.next;
            } else {
                tail.next = t2;
                t2 = t2.next;
            }
            
            tail = tail.next;
        }

        // Attach remaining nodes
        if (t1 != null) {
            tail.next = t1;
        } else {
            tail.next = t2;
        }

Remove duplicates from a linked list
Difficulty: EasyAccuracy: 45.95%Submissions: 260K+Points: 2Average Time: 20m
Given an unsorted linked list. The task is to remove duplicate elements from this unsorted Linked List. When a value appears in multiple nodes, the node which appeared first should be kept, all other duplicates are to be removed.

Examples:

Input: LinkedList: 5->2->2->4
Output: 5->2->4
Explanation: Given linked list elements are 5->2->2->4, in which 2 is repeated only. So, we will delete the extra repeated elements 2 from the linked list and the resultant linked list will contain 5->2->4




    import java.util.HashSet;

class Solution {
    public Node removeDuplicates(Node head) {
        
        if (head == null)
            return null;

        HashSet<Integer> set = new HashSet<>();
        
        Node current = head;
        Node prev = null;

        while (current != null) {
            
            if (set.contains(current.data)) {
                // Duplicate found → remove node
                prev.next = current.next;
            } else {
                // First time seeing this value
                set.add(current.data);
                prev = current;
            }
            
            current = current.next;
        }

        return head;
    }
}

        
        return dummy.next;
    }
}






































































































STACK:

Implement stack using array
Difficulty: MediumAccuracy: 54.76%Submissions: 313K+Points: 4Average Time: 25m
Implement a Stack using an Array, where the size of the array, n is given.
The Stack must support the following operations:

(i) push(x): Insert an element x at the top of the stack.
(ii) pop(): Remove the element from the top of the stack.
(iii) peek(): Return the top element if not empty, else -1.
(iv) isEmpty(): Return true if the stack is empty else return false.
(v) isFull(): Return true if the stack is full else return false.

There will be a sequence of queries queries[][]. The queries are represented in numeric form:

1 x : Call push(x)

2 : Call pop()

3 : Call peek()

4  : Call isEmpty()

5 : Call isFull()

You just have to implement the functions push, pop, peek, isEmpty, and isFull. The driver code will handle the output.

Note: All the queries are valid.

Examples:

Input: n = 3, q = 6, queries[][] = [[1, 5], [1, 3], [3], [2], [4], [5]]
Output: [3, false, false]
Explanation: Queries on stack are as follows:
push(5) : Insert 5 at the top of the stack.
push(3) : Insert 3 at the top of the stack.
peek() : Return the top element i.e. 3.
pop() : Remove the top element i.e. 3.
isEmpty() : return false as the stack is not empty.
isFull() : return false as the stack is not full. Capacity = 3.
Input: n = 1, q = 5, queries[][] =  [[2], [3], [4], [1, 9], [5]]
Output: [-1, -1, true, true]
Explanation: Queries on stack are as follows:
pop(): Since stack is empty, nothing is popped.
peek(): Return the top element. Since the stack is empty, return -1.
isEmpty(): Return true as the stack is empty.
push(9): Insert 9 at the top of the stack. The stack will be [9].
isFull(): Return true as the stack is full. Capacity = 1.




    class myStack {

    int[] stack;
    int top;
    int capacity;

    public myStack(int n) {
        capacity = n;
        stack = new int[n];
        top = -1;   // stack is empty initially
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void push(int x) {
        if (isFull()) {
            return;   // as per problem, queries are valid
        }

        top++;
        stack[top] = x;
    }

    public void pop() {
        if (isEmpty()) {
            return;
        }

        top--;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }





        Two Stacks in an Array
Difficulty: MediumAccuracy: 56.49%Submissions: 177K+Points: 4Average Time: 20m
You are given an array of a fixed size. Your task is to efficiently implement two stacks in this single array.

The following operations must be supported:

(i) twoStacks : Initialize the data structures and variables to be used to implement  2 stacks in one array.
(ii) push1(x) : pushes element into the first stack.
(iii) push2(x) : pushes element into the second stack.
(iv) pop1() : pops an element from the first stack and returns the popped element. If the first stack is empty, it should return -1.
(v) pop2() : pops an element from the second stack and returns the popped element. If the second stack is empty, it should return -1.

Examples:

Input:
push1(2)
push1(3)
push2(4)
pop1()
pop2()
pop2()
Output: [3, 4, -1]
Explanation: 
push1(2): the stack1 will be [2]
push1(3): the stack1 will be [2,3]
push2(4): the stack2 will be [4]
pop1(): the poped element will be 3 from stack1 and stack1 will be {2}
pop2(): the poped element will be 4 from stack2 and now stack2 is empty
pop2(): the stack2 is now empty hence returned -1.



    class twoStacks {

    int[] arr = new int[1000];  // assuming max size
    int top1;
    int top2;

    twoStacks() {
        top1 = -1;
        top2 = arr.length;
    }

    // Push into stack1
    void push1(int x) {

        if (top1 + 1 < top2) {
            top1++;
            arr[top1] = x;
        }
    }

    // Push into stack2
    void push2(int x) {

        if (top1 + 1 < top2) {
            top2--;
            arr[top2] = x;
        }
    }

    // Pop from stack1
    int pop1() {

        if (top1 >= 0) {
            int value = arr[top1];
            top1--;
            return value;
        }

        return -1;
    }

    // Pop from stack2
    int pop2() {

        if (top2 < arr.length) {
            int value = arr[top2];
            top2++;
            return value;
        }

        return -1;
    }
}

        return stack[top];
    }
}

arenthesis Checker
Difficulty: EasyAccuracy: 28.56%Submissions: 724K+Points: 2
Given a string s, composed of different combinations of '(' , ')', '{', '}', '[', ']'. Determine whether the Expression is balanced or not.
An expression is balanced if:

Each opening bracket has a corresponding closing bracket of the same type.
Opening brackets must be closed in the correct order.
Examples :

Input: s = "[{()}]"
Output: true
Explanation: All the brackets are well-formed.

  import java.util.*;

class Solution {
    public boolean isBalanced(String s) {
        
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // If opening bracket, push to stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // If closing bracket
            else {
                
                // If stack is empty → no matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                
                // Check matching pair
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        // If stack is empty → balanced
        return stack.isEmpty();
    }
}
    

Next Greater Element
Difficulty: MediumAccuracy: 32.95%Submissions: 508K+Points: 4Average Time: 20m
You are given an array arr[] of integers, the task is to find the next greater element for each element of the array in order of their appearance in the array. Next greater element of an element in the array is the nearest element on the right which is greater than the current element.
If there does not exist next greater of current element, then next greater element for current element is -1.

Examples

Input: arr[] = [1, 3, 2, 4]
Output: [3, 4, 4, -1]
Explanation: The next larger element to 1 is 3, 3 is 4, 2 is 4 and for 4, since it doesn't exist, it is -1.
Input: arr[] = [6, 8, 0, 1, 3]
Output: [8, -1, 1, 3, -1]
Explanation: The next larger element to 6 is 8, for 8 there is no larger elements hence it is -1, for 0 it is 1, for 1 it is 3 and then for 3 there is no larger element on right and hence -1.
Input: arr[] = [1, 2, 3, 5]
Output: [2, 3, 5, -1]
Explanation: For a sorted array, the next element is 



   import java.util.*;

class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            
            // Remove smaller or equal elements
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            
            // If stack is empty, no greater element
            if (stack.isEmpty()) {
                result.add(-1);
            } else {
                result.add(stack.peek());
            }
            
            // Push current element
            stack.push(arr[i]);
        }
        
        // Reverse because we filled result from right to left
        Collections.reverse(result);
        
        return result;
    }
}





    Help Classmates
Difficulty: MediumAccuracy: 69.73%Submissions: 39K+Points: 4
Professor X wants his students to help each other in the chemistry lab. He suggests that every student should help out a classmate who scored less marks than him in chemistry and whose roll number appears after him. But the students are lazy and they don't want to search too far. They each pick the first roll number after them that fits the criteria. Find the marks of the classmate that each student picks.
Note: one student may be selected by multiple classmates.

Example 1:

Input: N = 5, arr[] = {3, 8, 5, 2, 25}
Output: 2 5 2 -1 -1
Explanation: 
1. Roll number 1 has 3 marks. The first person 
who has less marks than him is roll number 4, 
who has 2 marks.
2. Roll number 2 has 8 marks, he helps student 
with 5 marks.
3. Roll number 3 has 5 marks, he helps student 
with 2 marks.
4. Roll number 4 and 5 can not pick anyone as 
no student with higher roll number has lesser 
marks than them. This is denoted by -1.
Output shows the marks of the weaker student that 
each roll number helps in order. ie- 2,5,2,-1,-1


import java.util.*;

class Solution {
    public int[] help_classmate(int arr[], int n) {
        
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            
            // Remove elements greater or equal
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            
            // If stack empty → no smaller element
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            
            // Push current element
            stack.push(arr[i]);
        }
        
        return result;
    }
}import java.util.*;

class Solution {
    public int[] help_classmate(int arr[], int n) {
        
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            
            // Remove elements greater or equal
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            
            // If stack empty → no smaller element
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            
            // Push current element
            stack.push(arr[i]);
        }
        
        return result;
    }
}
    




Stock span problem
Difficulty: MediumAccuracy: 43.56%Submissions: 262K+Points: 4
The stock span problem is a financial problem where we have a series of daily price quotes for a stock and we need to calculate the span of stock price for all days.
You are given an array arr[] representing daily stock prices, the stock span for the i-th day is the number of consecutive days up to day i (including day i itself) for which the price of the stock is less than or equal to the price on day i. Return the span of stock prices for each day in the given sequence.

Examples:

Input: arr[] = [100, 80, 90, 120]
Output: [1, 1, 2, 4]
Explanation: Traversing the given input span 100 is greater than equal to 100 and there are no more days behind it so the span is 1, 80 is greater than equal to 80 and smaller than 100 so the span is 1, 90 is greater than equal to 90 and 80 so the span is 2, 120 is greater than 90, 80 and 100 so the span is 4. So the output will be [1, 1, 2, 4].
Input: arr[] = [10, 4, 5, 90, 120, 80]
Output: [1, 1, 2, 4, 5, 1]
Explanation: Traversing the given input span 10 is greater than equal to 10 and there are no more days behind it so the span is 1, 4 is greater than equal to 4 and smaller than 10 so the span is 1, 5 is greater than equal to 4 and 5 and smaller than 10 so the span is 2, and so on. Hence the output will be [1, 1, 2, 4, 5, 1]. 


import java.util.*;

class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        
        int n = arr.length;
        ArrayList<Integer> span = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            
            // Remove all previous smaller or equal prices
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            
            // If no greater element on left
            if (stack.isEmpty()) {
                span.add(i + 1);
            } else {
                span.add(i - stack.peek());
            }
            
            // Push current index
            stack.push(i);
        }
        
        return span;
    }
}




iven an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 

Example 1:

import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];
        
        // Step 1: Find Left Small
        for (int i = 0; i < n; i++) {
            
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            
            if (stack.isEmpty())
                leftSmall[i] = 0;
            else
                leftSmall[i] = stack.peek() + 1;
            
            stack.push(i);
        }
        
        // Clear stack for reuse
        stack.clear();
        
        // Step 2: Find Right Small
        for (int i = n - 1; i >= 0; i--) {
            
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            
            if (stack.isEmpty())
                rightSmall[i] = n - 1;
            else
                rightSmall[i] = stack.peek() - 1;
            
            stack.push(i);
        }
        
        // Step 3: Calculate Maximum Area
        int maxArea = 0;
        
        for (int i = 0; i < n; i++) {
            int width = rightSmall[i] - leftSmall[i] + 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }
}
    

Infix to Postfix
Difficulty: MediumAccuracy: 52.94%Submissions: 163K+Points: 4
You are given a string s representing an infix expression. Convert this infix expression to a postfix expression.

Infix expression: The expression of the form a op b. When an operator is in between every pair of operands.
Postfix expression: The expression of the form a b op. When an operator is followed for every pair of operands.
Note: The precedence order is as follows: (^) has the highest precedence and is evaluated from right to left, (* and /) come next with left to right associativity, and (+ and -) have the lowest precedence with left to right associativity.

Examples :

Input: s = "a*(b+c)/d"
Output: abc+*d/
Explanation: The expression is a*(b+c)/d. First, inside the brackets, b+c becomes bc+. Now the expression looks like a*(bc+)/d. Next, multiply a with (bc+), so it becomes abc+* . Finally, divide this result by d, so it becomes abc+*d/.
Input: s = "a+b*c+d"
Output: abc*+d+
Explanation: The expression a+b*c+d is converted by first doing b*c -> bc*, then adding a -> abc*+, and finally adding d -> abc*+d+.


    import java.util.*;

class Solution {
    
    static int precedence(char c){
        if(c=='^') return 3;
        if(c=='*' || c=='/') return 2;
        if(c=='+' || c=='-') return 1;
        return -1;
    }

    public static String infixToPostfix(String s) {
        
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            
            char ch = s.charAt(i);
            
            if(Character.isLetterOrDigit(ch)){
                result.append(ch);
            }
            
            else if(ch=='('){
                stack.push(ch);
            }
            
            else if(ch==')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                    result.append(stack.pop());
                }
                stack.pop();
            }
            
            else{
                while(!stack.isEmpty() && 
                      (precedence(stack.peek()) > precedence(ch) ||
                      (precedence(stack.peek()) == precedence(ch) && ch != '^'))){
                    
                    result.append(stack.pop());
                }
                
                stack.push(ch);
            }
        }
        
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        
        return result.toString();
    }
}































Queue Using Array
Difficulty: BasicAccuracy: 47.24%Submissions: 278K+Points: 1Average Time: 15m
Implement a Queue using an Array, where the size of the array, n is given.
The Queue must support the following operations:

(i) enqueue(x): Insert an element x at the rear of the queue.
(ii) dequeue(): Remove the element from the front of the queue.
(iii) getFront(): Return front element if not empty, else -1.
(iv) getRear(): Return rear element if not empty, else -1.
(v) isEmpty(): Return true if the queue is empty else return false.
(vi) isFull(): Return true if the queue is full else return false.

There will be a sequence of queries queries[][]. The queries are represented in numeric form:

1 x : Call enqueue(x)
2: Call dequeue()
3: Call getFront()
4: Call getRear()
5: Call isEmpty()
6: Call isFull()





    class myQueue {

    int[] arr;
    int front;
    int rear;
    int size;
    int count;

    // Constructor
    public myQueue(int n) {
        size = n;
        arr = new int[n];
        front = 0;
        rear = -1;
        count = 0;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return count == 0;
    }

    // Check if queue is full
    public boolean isFull() {
        return count == size;
    }

    // Insert element at rear
    public void enqueue(int x) {

        if (isFull()) {
            return;
        }

        rear = (rear + 1) % size;
        arr[rear] = x;
        count++;
    }

    // Remove element from front
    public void dequeue() {

        if (isEmpty()) {
            return;
        }

        front = (front + 1) % size;
        count--;
    }

    // Get front element
    public int getFront() {

        if (isEmpty()) {
            return -1;
        }

        return arr[front];
    }

    // Get rear element
    public int getRear() {

        if (isEmpty()) {
            return -1;
        }

        return arr[rear];
    }
}





Queue using Linked List
Difficulty: BasicAccuracy: 45.6%Submissions: 176K+Points: 1Average Time: 20m
Implement a Queue using a Linked List, this queue has no fixed capacity and can grow dynamically until memory is available.
The Queue must support the following operations:

(i) enqueue(x): Insert an element x at the rear of the queue.
(ii) dequeue(): Remove the element from the front of the queue.
(iii) getFront(): Return front element if not empty, else -1.
(iv) isEmpty(): Return true if the queue is empty else return false.
(v) size(): Return the number of elements currently in the queue.

There will be a sequence of queries queries[][]. The queries are represented in numeric form:

1 x : Call enqueue(x)
2: Call dequeue()
3: Call getFront()
4: Call isEmpty()
5: Call size()
You just have to implement the functions enqueue, dequeue, getFront,  isEmpty and size. The driver code will handle the input and output.

Examples:

Input: q = 7, queries[][] = [[1, 5], [1, 3], [1, 4], [3], [2], [5], [4]]
Output: [5, 2, false]
Explanation: Queries on queue are as follows:
enqueue(5): Insert 5 at the rear of the queue.
enqueue(3): Insert 3 at the rear of the queue.
enqueue(4): Insert 4 at the rear of the queue.
getFront(): Return the front element i.e 5.
dequeue(): Remove the front element 5 from the queue.
size(): Queue now has 2 elements.
isEmpty(): Queue is not empty return false.




    // Node class
class Node {
    int data;
    Node next;

    Node(int new_data) {
        data = new_data;
        next = null;
    }
}

// Queue class
class myQueue {

    Node front;
    Node rear;
    int count;

    public myQueue() {
        front = null;
        rear = null;
        count = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(int x) {

        Node newNode = new Node(x);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } 
        else {
            rear.next = newNode;
            rear = newNode;
        }

        count++;
    }

    public void dequeue() {

        if (isEmpty()) {
            return;
        }

        front = front.next;
        count--;

        if (front == null) {
            rear = null;
        }
    }

    public int getFront() {

        if (isEmpty()) {
            return -1;
        }

        return front.data;
    }

    public int size() {
        return count;
    }
}













Queue Reversal
Difficulty: EasyAccuracy: 77.98%Submissions: 161K+Points: 2
Given a queue q containing integer elements, your task is to reverse the queue.

Examples:

Input: q[] = [5, 10, 15, 20, 25]
Output: [25, 20, 15, 10, 5]
Explanation: After reversing the given elements of the queue, the resultant queue will be 25 20 15 10 5.
Input: q[] = [1, 2, 3, 4, 5]
Output: [5, 4, 3, 2, 1]
Explanation: After reversing the given elements of the queue, the resultant queue will be 5 4 3 2 1.



    class Solution {
    public void reverseQueue(Queue<Integer> q) {
        Stack<Integer> stack=new Stack<>();
        while(!q.isEmpty()){
            stack.push(q.remove());
        }
        while(!stack.isEmpty()){
            q.add(stack.pop());
        }
        return;
        
    }
}











Gas Station
Difficulty: MediumAccuracy: 34.79%Submissions: 221K+Points: 4Average Time: 20m
There are n gas stations along a circular tour. You are given two integer arrays gas[] and cost[], where gas[i] is the amount of gas available at station i and cost[i] is the gas needed to travel from station i to station (i+1). You have a car with an unlimited gas tank and start with an empty tank at some station. Your task is to return the index of the starting station if it is possible to travel once around the circular route in a clockwise direction without running out of gas at any station; otherwise, return -1.

Note: If a solution exists, it is guaranteed to be unique.

Examples:

Input: gas[] = [4, 5, 7, 4], cost[]= [6, 6, 3, 5]
Output: 2
Explanation: Start at gas station at index 2 and fill up with 7 units of gas. Your tank = 0 + 7 = 7
Travel to station 3. Available gas = (7 – 3 + 4) = 8.
Travel to station 0. Available gas = (8 – 5 + 4) = 7.
Travel to station 1. Available gas = (7 – 6 + 5) = 6.
Return to station 2. Available gas = (6 – 6) = 0.





    class Solution {
    public int startStation(int[] gas, int[] cost) {
        
        int total = 0;
        int tank = 0;
        int start = 0;
        
        for(int i = 0; i < gas.length; i++){
            
            int diff = gas[i] - cost[i];
            
            total += diff;
            tank += diff;
            
            if(tank < 0){
                start = i + 1;
                tank = 0;
            }
        }
        
        if(total < 0){
            return -1;
        }
        
        return start;
    }
}


























Reverse a Stack
Difficulty: MediumAccuracy: 80.5%Submissions: 129K+Points: 4Average Time: 20m
You are given a stack st[]. You have to reverse the stack.

Note: The input array represents the stack from bottom to top (last element is the top). The output is displayed by printing elements from top to bottom after reversal.

Examples:

Input: st[] = [1, 2, 3, 4]
Output: [1, 2, 3, 4]
Explanation: After reversing, the elements of stack are in opposite order.

Input: st[] = [3, 2, 1]

    import java.util.Stack;

class Solution {
    
    public static void reverseStack(Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        }
        
        int top = st.pop();
        reverseStack(st);
        insertAtBottom(st, top);
    }
    
    private static void insertAtBottom(Stack<Integer> st, int x) {
        if (st.isEmpty()) {
            st.push(x);
            return;
        }
        
        int top = st.pop();
        insertAtBottom(st, x);
        st.push(top);
    }
}


culty: MediumAccuracy: 69.19%Submissions: 173K+Points: 4Average Time: 20m
Given a stack of integers st[]. Sort the stack in ascending order (smallest element at the bottom and largest at the top).

Examples:

Input: st[] = [1, 2, 3]
Output: [3, 2, 1]
Explanation: The stack is already sorted in ascending



    import java.util.Stack;

class Solution {

    public static void sortStack(Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        }

        int top = st.pop();
        sortStack(st);
        insertSorted(st, top);
    }

    private static void insertSorted(Stack<Integer> st, int x) {
        if (st.isEmpty() || st.peek() <= x) {
            st.push(x);
            return;
        }

        int top = st.pop();
        insertSorted(st, x);
        st.push(top);
    }
}



A celebrity is a person who is known to all but does not know anyone at a party. A party is being organized by some people. A square matrix mat[][] of size n*n is used to represent people at the party such that if an element of row i and column j is set to 1 it means ith person knows jth person. You need to return the index of the celebrity in the party, if the celebrity does not exist, return -1.

Note: Follow 0-based indexing.

Examples:

Input: mat[][] = [[1, 1, 0],
                [0, 1, 0],
                [0, 1, 1]]
Output: 1
Explanation: 0th and 2nd person both know 1st person and 1st person does not know anyone. Therefore, 1 is the celebrity person.
Input: mat[][] = [[1, 1], 
                [1, 1]]
Output: -1
Explanation: Since both the people at the party know each other. Hence none of them is a celebrity person.  







    
class Solution {
    public int celebrity(int mat[][]) {
        int top = 0;
        int down = mat.length - 1;

        // Step 1: Find the candidate
        while (top < down) {           // ✅ Fix 1: < not >
            if (mat[top][down] == 1) {
                top++;                 // top knows down → top can't be celebrity
            } else if (mat[down][top] == 1) {
                down--;                // down knows top → down can't be celebrity
            } else {
                // Neither knows the other → neither can be celebrity
                top++;                 // ✅ Fix 2: handle the else case
                down--;
            }
        }

        // Step 2: Validate the candidate       ✅ Fix 3: verify before returning
        if (top == down) {
            int candidate = top;
            int n = mat.length;

            for (int i = 0; i < n; i++) {
                if (i == candidate) continue;
                // Celebrity must NOT know anyone, and must be known by everyone
                if (mat[candidate][i] == 1 || mat[i][candidate] == 0) {
                    return -1;
                }
            }
            return candidate;
        }

        return -1;
    }
}
    
