import java.util.Arrays;

/**
 * 写出来了，但是过不了。
 */
class Test33 {
    public static void main(String[] args) {
        Test33 test33 = new Test33();
         int[] nums = {0,2,1,1,0,0,2,1,1,2};
       // System.out.println(test33.sortColors(nums));
       test33.sortColors(nums);
    }

    public void sortColors(int[] nums) {
            int[] result = new int[nums.length];
            int m = 0;
            for(int i=0;i<result.length;i++){
                if(result[i]==nums[i]){
                    m++;
                }
            }
            int n = nums.length;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==2){
                    result[n-1] = 2;
                    n--;
                    continue;
                }
                if(nums[i]==1){
                    result[m] = 1;
                    m++;
                    continue;
                }
            }
            nums = result;
            System.out.println(Arrays.toString(nums));
        }
}

/**
 * 可以通过，正确解答
 */
class Test33_1{
    public static void main(String[] args) {
        Test33_1 test33_1 = new Test33_1();
        int[] nums = {2,0,2,1,1,0};
        test33_1.sortColors(nums);
    }

    public void sortColors(int[] nums) {
        int n = nums.length;
        int ptr = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
        for (int i = ptr; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}

class Test33_2{
    public static void main(String[] args) {
        Test33_2 test33_2 = new Test33_2();
        int[] nums = {2,0,2,1,1,0};//{0,2,1,1,0,0,2,1,1,2,0};//2,0,2,1,1,0
        test33_2.sortColors(nums);
    }

    public void sortColors(int[] nums) {
        int[] result = new int[nums.length];
        int m = 0;
        for(int i=0;i<result.length;i++){
            if(result[i]==nums[i]){
                m++;
            }
        }
        int m1 = m;
        int n = nums.length;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==2){
                nums[n-1] = 2;
                if(i<n) {
                    nums[i] = 0;
                }else {
                    i++;
                }
                n--;
                continue;
            }
            if(nums[i]==1){
                nums[m1] = 1;
                if(i<m) {
                    nums[i] = 0;
                }else {
                    i++;
                }
                m1++;
                continue;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}