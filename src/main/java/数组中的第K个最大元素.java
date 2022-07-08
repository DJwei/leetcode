import java.util.Arrays;

class Test45 {
    public static void main(String[] args) {
        Test45 test45 = new Test45();
        //int[] nums = {4,5,5,3,2,3,1,2,6};
        int[] nums = {3,2,1,5,6,4};
        Long start = System.currentTimeMillis();
        System.out.println(test45.findKthLargest(nums,4));
        Long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
    //3,2,1,5,6,4 //2,1,3,5,6,4 //2,1,3,5,4,6 //1,2,3,4,5,6
    public int findKthLargest(int[] nums, int k) {
        /*Arrays.sort(nums);
        return nums[nums.length+1-k];*/
        //3,2,1,5,6,4 //2,1,3,5,6,4 //2,1,3,5,4,6 //1,2,3,4,5,6
        for(int i=0;i<nums.length;i++){
            int j = i+1;
            while (nums[i]>nums[j]&&j<nums.length){
                j++;
            }
            if(nums[i]<nums[j]&&j<nums.length) {
                int temp = nums[i];
                nums[i] = nums[j - 1];
                nums[j - 1] = temp;
                i = j - 1;
            }
        }
        return nums[nums.length-k];
    }
}
