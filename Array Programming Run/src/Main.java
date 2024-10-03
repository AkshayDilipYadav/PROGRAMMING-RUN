// Equillibrium Index of an Array

public class Solution{
    public int solve(int[] A){
        int totalSum = 0, leftSum = 0;
        for(int num : A){totalSum += num;}
        for(int i = 0; i < A.length; i++){
            if(leftSum == totalSum -A[i]){return i;}
            leftSum += A[i];
            totalSum -= A[i];
        }
        return -1;
    }
}

// In- place Prefix Sum

public class Solution{
    public int[] solve(int[] A){
        for(int i = 1; i < A.length; i++){
            A[i] = A[i-1]+ A[i];
        }
    }
}

// Maximum Subarray

public class Solution{
    public int solve(int A, int B, int[] C){
        int maxSum = 0, currentSum = 0;
        int l = 0;
        for(int r = 0; r < A; r++){
            currentSum += C[r];
            while(currentSum > B){currentSum -= C[l++];}
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}

// sum of all subarrays
public class Solution{
    public long solve(int[] A){
        long totalSum = 0;
        int n = A.length;
        for(int i = 0; i < n; i++){
            int endSubarrays = i+1;
            int startSubarrays = n-1;
            long contribution = (long)A[i]* endSubarrays*startSubarrays;
            totalSum += contribution;
        }
        return totalSum;
    }
}

// subarray with given sum and length

public class Solution{
    public int solve(int[] A, int B, int C){
        int sum = 0;
        for(int i = 0; i < B; i++){sum += A[i];}
        if(sum == C){return 1;}
        for(int i = B; i < A.length; i++){
            sum += A[i] - A[i-B];
            if(sum == C){return 1;}
        }
        return 0;
    }
}

// Max Sum Contiguous Subarray
public class Solution{
    public int solve(int[] A){
        int n = A.length;
        int maxEndingHere = A[0];
        int maxSoFar = A[0];
        for(int i = 1; i < n; i++){
            maxEndingHere = Math.max(A[i], maxEndingHere + A[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere)
        }
        return maxSoFar;
    }
}

// Continuous Sum Query
public class Solution{
    public int[] solve(int A, int[][] B){
        int[] result = new int[A];
        for(int i = 0; i < B.length; i++){
            int L = B[i][0] - 1;
            int R = B[i][1] - 1;
            int P = B[i][2];
            result[L] += P;
            if(R+1 < A){result[R+1] -= P;}
        }
        for(int i = 1; i < A; i++){result[i] += result[i-1];}
        return result;
    }
}
// Rain Water Trapped

public class Solution {
    public int trap(final int[] A) {
        if(A == null || A.length < 3){return 0;}
        int l = 0;
        int r = A.length-1;
        int leftMax = 0;
        int rightMax = 0;
        int waterTrapped = 0;
        while(l<r){
            int left = A[l];
            int right = A[r];
            if(left < right){
                if(left >= leftMax){leftMax = left;}
                else{waterTrapped += leftMax - left;}
                l++;
            }
            else{
                if(right >=rightMax){rightMax = right;}
                else{waterTrapped+= rightMax - right;}
                r--;
            }
        }
        return waterTrapped;
    }
}

// First Missing Integer
public class Solution {
    public int firstMissingPositive(int[] A) {
        int n = A.length;
        for(int i = 0; i < n; i++){
            while(A[i] > 0 && A[i] <= n && A[A[i]-1] != A[i]){
                int temp = A[i];
                A[i] = A[A[i]-1];
                A[temp -1] = temp;
            }
        }
        for(int i = 0; i < n; i++){
            if(A[i] != i+1){return i+1;}
        }
        return n+1;
    }
}

// Merge Intervals

public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<>();
        int i = 0;
        int n = intervals.size();
        while (i < n && intervals.get(i).end < newInterval.start) {
            result.add(intervals.get(i++));
        }
        while (i < n && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        result.add(newInterval);
        while (i < n) {
            result.add(intervals.get(i++));
        }
        return result;
    }
}

// Merge Sorted Overlapping Intervals

public class Solution {
    public Interval[] merge(Interval[] intervals) {
        if (intervals == null || intervals.length <= 1)
            return intervals;
        int n = intervals.length;
        int mergedCount = 0;
        for (int i = 1; i < n; i++) {
            if (intervals[i].start <= intervals[mergedCount].end) {
                intervals[mergedCount].end = Math.max(intervals[mergedCount].end, intervals[i].end);
            } else {
                mergedCount++;
                intervals[mergedCount] = intervals[i];
            }
        }
        return Arrays.copyOf(intervals, mergedCount + 1);
    }
}

// Rotated Sorted Array Search

public class Solution {
    public int search(final int[] A, int B) {
        int l = 0, r =A.length -1;
        while(l <= r){
            int m = l +(r-l)/2;
            if(A[m] == B){return m;}
            if(A[l] <= A[m]){
                if(B >= A[l] && B < A[m]){r= m-1;}
                else{l = m+1;}
            }
            else{
                if(B > A[m] && B <= A[r]){l = m+1;}
                else{r= m-1;}
            }
        }
        return -1;
    }
}

// Ath Magical Number

public class Solution {
    private static final int MOD = 1000000007;

    public int solve(int A, int B, int C) {
        long low = 1;
        long high = (long) A * Math.min(B, C);
        long lcm = lcm(B, C);

        while (low < high) {
            long mid = low + (high - low) / 2;
            if (countMagicalNumbers(mid, B, C, lcm) < A) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return (int) (low % MOD);
    }

    private long countMagicalNumbers(long x, int B, int C, long lcm) {
        return (x / B) + (x / C) - (x / lcm);
    }

    private long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }
}

//Square Root of Integer

public class Solution {
    public int sqrt(int A) {
        if (A == 0 || A == 1) {
            return A;
        }
        int left = 1;
        int right = A;
        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long midSquared = (long) mid * mid;

            if (midSquared == A) {
                return mid;
            } else if (midSquared < A) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}

//Painter's Partition Problem

public class Solution{
    private static final int MOD = 10000003;
    public int paint(int A, int B, int[] C){
        int n = C.length;
        if(A > n){A = n;}
        long low = 0;
        long high = 0;
        for(int length : C){
            low = Math.max(low, length);
            high += length;
        }
        long result = high;
        while(low <= high){
            long mid = low +(high - low)/2;
            if(canPaint(C, A, mid)){
                result = mid;
                high = mid - 1;
            }
            else{low = mid+1;}
        }
        return (int) ((result * B)%MOD);
    }
    private boolean canPaint(int[] C, int A, long maxTime){
        int painterCount = 1;
        long currentSum = 0;
        for(int length : C){
            if(currentSum + length > maxTime){
                painterCount++;
                currentSum = length;
                if(painterCount > A){return false;}
            }
            else{currentSum += length;}
        }
        return true;
    }
}

// Aggressive Cows

public class Solution {
    public int solve(int[] A, int B) {
        Arrays.sort(A);
        int low = 1;
        int high = A[A.length - 1] - A[0];
        int result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPlaceCows(A, B, mid)) {
                result = mid;
                low = mid + 1; // Try for a larger minimum distance
            } else {
                high = mid - 1; // Try for a smaller minimum distance
            }
        }

        return result;
    }

    private boolean canPlaceCows(int[] A, int B, int minDist) {
        int cowsPlaced = 1;
        int lastPos = A[0];

        for (int i = 1; i < A.length; i++) {
            if (A[i] - lastPos >= minDist) {
                cowsPlaced++;
                lastPos = A[i];
                if (cowsPlaced == B) {
                    return true;
                }
            }
        }

        return false;
    }
}

// Merge Sort

public class Solution{
    public int[] solve(int[] A){
        if(A.length < 2){return A;}
        int[] aux = new int[A.length];
        fun1(A, aux, 0, A.length-1);
        return A;
    }
    public static void fun1(int[] A, int[] aux, int left, int right){
        if(left < right){
            int middle = (left + right)/2;
            fun1(A,aux,left,middle);
            fun1(A,aux,middle+1, right);
            fun2(A, aux, left, middle, right);
        }
    }
    public static void fun2(int[] A, int[] aux, int left, int middle, int right){
        for(int i = left; i<=right;i++){aux[i] = A[i];}
        int i = left, j = middle+1, k=left;
        while(i <= middle && j <= right){
            if(aux[i]<=aux[j]){A[k++]=aux[i++];}
            else{A[k++] = aux[j++];}
        }
        while(i <= middle){A[k++] = aux[i++];}
    }
}


// B Closest Point to Origin

public class Solution{
    public int[][] solve(int[][] A, int B){
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] p1, int[] p2){
                return distanceSquared(p2) - distanceSquared(p1);
            }
        });
        for(int[] point : A){
            maxHeap.offer(point);
            if(maxHeap.size() > B){maxHeap.poll();}
        }
        int[][] result = new int[B][2];
        for(int i = 0; i < B; i++){result[i] = maxHeap.poll();}
        return result;
    }
    private int distanceSquared(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }
}

// Quick Sort

public class Solution {
    public int[] solve(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        quickSort(A, 0, A.length - 1);
        return A;
    }
    private void quickSort(int[] A, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(A, low, high);
            quickSort(A, low, partitionIndex - 1);
            quickSort(A, partitionIndex + 1, high);
        }
    }
    private int partition(int[] A, int low, int high) {
        int pivot = A[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (A[j] < pivot) {
                i++;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        int temp = A[i + 1];
        A[i + 1] = A[high];
        A[high] = temp;

        return i + 1;
    }
}









