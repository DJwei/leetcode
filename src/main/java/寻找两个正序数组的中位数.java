/**
 * 错误解答
 */

class Test21 {
    public static void main(String[] args) {
        Test21 test21 = new Test21();
        int[] nums1 = {1,4,7,8};
        int[] nums2 = {5,7};
        System.out.println(test21.findMedianSortedArrays(nums1,nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double end = 0;
        int n = nums1.length/2;
        int z = 0;
        int[] nums3 = new int[nums1.length+nums2.length];
        for(int i=0;i<nums2.length;i++) {
            int nums2z = nums2[i];
            for (int nn = n; nn >=1; nn = nn / 2) {
                if (nums2z < nums1[nn]) {
                    n = n / 2;
                } else {
                    nums3[nn * 2] = nums2z;         //1,4,7,8
                    for (int k = 0; k < nn * 2; k++) {        //5,7
                        nums3[k] = nums1[k];
                    }
                    for (int j = nn * 2 + 1; j < nums3.length; j++)
                        //for(int jj=nn*2)
                        if(j-1<nums1.length) {
                            nums3[j] = nums1[j - 1];
                        }
                    }
                //n = nums1.length/2;
                }
            }
            if (nums3.length / 2 != 0) {
                end = nums3[nums3.length / 2];
            } else {
                end = (nums3[nums3.length / 2] + nums3[nums3.length / 2 - 1]) / 2;
            }
            return end;
    }
}



class Test21_1{
    /**
     * 暴力for循环
     * @param args
     */
    public static void main(String[] args) {
        Test21_1 test21_1 = new Test21_1();
     /*   int[] nums1 = {1,4,7,8};
        int[] nums2 = {5,7};*/
        /*int[] nums1 = {1,2};
        int[] nums2 = {3,4};*/
        int[] nums1 = {1,3};
        int[] nums2 = {2,6};
       /* int[] nums1 = {1,3};
        int[] nums2 = {7};*/
        /*int[] nums1 = {0,1,1,1,1};
        int[] nums2 = {-1,0,0,0,1};*/
        System.out.println(test21_1.findMedianSortedArrays(nums1,nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length==0&&nums2.length==1)return nums2[0];
        if(nums2.length==0&&nums1.length==1)return nums1[0];
        int[] nums3 = new int[nums1.length+ nums2.length];
        double end = 0;
        for(int i=0;i<nums1.length;i++){
            nums3[i]=nums1[i];
        }
        int n = nums1.length/2;
        int j =0;
        int nn = nums2.length;
        for(int i=n;i>=n/2;i++){
            if(nums2[j]<nums3[n]){
                n = n/2;
            }
            else {
                int[] nums4 = new int[nums3.length];
                for(int l=0;l<nums3.length;l++){
                    nums4[l]=nums3[l];
                }
                nums3[n+1] = nums2[j];
                for(int k=n+1;k<nums4.length-1;k++){
                    nums3[k+1]=nums4[k];
                }
                nn--;
                if(nn==0)break;
                j++;
                n = nums3.length/2;
            }
        }
        if (nums3.length % 2 != 0) {//1,4,5,7,7,8
            end = nums3[nums3.length / 2];
        } else {
            end = (nums3[nums3.length / 2] + nums3[nums3.length / 2 - 1]) / 2.0;
        }
        return end;
    }
}

/**
 * On遍历一次取值
 */
class Test21_2{
    public static void main(String[] args) {
        Test21_2 test21_2 = new Test21_2();
        /*int[] nums1 = {1,4,7,8};
        int[] nums2 = {5,7};*/
      /*  int[] nums1 = {1,2};
        int[] nums2 = {3,4};*/
        /*int[] nums1 = {3,7};
        int[] nums2 = {};*/
       /* int[] nums1 = {2,3,4};
        int[] nums2 = {5};*/
        /*int[] nums1 = {1,3};
        int[] nums2 = {2,6};*/
        /*int[] nums1 = {1,3};
        int[] nums2 = {7};*/
        int[] nums1 = {0,1,1,1,1};
        int[] nums2 = {-1,0,0,0,1};
        System.out.println(test21_2.findMedianSortedArrays(nums1,nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums3 = new int[nums1.length+nums2.length];
        if(nums1.length==0&&nums2.length!=0){
            if(nums2.length%2==0) {
                return (nums2[nums2.length / 2]+nums2[nums2.length/2-1])/2.0;
            }else return nums2[nums2.length / 2];
        }
        if(nums2.length==0&&nums1.length!=1){
            if(nums1.length%2!=0) {
                return nums1[nums1.length / 2];
            }else return (nums1[nums1.length / 2]+nums1[nums1.length/2-1])/2.0;
        }
        double end = 0.0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n3 = nums3.length;
        int j =0;
        int jj=0;
       // if (n1!=j||n2!=jj){
            for(int i=0;i<n3;i++){

                if(n2==jj){
                    for(int ii=i;ii<n3;ii++) {
                        nums3[ii] = nums1[j];
                        j++;
                    }
                    break;
                }else if(n1==j){
                    for(int ii=i;ii<n3;ii++) {
                        nums3[ii] = nums2[jj];
                        jj++;
                    }
                    break;
                }
                if(nums1[j]<=nums2[jj]&&j!=nums1.length){
                    nums3[i]=nums1[j];
                    j++;
                }
                else if(nums1[j]>nums2[jj]&&jj!=nums2.length) {
                    nums3[i]=nums2[jj];
                    jj++;
                }
            }

        if (nums3.length % 2 != 0) {//1,4,5,7,7,8
            end = nums3[nums3.length / 2];
        } else {
            end = (nums3[nums3.length / 2] + nums3[nums3.length / 2 - 1]) / 2.0;
        }
        return end;
    }

}
