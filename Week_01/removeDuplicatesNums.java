class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int j = 1; j < nums.length; j++){
            if(nums[i] != nums[j]){
                nums[++i] = nums[j];
            }
        }
        return ++i;
    }
}

//我觉得题解中提到的优化是没有必要的,因为如果是相同位置的交互的化,计算机应该也不会做复写等操作,因为同一个位置的对象的地址是一样的.不知道这么理解是否正确?