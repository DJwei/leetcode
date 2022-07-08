import java.util.*;

/**
 * 时间复杂度过高
 */
class Test41 {
     public static void main(String[] args) {
         //int[] nums = {1,3,2,5,7,8,9,10};
        // int[] nums = {0,0,0};
         int[] nums = {-2,-3,-3,7,-3,0,5,0,-8,-4,-1,2};
         System.out.println(new Test41().longestConsecutive(nums));
     }

    public int longestConsecutive(int[] nums) {
        if(nums.length==0)return 0;
        Arrays.sort(nums);
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int result = 1;
        int n = 0;
        int i =0;
        for(int u=0;u<nums.length;u++){
            hashMap.put(u,nums[u]);
        }
       while ( i<=nums.length-1){
            while (i<nums.length-1&&hashMap.get(i)==hashMap.get(i+1)){
                hashMap.remove(i);
                i++;
            }
            if(i<nums.length-1&&hashMap.get(i)+1==hashMap.get(i+1)){
                n++;
                result = Math.max(result,n+1);
                i++;
            }
            else {
                n=0;
                i++;
            }
        }
        return result;
    }
}

class Test41_1{
    public static void main(String[] args) {
        int[] nums = {1,3,2,5,7,8,9,10};
        //int[] nums = {-6,-1,-1,9,-8,-6,-6,4,4,-3,-8,-1};
        //int[] nums = {};
        System.out.println(new Test41_1().longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        if(nums.length==0)return 0;
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        Integer[] nums1 = set.toArray(new Integer[0]);
        Arrays.sort(nums1);
        if(nums1.length==1)return 1;
        int result = 1;
        int n=0;
        int i=0;
        while (i<nums.length){
            if(i<nums1.length-1&&nums1[i]+1==nums1[i+1]){
                n++;
                result = Math.max(result,n+1);
                i++;
            }
            else {
                i++;
                n = 0;
            }
        }
        return result;
    }
}

/**
 * 不用Arrays.sort()方法来做
 */
class Test41_2{
    public static void main(String[] args) {
        int[] nums = {3,1,2,5,7,8,9,10};
        //int[] nums = {-6,-1,-1,9,-8,-6,-6,4,4,-3,-8,-1};
        //int[] nums = {0,0};
        System.out.println(new Test41_2().longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        int length = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i : nums){
            hashSet.add(i);
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int crr = nums[i];
            int crrlength = 1;
            if(!hashSet.contains(crr-1)){
                while(hashSet.contains(crr+1)){
                    crrlength++;
                    crr++;
                }
            }
            length = Math.max(crrlength,length);
        }
        return length;
    }
}
