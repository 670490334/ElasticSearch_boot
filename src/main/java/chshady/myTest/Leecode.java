package chshady.myTest;

import java.util.HashMap;

/**
 * @Author 廖凡
 * @Date 2019/8/30 15:01
 */
public class Leecode {
    public void leecoode001(){

        int target = 9;
        int nums [] = new int [] {2,9,11,15};
        System.out.println(twoSum(nums,target));
    }
    /**
     * 第一题
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums.length<2){
            return new int[] {-1,-1};
        }
        HashMap<Integer,Integer> map = new HashMap();
        int [] res = new int []{-1,-1};
        for (int i =0;i<nums.length;i++){

            if (map.containsKey(target - nums[i])){
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            map.put(nums[i],i);
        }
        return res;
    }
}
