class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0){
            return null;
        }
        int size = digits.length - 1;
        int lastValue = digits[size--] + 1;
        while(lastValue % 10 == 0){
            digits[size + 1] = 0;
            if(size >= 0){
                lastValue = digits[size--] + 1;
            }else{
                digits = new int[digits.length + 1];
                lastValue = 1;
            }
        }
        digits[size+1] = lastValue;
        return digits;
    }
}