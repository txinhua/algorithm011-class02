package example;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by tangguifu on 2020/7/1.
 */
@WebService()
public class HelloWorld {
  @WebMethod
  public String sayHelloWorldFrom(String from) {
    String result = "Hello, world, from " + from;
    System.out.println(result);
    return result;
  }

  private static boolean isAnagram(String s, String t) {
    if (s.length() != t.length()){
      return false;
    }
    char[] s1 = s.toCharArray();
    char[] t1 = t.toCharArray();
    Arrays.sort(s1);
    System.out.println(s1);
    Arrays.sort(t1);
    System.out.println(t1);
    return  Arrays.equals(s1,t1);
  }

  private static boolean isAnagramHashMap(String s, String t) {
    if (s.length() != t.length()){
      return false;
    }
    HashMap<String,Integer> map = new HashMap<String,Integer>();
    for(int i = 0;i < s.length(); i++){
      String s1 = String.valueOf(s.charAt(i));
      Integer counts1 = map.get(s1) != null ? map.get(s1) : Integer.valueOf(0);
      counts1 ++;
      map.put(s1,counts1);
    }
    for(int i = 0;i < t.length();i++){
      String t1 = String.valueOf(t.charAt(i));
      Integer countT1 = map.get(t1);
      if (countT1 == null){
        return false;
      }
      countT1 --;
      if( countT1.intValue() < 0){
        return false;
      }else{
        map.put(t1,countT1);
      }
    }
    return true;
  }


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

    private static List<Integer> list = new ArrayList<>();

    private static class ThreadOne extends Thread {
      public void run() {
        Iterator<Integer> integerIterator = list.iterator();
        while (integerIterator.hasNext()) {
          int i = integerIterator.next();
          System.out.println("Thread one run :" + i);
          try {
            Thread.sleep(10);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }

    private static class ThreadTwo extends Thread {
      public void run() {
        for (int i = 0; i < 10; i++) {
          System.out.println("Thread Two run:" + i);
          if (i == 3) {
            list.remove(3);
          }
        }
      }
    }

  public static int lastStoneWeight(int[] stones) {
    if (stones.length == 0) return 0;
    if(stones.length == 1) return stones[0];
    int[] arr = new int[]{1001};
    for (int i : stones){
      arr[i] ++;
    }
    int j = 1000;
    int j_next;
    while(j >= 0){
      arr[j] %= 2;
      if (arr[j] == 0){
        j--;
        continue;
      }else {
        j_next = j - 1;
        while (j_next >= 0 && arr[j_next] == 0){
          j_next --;
        }
        if (j_next < 0){
          break;
        }else {
          arr[j - j_next] ++;
          arr[j_next]--;
          j--;
        }
      }
    }
    return Math.max(j,0);
  }

  public static int nthUglyNumber(int n) {
    int[] dp = new int[1690];
    dp[0] = 1;
    int a = 0,b = 0,c = 0;
    for(int i = 1;i < n + 1;i++){
      dp[i] = Math.min(Math.min(dp[a]*2,dp[b]*3),dp[c]*5);
      System.out.println(a);
      System.out.println(b);
      System.out.println(c);
      System.out.println(i);
      System.out.println(dp[i]);
      System.out.println(";");
      if(dp[i] == dp[a]*2){
        a++;
      }else if(dp[i] == dp[b]*3){
        b++;
      }else{
        c++;
      }
    }
    return dp[n];
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

  public static int search(int[] nums, int target) {
    if (nums.length == 0) return -1;
    int left = 0;
    int right = nums.length;
    int mid = left + (right- left)/2;
    while (nums[mid] != target && left < right){
      if (nums[mid] > target){
        if (nums[mid] > nums[left]){
          left = mid;
        }else {
          right = mid;
        }
      }else {
          left = mid;
      }
      mid = left + (right- left)/2;
    }
    return (nums[mid] == target) ? mid : -1;
  }
  // test the solutions
  public static void main(String[] argv) {
    System.out.println("the sqrt result" + (int)mysqrt(4));
  }

}



