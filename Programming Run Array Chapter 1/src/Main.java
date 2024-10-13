// Introduction to Problem Solving

// Count factor

public class Solution{
    public int solve(int A){
        int result = 0;
        for(int i = 1; i*i <= A; i++){
            if(A % i == 0){
                if(i == A/i){result++;}
                else{result +=2;}
            }
        }
        return result;
    }
}

// Is Prime

public class Solution{
    public int solve(int A){
        if(A <= 1){return 0;}
        for(int i = 2; i *i <= A; i++){
            if(A % i ==0){return 0;}
        }
        return 1;
    }
}

// Perfect number

public class Solution{
    public int solve(int A){
        if(A <= 1){return 0;}
        int factorSum = 1;
        for(int i = 2; i*i <= A; i++ ) {
            if(A%i == 0){
                if(i == A/i){factorSum += i;}
                else{factorSum += i + A/i;}
            }
        }
        if(factorSum == A){return 1;}
        else{return 0;}
    }
}

// Count primes

public class Solution{
    public boolean isPrime(int A){
        if(A<=1){return false;}
        for(int i =2 ; i *i <= A; i++){
            if(A % i ==0){return false;}
        }
        return true;
    }
public int solve(int A){
    int count = 0;
    for(int i = 1; i <= A; i++){
        if(isPrime(i)){count++;}
    }
    return count;
}
}

//---------------------------------------------------------------------

// Introduction to Arrays

// Good Pair
public class Solution{
    public int solve(int[] A, int B){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < A.length; i++){
            if(set.contains(B - A[i])){return 1;}
            set.add(A[i]);
        }
        return 0;
    }
}
// Reverse in a Range
public class Solution{
    public int[] solve(int[] A, int B, int C){
        while(B < C){
            int temp = A[B];
            A[B] = A[C];
            A[C] = temp;
            B++;
            C--;
        }
        return A;
    }
}
// Array Rotation
public class Solution{
    public int[] solve(int[] A, int B){
        B = B % A.length;
        int[] result = new int[A.length];
        for(int i = 0; i < A.length; i++){
            result[(i+B)%A.length] = A[i];
        }
        return result;
    }
}
// Max MIn of an Array

public class Solution{
    public int solve(int[] A){
        int max = A[0];
        int min = A[0];
        for(int i = 1; i < A.length; i++){
            if(A[i] > max){max = A[i];}
            else if(A[i] < min){min = A[i];}
        }
        return max+min;
    }
}

// Linear Search

public class Solution{
    public int solve(int[] A, int B){
        int count = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] == B){count++;}
        }
        return count;
    }
}

// Time to Equality

public class Solution{
    public int solve(int[] A){
        int result = 0;
        int max =A[0];
        for(int i = 1; i < A.length; i++){
          if(A[i]> max){max = A[i];}
        }
        for(int i = 0; i < A.length; i++){
            result += max - A[i];
        }
        return result;
    }
}

// Count of Elements
public class Solution{
   public int solve(int[] A){
       int result = 0;
       int max = A[0];
       for(int i = 1; i < A.length; i++){
           if(A[i] > max){max = A[i];}
       }
       for(int i = 0; i < A.length; i++){
           if(A[i] < max){result++;}
       }
       return result;
   }
}

//Second Largest

public class Solution{
    public int solve(int[] A){
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i++){
            if(A[i] > max){
                secondMax = max;
                max = A[i];
            }
            else if(A[i] > max && A[i] < secondMax){secondMax = A[i];}
        }
        return (secondMax == Integer.MIN_VALUE)? -1: secondMax;
    }
}



//---------------------------------------------------------------------




// Prefix Sum

// Range Sum Query
public class Solution{
    public long[] solve(int[] A, int[][] B){
        long[] sum = new long[A.length];
        long[] result = new long[B.length];
        sum[0] = A[0];
        for(int i = 1 ; i < A.length; i++){sum[i] += sum[i-1] + A[i];}
        for(int i = 0; i < B.length; i++){
            int l = B[i][0];
            int r = B[i][1];
            if(l >0){result[i] = sum[r]- sum[l-1];}
            else{result[i] = sum[r];}
        }
        return result;
    }
}
// Range Even Count

public class Solution{
    public int[] solve(int[] A, int[][] B){
        int[] even = new int[A.length];
        int[] result = new int[B.length];
        even[0] = ((A[0]%2 == 0)? 1: 0);
        for(int i = 1; i < A.length; i++){even[i] = even[i-1]+ ((A[i]%2==0)?1:0);}
        for(int i = 0; i < B.length; i++){
            int l = B[i][0];
            int r = B[i][1];
            if(l > 0){result[i] = even[r] - even[l-1];}
            else{result[i] = even[r];}
        }
        return result;
    }
}

// Equilibrium Index

public class Solution{
    public int solve(int[] A){
        int leftSum = 0, totalSum = 0;
        for(int i = 0; i < A.length; i++){totalSum += A[i];}
        for(int i = 0; i < A.length; i++){
            if(leftSum == totalSum - A[i]){return i;}
            leftSum += A[i];
            totalSum -= A[i];
        }
        return -1;
    }
}

// Inplace prefix Sum

public class Solution{
    public int[] solve(int[] A){
        for(int i = 1; i < A.length; i++){
            A[i] = A[i-1] + A[i];
        }
        return A;
    }
}


//---------------------------------------------------------------------



// Subarrays

// Closest Min Max

public class Solution{
    public int solve(int[] A){
        int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
        int minIndex = -1, maxIndex = -1, minLength = A.length;
        for(int i = 0; i < A.length; i++){
            if(A[i] > max){max = A[i];}
            if(A[i] < min){min = A[i];}
        }
        for(int i = 0; i < A.length; i++){
            if(A[i] == min){minIndex = i;}
            if(A[i] == max){maxIndex = i;}
            if(minIndex != -1 && maxIndex != -1){
                minLength = Math.min(minLength, Math.abs(maxIndex - minIndex)+1);
            }
        }
        return minLength;
    }
}

// Subarray in Range

public class Solution{
    public int[] solve(int[] A, int B, int C){
        int[] result = new int[C -B +1];
        for(int i = 0; i < C-B+1; i++){
            result[i] = A[B+i];
        }
        return result;
    }
}

// Generate all subarrays

public class Solution{
    public int[][] solve(int[] A){
        int n = A.length;
        int[][] result = new int[n*(n+1)/2][];
        int index=0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int[] x = new int[j-i+1];
                for(int k = 0; k < j-i+1; k++){
                    x[k] = A[i+ k];
                }
                result[index++] = x;
            }
        }
        return result;
    }
}


// special subsequence "AG"

public class Solution{
    public int solve(String A){
        int m = 1000000007;
        int countA = 0;
        int result = 0;
        for(char c : A.toCharArray()){
            if(c == 'A'){countA++;}
            else if(c == 'G'){result= (result+ countA)%m;}
        }
        return result;
    }
}


// Count subarrays

public class Solution{
    public int solve(int[] A){
        int m = 1000000007;
        int l = 0;
        int count = 0;
        int[] freq = new int[100001];
        for(int r = 0; r < A.length; r++){
            while(freq[A[r]] > 0){
                freq[A[l]]--;
                l++;
            }
            freq[A[r]]++;
            count = (count +(r-l+1))%m;
        }
        return count;
    }
}

// Best time to BUY SELL stocks

public class Solution{
    public int solve(int[] A){
        if(A.length <= 1){return 0;}
        int max = 0;
        int min = A[0];
        for(int i = 1; i < A.length; i++){
            if(A[i] < min){min = A[i];}
            max = Math.max(max, A[i] - min);
        }
        return max;
    }
}

// Pick from both sides

public class Solution{
    public int solve(int[] A, int B){
        if(B == A.length){
            int total = 0;
            for(int num : A){total+=num;}
            return total;
        }
        int front = 0;
        int back = 0;
        for(int i = 0; i < B; i++){front += A[i];}
        int maxSum = front;
        for(int i = 0; i < B; i++){
            back +=A[A.length - 1 -i];
            front -= A[B-1-i];
            maxSum = Math.max(maxSum , front + back);
        }
        return maxSum;
    }
}

// Leaders in an Array

public class Solution{
    public int[] solve(int[] A){
        int n = A.length;
        int[] leaders = new int[n];
        int count = 0;
        int maxRight = A[n-1];
        leaders[count++] = maxRight;
        for(int i = n - 2; i >=0; i--){
            if(A[i] >= maxRight){
                maxRight = A[i];
                leaders[count++] = maxRight;
            }
        }
        int[] result = new int[count];
        for(int i = 0; i < count; i++){
            result[i] = leaders[count - 1- i];
        }
        return result;
    }
}


//---------------------------------------------------------------------





// Sliding Window



//Maximum Subarray

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

// Sum of All Subarray

public class Solution{
    public long solve(int[] A){
        long totalSum = 0;
        int n = A.length;
        for(int i = 0; i < n; i++){
            int end = i +1;
            int start = n - i;
            long contribution = (long) A[i] * end * start;
            totalSum += contribution;
        }
        return totalSum;
    }
}

// Subarray with given Sum and length

public class Solution{
    public int solve(int[] A, int B, int C){
        int sum = 0;
        for(int i = 0; i < B; i++){sum += A[i];}
        if(sum == C){return 1;}
        for(int i = B; i < A.length; i++){
            sum += A[i] - A[ i-B];
            if(sum == C){return 1;}
        }
        return 0;
    }
}

// Good Subarrays

public class Solution{
    public int solve(int[] A, int B){
        int count = 0;
        for(int l = 0; l < A.length; l++){
            int sum = 0;
            for(int r = l; r < A.length; r++){
                sum += A[r];
                if((l-r+1)%2 == 0){if(sum < B){count++;}}
                else{if(sum > B){count++;}}
            }
        }
        return count;
    }
}


// Counting Subarrays

public class Solution{
    public int solve(int[] A, int B){
        int l = 0, count = 0, sum = 0;
        for(int r = 0; r < A.length; r++){
            sum += A[r];
            while(sum >= B && l <= r){
                sum -= A[l++];
            }
            count += (r-l+1);
        }
        return count;
    }
}

// Minimum Swaps

public class Solution{
    public int solve(int[] A, int B){
        int n = A.length;
        int countLessEqualB = 0;
        for(int num : A){
            if(num <= B){countLessEqualB++;}
        }
        if(countLessEqualB == 0){return 0;}
        int currentCount = 0, maxCount = 0;
        for(int i = 0; i < countLessEqualB; i++){
            if(A[i] <= B){currentCount++;}
        }
        maxCount = currentCount;
        for(int i = countLessEqualB; i < n; i++){
            if(A[i] <= B){currentCount++;}
            if(A[i - countLessEqualB] <= B){currentCount--;}
            maxCount = Math.max(maxCount, currentCount);
        }
        return countLessEqualB - maxCount;
    }
}

// Subarray with least Average

public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;

        int currentSum = 0;
        for (int i = 0; i < B; i++) {
            currentSum += A[i];
        }

        int minSum = currentSum;
        int minIndex = 0;

        for (int i = B; i < n; i++) {
            currentSum += A[i] - A[i - B];

            if (currentSum < minSum) {
                minSum = currentSum;
                minIndex = i - B + 1;
            }
        }

        return minIndex;
    }
}

//---------------------------------------------------------------------
