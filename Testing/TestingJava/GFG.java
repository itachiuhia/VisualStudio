in java n worker with strenght wi m tasks are pending each task is assigned 
to 1 worker and strenghts si is required bob has k magical pills 
taking magical pills will increase the strength of a worker by b
 using determine the maximum number of tasks that can be completed



// class GFG
// {
   
//   static int MAX = 100005;
 
//   // Segment tree implemented as an array
//   static int tree[] = new int[MAX << 2];
 
//   // Function to build segment tree
//   static void build(int node, int start,
//                     int end, int arr[], int k)
//   {
//     if (start == end) {
//       tree[node] = arr[start] % k;
//       return;
//     }
//     int mid = (start + end) >> 1;
//     build(2 * node, start, mid, arr, k);
//     build(2 * node + 1, mid + 1, end, arr, k);
//     tree[node] = (tree[2 * node] * tree[2 * node + 1]) % k;
//   }
 
//   // Function to query product % k
//   // of sub-array[l..r]
//   static int query(int node, int start, int end, int l, int r, int k)
//   {
//     if (start > end || start > r || end < l)
//       return 1;
//     if (start >= l && end <= r)
//       return tree[node] % k;
//     int mid = (start + end) >> 1;
//     int q1 = query(2 * node, start, mid, l, r, k);
//     int q2 = query(2 * node + 1, mid + 1, end, l, r, k);
//     return (q1 * q2) % k;
//   }
 
//   // Function to return the count of sub-arrays
//   // whose product is divisible by K
//   static int countSubarrays(int arr[], int n, int k)
//   {      
//     int ans = 0;      
//     for (int i = 0; i < n; i++)
//     {
//       int low = i, high = n - 1;
 
//       // Binary search
//       // Check if sub-array[i..mid] satisfies the constraint
//       // Adjust low and high accordingly
//       while (low <= high)
//       {
//         int mid = (low + high) >> 1;
//         if (query(1, 0, n - 1, i, mid, k) == 0)
//           high = mid - 1;
//         else
//           low = mid + 1;
//       }
//       ans += n - low;
//     }
//     return ans;
//   }
 
//   public GFG(){
//         System.out.println("Hello world");
//   }
  
//   // Driver code


//   public static void main(String[] args)
//   {
//     int arr[] = { 6, 2, 8 };
//     int n = arr.length;
//     int k = 4;
 
//     // Build the segment tree
//     build(1, 0, n - 1, arr, k);
//     System.out.println(countSubarrays(arr, n, k));
//   }
// }