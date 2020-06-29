public class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length; //如果要移动的元素个数是数组长度的整数倍则不需要挪动
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
}


// 开始循环后将相同步长的的都做一遍
