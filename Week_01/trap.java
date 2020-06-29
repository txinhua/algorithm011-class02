class Solution {
    public int trap(int[] height) {
        //双指针法
        int rains = 0;
        int left = 0, right = height.length - 1;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if(height[left] >= left_max){
                    left_max = height[left];
                }else{
                    rains += (left_max - height[left]);
                }
                ++left;
            } else {
                if(height[right] >= right_max){
                    right_max = height[right];
                }else{
                    rains += (right_max - height[right]);
                }
                --right;
            }
        }
        return rains;
    }
}
