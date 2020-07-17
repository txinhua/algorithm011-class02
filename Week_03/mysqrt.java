class Solution {
    int mysqrt(int x) {
        float tmpx = (float) x;
        float xhalf = 0.5f * tmpx;
        int i =*(int*)&tmpx;
        i = 0x5f375a86 - (i >> 1);
        tmpx =*(float*)&i;
        tmpx = tmpx * (1.5f - xhalf * tmpx * tmpx);
        tmpx = tmpx * (1.5f - xhalf * tmpx * tmpx);


        int res = (int) (1.0 / tmpx);
        if ((res + 1) * (res + 1) <= x)
            res += 1;
        return res;
    }

    public static int mysqrt(int x){
        double tmpx = x;
        double k = 1.0;
        double k0 = 0.0;
        while(Math.abs(k0-k) >= 1){
            k0 = k;
            k = (k + tmpx/k)/2;
        }
        return (int)k;
    }
}

// 牛顿迭代法求解平方根
