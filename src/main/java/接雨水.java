import sun.nio.cs.ext.MacArabic;

/**
 * 测试用例4,2,0,3,2,5不可以通过，思路有问题，不可以用三者之间取低者的思路
 */
class Test28 {
    public static void main(String[] args) {
        //int[] height = {0,1,0,2,1,0,1};//1,3,2,1,2,1};4,2,0,3,2,5
        //int[] height = {0,1,0,2,1,0,1,3};
        //int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        //int[] height = {1,0,1,3,2,1,2,1};
        int[] height = {4,2,0,3,2,5};
        Test28 test28 = new Test28();
        System.out.println(test28.trap(height));
    }
    public int trap(int[] height) {
        int sum = 0;
        for(int i=0;i<height.length;i++){
            if(height[i]==0){
                continue;
            }
            if (height[i]<height[i+1]){
                i++;
            }
            int j = i;
            while (j<height.length&&height[i]>=height[j]) {
                //sum = height[i] - height[j] + sum;
                j++;//0,1,0,2 ,1,0,1,3, 2,1,2,1
                if(height[j]>height[j-1]){//4,2,0,3,2,5
                    if(height[j]>height[i]||j==height.length-1||height[j]>height[j+1])
                       // sum = sum + height[i]-height[j];
                        //height[j] = height[i];
                      break;
                }
                if(j == height.length-1)break;
            }
            int n = 0;

            if(j<height.length) {
                 n = height[i] < height[j] ? i : j;
            }else {
                  n = height[i]<height[j]?i:j-1;
            }

            if(n==i&&height[j]>height[j-1]){
                for(n=i;n<j-1;n++){
                    if(height[i]>=height[n+1]) {
                        sum = height[i] - height[n + 1] + sum;
                    }else break;
                }
            }else if(n==j&&height[j]>height[j-1]){
                for(n=j;n>i;n--){
                    if(height[j]>=height[n-1]) {
                        sum = height[j] - height[n - 1] + sum;
                    }else break;
                }
            }
            i = j-1;
            if(j==height.length-1)break;
        }
        return sum;
    }
}


/**
 * 改进思路，用双指针，两个进行比较
 */
class Test28_1{
    public static void main(String[] args) {
        Test28_1 test28_1 = new Test28_1();
        int[] height = {2,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(test28_1.trap(height));
    }

    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int maxLeft = height[l], maxRight = height[r];
        int ans = 0;

        while (l < r) {
            if (maxLeft <= maxRight) {
                maxLeft = Math.max(maxLeft, height[++l]);
                ans += maxLeft - height[l];
            } else {
                maxRight = Math.max(maxRight, height[--r]);
                ans += maxRight - height[r];
            }
        }
        return ans;
    }
}

/**
 * 依次遍历寻找
 */
class Test28_2{
    public static void main(String[] args) {
        Test28_2 test28_2 = new Test28_2();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(test28_2.trap(height));
    }

    public int trap(int[] height) {
        int sum = 0;
        for(int i=1;i<height.length;i++){
            int lp = 0;
            int rp = 0;
            for(int j=i;j>=0;j--){
                if(lp<height[j]) {
                    lp = height[j];
                }
            }
            for(int j=i;j<height.length;j++){
                if(rp<height[j]){
                    rp = height[j];
                }
            }
            int s = Math.min(lp,rp)-height[i];
            sum = sum + s;
        }
        return sum;
    }
}
