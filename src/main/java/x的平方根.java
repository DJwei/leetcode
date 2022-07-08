/**
 * 循环遍历
 */
class Test23 {
    public static void main(String[] args) {
        Test23 test23 = new Test23();
        System.out.println(test23.mySqrt(11));
    }

    public int mySqrt(int x) {
        int sum = 1;
        if(x==0)return 0;
        if(x==1)return 1;
        if(x>=2147395600)return 46340;
        for(int i=1;i<x;i++){
            int sum1 = 0;
            int sum2 = 0;
            if(i==1) {
                sum2 = (2 * (i - 1) + 1);
            }else {
                sum2 = sum;
            }
            sum1 =  (2*i+1)+sum2;
            if(sum1>x){
                return i;
            }
            sum = sum1;
        }
        return -1;
    }
}

/**
 * 调用数学方法
 */
class Test23_1{
    public static void main(String[] args) {
        Test23_1 test23_1 = new Test23_1();
        System.out.println(test23_1.mySqrt(10989223));
    }
    public int mySqrt(int x) {
        return x = (int)Math.sqrt(x);
    }
}

/**
 * 利用二分查找方法
 */
class Test23_2{
    public static void main(String[] args) {
        Test23_2 test23_2 = new Test23_2();
        System.out.println(test23_2.mySqrt(234));
    }
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}

/**
 * 二分查找法
 */
class Test23_3{
    public static void main(String[] args) {
        Test23_3 test23_3 = new Test23_3();
        System.out.println(test23_3.mySqrt(10));
    }

    public int mySqrt(int x) {
        long i = x;
        while (i * i > x)
            i = (i + x / i) / 2;
        return (int)i;
    }
}
