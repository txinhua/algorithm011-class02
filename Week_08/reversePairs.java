class Solution {
    public void merge(int[] A, int start, int mid, int end)
    {
        int n1 = (mid - start + 1);
        int n2 = (end - mid);
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++)
            L[i] = A[start + i];
        for (int j = 0; j < n2; j++)
            R[j] = A[mid + 1 + j];
        int i = 0, j = 0;
        for (int k = start; k <= end; k++) {
            if (j >= n2 || (i < n1 && L[i] <= R[j]))
                A[k] = L[i++];
            else
                A[k] = R[j++];
        }
    }

    public int mergesort_and_count(int[] A, int start, int end)
    {
        if (start < end) {
            int mid = (start + end) / 2;
            int count = mergesort_and_count(A, start, mid) + mergesort_and_count(A, mid + 1, end);
            int j = mid + 1;
            for (int i = start; i <= mid; i++) {
                while (j <= end && A[i] > A[j] * 2L){
                    j++;
                }
                count += j - (mid + 1);
            }
            merge(A, start, mid, end);
            return count;
        }
        else
            return 0;
    }

    public int reversePairs(int[] nums) {
        return mergesort_and_count(nums,0,nums.length -1);
    }
}
