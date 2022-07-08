
/**
 * 盛最多水的容器
 */
 class Test20 {
     public static void main(String[] args) {
         Test20 test20 = new Test20();
         //int[] height = new int[]{1,8,6,2,5,4,8};
        // int[] height = new int[]{2,1};//100,2,100,4,8,3
         //int[] height = new int[]{18,17,6};
         int[] height = new int[]{1,8,6,2,5,9,8,3,7,11};
         //int[] height = new int[]{2,3,4,5,18,17};
         //int[] height = new int[]{100,2,100,4,8,3};
         System.out.println(test20.maxArea(height));
     }

    public int maxArea(int[] height) {
        int n = 0;
        int zz = 0;
        int[] height1 = new int[height.length];
         for(int k=0;k<height.length-1;k++) {
             if (height[k] >= zz) {
                 zz = height[k];
             }
         }
         for(int i=0;i<height.length-1;i++){
             if(zz==height[i]){
                 n=i;
             }
         }
        // int sum = 0;
         int sum2 = 0;
         for(int x = n;x>=0;x--){
             int z = n-1;
             if(z==height.length){
                 int heii = height[z] < height[height.length-1] ? height[z] : height[height.length-1];
                 return heii;
             }
             for(int y = n;y<height.length;y++) {
                 int hei = height[x] < height[y] ? height[x] : height[y];
                int sum = hei*(y-x);
                 if(sum2<sum){
                     sum2=sum;
                 }
                 else continue;
             }
         }
         return sum2;
    }
 }



 class Test20_1{
     public static void main(String[] args) {
         Test20_1 test20_1 = new Test20_1();
         int[] height = new int[]{100,2,100,4,8,3};
         System.out.println(test20_1.maxArea(height));
     }
     public int maxArea(int[] height) {
         int lp = 0;
         int rp = height.length-1;
         int sum = 0;
         while (lp<rp){
            int sum1 = Math.min(height[lp],height[rp])*(rp-lp);
             sum = Math.max(sum1,sum);
             if(height[lp]<height[rp]){
                 lp++;
             }else rp--;
         }
         return sum;
     }
 }