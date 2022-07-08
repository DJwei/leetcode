

/**
 * 不是最优解
 * 利用数字-->String-->数组(做交换位置操作)-->stringBuilder(来接收数字)-->String-->int
 */
class Test36 {
    public static void main(String[] args) {
        Test36 test36 = new Test36();
        int x = 2147483647;
       // int x = -0;
        System.out.println(test36.reverse(x));
    }

    public int reverse(int x) {
        //如果x超出int的边界,我们要用long来接收
        long x4 = x;
        //用xxx来接收绝对值x
        long xxx = Math.abs(x4);
        String xx = String.valueOf(xxx);

        //创建接收字符串的数组
        int[] nums = new int[xx.length()];

        //把xx字符串变为数组
        for(int i=0;i<xx.length();i++){
            nums[i] = xx.charAt(i)-'0';
        }

        //对nums数组进行反转
        for(int i=0;i<xx.length()/2;i++){
            int n =0;
            n = nums[i];
            nums[i] = nums[nums.length-1-i];
            nums[nums.length-1-i] = n;
        }

        //把反转后的数组变为字符串
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<xx.length();i++){
              stringBuilder.append(nums[i]);
        }
        xx = stringBuilder.toString();
        //if(Long.valueOf(xx)>2147483647||0-Long.valueOf(xx)<-2147483647) return 0;

        if(x>0&&Long.valueOf(xx)<2147483647) {
            return Integer.valueOf(xx);
        }
        else if(x<0&&0-Long.valueOf(xx)>-2147483647){
            return 0-Integer.valueOf(xx);
        }
        else return 0;
    }
}

/**
 * 最优解时间复杂度为O(N)
 * 利用回文数字的思想参考Test2
 */
class Test36_1{
    public static void main(String[] args) {
        Test36_1 test36_1 = new Test36_1();
        int x = 2147483647;
        System.out.println(test36_1.reverse(x));
    }

    public int reverse(int x){//2147483647
        long xx = 0L;
        int xxx = 0;
        while (x!=0){
            xxx = x % 10;
            xx = xx * 10 + xxx;
            x = x / 10;
        }
        if(xx>2147483647||xx<-2147483647) return 0;
        else return (int)xx;
    }
}
