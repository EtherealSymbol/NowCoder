
import java.util.*;

public class NC208 {

    public static int[] temperatures (int[] dailyTemperatures) {
        int len = dailyTemperatures.length;
        int[] dp = new int[len];
        Stack<Integer> s = new Stack<>();//存储下标
        for (int i = 0; i < len; i++) {
            if (s.isEmpty()){
                s.add(i);
            }else {
                while(!s.isEmpty() && dailyTemperatures[s.peek()] < dailyTemperatures[i]){ // 当天气温大于栈顶元素
                    dp[s.peek()] = i-s.peek();
                    s.pop();
                }
                s.add(i);

            }
        }

        return dp;
    }

    public static void main(String[] args) {
//        int[] nums = {2,4,5,9,10,0,9};
        int[] nums = {3,1,4};
        for (int i: nums) {
            System.out.print(i+" ");
        }
        System.out.println();
        int[] res= temperatures(nums);
        for (int i: res) {
            System.out.print(i+" ");
        }
    }
}
