class Test25 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,-5,-1,2,1,-5,4};
        Test25 test25 = new Test25();
        System.out.println(test25.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int n = 0;int m = nums[0];
        for(int i=0;i<nums.length;i++){
            n = Math.max(n+nums[i],nums[i]);//-2,1,-3,2,-1,2,1,-5,4
            m = Math.max(n,m);
        }
        return m;
    }
}
