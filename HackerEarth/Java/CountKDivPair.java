package Java;

public class CountKDivPair {

    static int countKdivPair(int[] a, int n, int k){
        int freq[] = new int[k];

        for(int i =0; i< n;i++){
            ++freq[a[i]%k];

        }

        int sum = freq[0] * (freq[0] -1)/2;

        for(int i =1; i<=k/2 && i!= (k-i); i++){
            sum += freq[i]*freq[k-i];          

        }
        if(k%2 == 0)
            sum += (freq[k/2]*(freq[k/2] -1)/2);
        return sum;
    }
    public static void main(String[] args) {
        int A[] = {2, 2, 1, 7, 5, 3 };
        int n = 6;
        int k = 4;
        System.out.println(countKdivPair(A, n, k));
    }
}
