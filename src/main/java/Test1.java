import java.util.HashMap;

public class Test1 {
    public static void main(String[] args) {
        int[] input = {1,2,3,3,15,9};
        int target = 6;
        String a = "1232";
        System.out.println(a.substring(a.length()-3));

        long startTime = System.currentTimeMillis();
        Test1 test = new Test1();
        int[] output = test.twoSum(input,target);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
        System.out.println(test.twoSum(input,target));
        for(int index: output ){
            System.out.println(index + "\t");
        }
    }
    public int[] twoSum(int[] nums, int target)  {
        int n = nums.length;
     HashMap<Integer,Integer> Map = new HashMap<>();
     for(int i=0;i<n;i++){
         int j = target - nums[i];
         if(Map.containsKey(j))
             return new int[]{Map.get(j),i};
         Map.put(nums[i],i);
     }
     throw new IllegalArgumentException("找不到");
    }
}