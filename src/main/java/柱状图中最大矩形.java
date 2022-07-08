import java.util.Arrays;

/**
 * 最大矩阵,错误解法
 */
class Test44 {
    public static void main(String[] args) {
        Test44 test44 = new Test44();
        int[] heigths = {2,1,5,6,2,3};
        //int[] heigths = {2,4};
        //int[] heigths = {1,4,6,2,0,7};
        System.out.println(test44.largestRectangleArea(heigths));
    }

    public int largestRectangleArea(int[] heights) {
        int n = 0;
        int m = heights.length-1;
        int l = heights[0];
        int sum = 0;
        while (n<m){
            if(heights[n]<=heights[m]){
                int k = 0;
                for(int i=n;i<m;i++) {
                    l = Math.min(l,heights[i]);
                    if(l==0)break;
                    k++;
                }
                sum = Math.max(l*(m+1-n),sum);
                n = k+1;
                if(n<heights.length) {
                    l = heights[n];
                }
                if(n+1==m)break;
            }
            if(heights[n]>heights[m]){
                int k = 0;
                for(int i=m;i>n;i--) {
                    l = Math.min(l,heights[i]);
                    if(l==1)break;
                    k++;
                }
                sum = Math.max(l*(m+1-n),sum);
                n = k+1;
                if(n<heights.length) {
                    l = heights[n];
                }
                if(n+1==m)break;
            }
        }

        Arrays.sort(heights);
        return Math.max(heights[heights.length-1],sum);
    }
}

/**
 * 暴力法
 */
class Test44_1{
    public static void main(String[] args) {
        Test44_1 test44 = new Test44_1();
        //int[] heigths = {2,1,5,6,2,3};
        //int[] heigths = {2};
        int[] heigths = {1,4,6};
        System.out.println(test44.largestRectangleArea(heigths));
    }

    public int largestRectangleArea(int[] heights){
        int sum = 0;
        for(int i=0;i<heights.length;i++){
            int l = heights[i];
            //sum = heights[i];
            for( int j=i;j<heights.length;j++){
                l = Math.min(l,heights[j]);
                sum = Math.max(sum,(j-i+1)*l);
            }
        }
        return sum;
    }
}

/**
 * 双指针，最优解
 */
class Test44_2{
    public static void main(String[] args) {
        Test44_2 test44_2 = new Test44_2();
        int[] heigths = {2,3,5,6,2,3};
        System.out.println(test44_2.largestRectangleArea(heigths));
    }

    public int largestRectangleArea(int[] heights){
        /*int sum = 0;
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        for ( int i = 0; i < heights.length; i++ ) {//2,3,5,6,2,3
            int height = heights[i];
            int le = i-1;
            while (le>=0){
                if(heights[le]<height)break;
                le = left[le];
            }
            left[i] = le;
        }
        for ( int i = heights.length-1; i >= 0; i-- ) {
            int height = heights[i];
            int ri = i+1;
            while (ri<heights.length){
                if(heights[ri]<height)break;
                ri = right[ri];
            }
            right[i] = ri;
        }
        for ( int i = 0; i < heights.length; i++ ){
            int currArea = ( right[i] - left[i] - 1 ) * heights[i];
            sum = currArea > sum ? currArea : sum;
        }
        return  sum;*/
        int sum = 0;
        int[] lp = new int[heights.length];
        int[] rp = new int[heights.length];
        for(int i=0;i<heights.length;i++){
            int he = heights[i];
            int t = i-1;
            while (t>=0){
                if(heights[t]<he)break;
                t = lp[t];
            }
            lp[i] = t;
        }
        for(int i=heights.length-1;i>=0;i--){
            int he = heights[i];
            int t = i+1;
            while (t<heights.length){
                if(heights[t]<he)break;
                t = rp[t];
            }
            rp[i] = t;
        }
        for(int i=0;i<heights.length;i++){
            sum = Math.max(sum,(rp[i]-lp[i]-1)*heights[i]);
        }
        return sum;
    }
}

class Test44_3{
    public static void main(String[] args) {
        Test44_3 test44_3 = new Test44_3();
        int[] heigths = {2,1,5,6,2,3};
        System.out.println(test44_3.largestRectangleArea(heigths));
    }

    public int largestRectangleArea(int[] heights) {
        int largestArea = 0;
        for ( int i = 0; i < heights.length; i++ ){
            int height = heights[i];
            int left = i, right = i;
            // 寻找左边界
            while ( left >= 0 ){
                if ( heights[left] < height ) break;
                left --;
            }
            // 寻找右边界
            while ( right < heights.length ){
                if ( heights[right] < height ) break;
                right ++;
            }
            int width = right - left - 1;
            int currArea = height * width;
            largestArea = currArea > largestArea ? currArea : largestArea;
        }
        return largestArea;
    }
}