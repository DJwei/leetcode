import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Test30{
    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> reuslt = new ArrayList<>();
        int n = target;
        int[] nums = candidates;
        Arrays.sort(nums);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(i,nums[i]);
        }
        for(int i=0;i<100;i++){//1,2,3,4,5      4    1111 112 22 13 4
            List<Integer> list = new ArrayList<>();
            if (n-nums[i]>=nums[i]){
                n = n - nums[i];
                list.add(nums[i]);
                int end = n;
                if(map.containsValue(end)) {
                    list.add(end);
                    //list.get()
                    n = n - end;
                }
                if(n == 0)break;
            }
            reuslt.add(list);
            list.removeAll(list);
        }
        return null;
    }
}

class Test30_1{
    public static void main(String[] args) {
        Test30_1 test30_1 = new Test30_1();
        int[] candidates = {2,3,5}; int target = 8;
        System.out.println(test30_1.combinationSum(candidates,target));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int[] nums = candidates;
        int sum = target;
        int n = 0;
        int m = 0;
        for(int i=0;i<nums.length;i++){
            while (n<sum) {
                n += nums[i];
                m++;
            }
            if(nums[i]*m==sum){
                for(int k=m;k>0;k--) {
                    list.add(nums[i]);
                }
            }else if(nums[i]*m<sum){
                
            }
        }
        return result;
    }
}
