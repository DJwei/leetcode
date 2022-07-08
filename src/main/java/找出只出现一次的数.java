import java.util.*;

/**
 * 利用排序，然后两两比较，只要不匹配就输出，时间复杂度高了
 */
class Test40 {
    public static void main(String[] args) {
        int[] nums = {7,0,5,0,2,2,5};
        Test40 test40 = new Test40();
        System.out.println(test40.singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int n=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;n++){ //1,1,2,2,3,4,4
            if(i==nums.length-1){
                n=nums[nums.length-1];
                break;
            }
            if(nums[i]!=nums[i+1]){
                n = nums[i];
                break;
            }
            i = i+2;
        }
        return n;
    }
}

/**
 * 利用哈希方法
 */
class Test40_1{
    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hashMap.get(nums[i])!=null){
                hashMap.remove(nums[i]);
            }
            else hashMap.put(nums[i],1);
        }
       return hashMap.keySet().iterator().next();
        //return hashMap.get(0);
    }
}

/**
 * 利用位运算
 */
class Test40_2{
    public static void main(String[] args) {
       // int[] nums = {4,4,4,1,5,1,2,2,2,5,1};
        int[] nums = {4,1,5,1,2,2,5};
        Test40_2 test40 = new Test40_2();
        System.out.println(test40.singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum ^= num;//00,01,10,11,100,101,110,111
        }
        return sum;
    }
}

/**
 * 利用链表思想
 */
class Test40_4{
    public static void main(String[] args) {
        int[] nums = {9,2,3,41,2,3,9};
        Test40_4 test40_4 = new Test40_4();
        System.out.println(test40_4.singleNumber(nums));
    }
    public int singleNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(Integer num : nums){
            if(list.contains(num)){//boolean contains(Object o);
                list.remove(num);
            }
            else list.add(num);
        }
        return list.get(0);//list.iterator().next();
    }
}

/**
 * 利用set思想
 */
class Test40_5{
    public static void main(String[] args) {
        int[] nums = {9,2,3,4,2,3,9};
        System.out.println(new Test40_5().singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int numsum = 0;
        int setsum = 0;
        for(int num : nums){
            numsum += num;
            set.add(num);
        }
        for(int num : set){
            setsum += num;
        }
        return 2*setsum-numsum;
        /*Set<Integer> set = new HashSet<>();
        for(int i : nums){
            if(set.contains(i)){
                set.remove(i);
            }
            else {
                set.add(i);
            }
        }
        return set.iterator().next();*/
    }
}

/**
 * 求出现为奇数次的两个数
 * 利用位运算
 */
class Test400_3{
    public static void main(String[] args) {
        //int[] nums = {4,3,5,3,2,2,5};
        int[] nums = {4,4,4,1,5,1,2,2,2,5,1};
        Test400_3 test40 = new Test400_3();
        for(int i : test40.singleNumber(nums)){
            System.out.println(i);
        }
        //Integer[] aa = nums;
        System.out.println(Arrays.asList(test40.singleNumber(nums)));

    }

    public int[] singleNumber(int[] nums) {
         int[] resArray = new int[2];
        int eor = 0;
        for (int i: nums) {
            eor ^= i;
        }
        // eor取反加一，然后和eor自身进行与运算，结果会把eor二进制格式的最右边的1保留，其余位变成0
        // 1001110001000运算后是
        // 0000000001000
        int rightZero = eor & (~eor + 1);
        int first = 0;
        for (int i: nums) {
            // 以此条件进行区分，把所求的两个数区分成两组，
            if ((i & rightZero) == rightZero) {
                first ^= i; // 筛选
            }
        }
        resArray[0] = first;
        resArray[1] = eor ^ first; // eor ^ first结果就是第二个数
        return resArray;
    }
}

