

/**
 * 递归思想，但是时间太长了
 */
 class Test32 {
     public static void main(String[] args) {
         Test32 test32 = new Test32();
         long start = System.currentTimeMillis();
         System.out.println(test32.climbStairs(20));
         long end = System.currentTimeMillis();
         System.out.println(end-start);
     }

     public int climbStairs(int n) {
         //if(n>44) return 11111;
         if(n==1){
             return 1;
         }
         if(n==2){
             return 2;
         }
         return climbStairs(n-1)+climbStairs(n-2);
     }
}

/**
 * 利用滑块替代思想,时间复杂度为常数0
 */
class Test32_1{
    public static void main(String[] args) {
       Test32_1 test32_1 = new Test32_1();
        long start = System.currentTimeMillis();
        System.out.println(test32_1.climbStairs(20));
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public long climbStairs(int n) {
        long p = 0;
        long q = 0;
        long sum = 1;
        for(int i=1;i<=n;i++){
            p = q;
            q = sum;
            sum = p+q;
        }
        return sum;
    }
}