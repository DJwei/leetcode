import java.math.BigDecimal;

/**
 * 利用BigDecimal这个数据类型来解决
 * 无法解决大幂
 */
class Test31{
    public static void main(String[] args) {
        Test31 test31 = new Test31();
        double x = 1.00123;
        int n = 4;
        Long Start = System.currentTimeMillis();
        System.out.println(test31.myPow(x,n));
        Long End = System.currentTimeMillis();
        System.out.println(End-Start);
    }
    public double myPow(double x, int n) {
        String x11 = "";
        if (n>0) {
            x11 = "" + x;
        }else{
            x11 = String.valueOf(1/x);
        }
        BigDecimal x1 = new BigDecimal(x11);
        BigDecimal x2 = new BigDecimal(x11);

        if(n==1)return x;
        if(n==0)return 1.0;
        while (n>1){
            x1 = x1.multiply(x2);
            n--;
        }
        while (n<-1){
            x1 = x1.multiply(x2);
            n++;
        }
        return x1.doubleValue();
    }
}

class Test31_1{
    public static void main(String[] args) {
        Test31_1 test31_1 = new Test31_1();
        double x = 2;
        int n = -124234;
        System.out.println(test31_1.myPow(x,n));
    }
    public double myPow(double x, int n) {
        double xx = 0;
        if(n>0){
            xx = x;
        }else {
            xx = 1/x;
        }
        if(n==0) return 1.0;
        if(n==1)return x;
        double x1 = xx;
        double x2 = xx;
        while (n>1){
            x1 = x1*x2;
            n--;
        }
        while (n<-1){
            x1 = x1*x2;
            n++;
        }
        return x1;
    }
}

/***
 * 最优解：递归算法拆分为二分
 */
class Test31_2{
    public static void main(String[] args) {
        Test31_2 test31_2 = new Test31_2();
        long start = System.currentTimeMillis();
        System.out.println(test31_2.myPow(2,4));
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }
}
