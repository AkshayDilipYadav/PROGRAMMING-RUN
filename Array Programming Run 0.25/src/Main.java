// Introduction to Problem Solving

// Count Factor
public class Solution{
    public int solve(int A){
        int result = 0;
        for(int i = 1; i*i <= A; i++){
            if(A%i == 0){
                if(i == A/i){result++;}
                else{result += 2;}
            }
        }
        return result;
    }
}
// Is Prime
public class Solution{
    public int solve(int A){
        if(A <= 1){return 0;}
        for(int i = 2; i*i <= A; i++){
            if(A % i == 0){return 0;}
        }
        return 1;
    }
}

// Perfect Number
public class Solution{
    public int solve(int A){
        if(A <= 1){return 0;}
        int factorSum = 1;
        for(int i = 2; i*i <= A; i++){
            if(A % i ==0){factorSum += i + A/i;}
        }
        if(factorSum == A){return 1;}
        else{return 0;}
    }
}
// Count Prime

public class Solution{
    public boolean isPrime(int A){
        if(A <= 1){return false;}
        for(int i = 2; i*i <= A; i++){
            if(A % i == 0){return false;}
        }
        return true;
    }
    public int solve(int A){
        int count = 0;
        for(int i = 1; i*i <= A; i++){
            if(isPrime(i)){count++;}
        }
        return count;
    }
}

//----------------------------------------------------------------------------

// Introduction to Arrays

// Good Pair
public class Solution{
    public int solve(int[] A, int B){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ;i < A.length; i++){
            if(set.contains(B - A[i])){return 1;}
            set.add(A[i]);
        }
        return 0;
    }
}
// Reverse in a range
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
            result[(i+B) % A.length]=A[i];
        }
        return result;
    }
}
// Max Min of an Array
public class Solution{
    public int solve(int[] A){
        int min = A[0];
        int max = A[0];
        for(int i = 1; i< A.length; i++){
            if(A[i]<min){min = A[i];}
            else if(A[i]>max){max = A[i];}
        }
        return min + max;
    }
}
// Linear Search
public class Solution{
    public int solve(int[] A, int B){
        int count = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i]== B){count++;}
        }
        return count;
    }
}
// time to equality
public class Solution{
    public int solve(int[] A){
        int max = A[0];
        int result = 0;
        for(int i = 1; i < A.length; i++){
            if(A[i]> max){max = A[i];}
        }
        for(int i = 0; i < A.length; i++){
            result += max - A[i];
        }
        return result;
    }
}
// count of elements
public class Solution{
    public int solve(int[] A){
        int count = 0;
        int max = A[0];
        for(int i = 1; i < A.length; i++){
            if(A[i]> max){max = A[i];}
        }
        for(int i = 0; i < A.length; i++){
            if(A[i]< max){count++;}
        }
        return count;
    }
}
// second largest

public class Solution{
    public int solve(int[] A){
        if(A.length < 2){return -1;}
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i++){
            if(A[i]> max){
                secondMax = max;
                max = A[i];
            }
            else if(A[i]>secondMax && A[i]< max){secondMax = A[i];}
        }
        return (secondMax == Integer.MIN_VALUE) ? -1 : secondMax;
    }
}










