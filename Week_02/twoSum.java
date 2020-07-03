//PNO 1
class Solution {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mapNumsIndex = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++){
            Integer targetIndex = mapNumsIndex.get(target - nums[i]);
            if (targetIndex == null){
                mapNumsIndex.put(nums[i],i);
            }else if(targetIndex != i){
                return new int[]{targetIndex,i};
            }
        }
        return null;
    }
}