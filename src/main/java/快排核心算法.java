/**
 * 核心算法
 */
class QuickSort2 {
    //核心算法归并调用
    public static void Qsrot(int[] nums,int l,int r){
        //基准情况(当只有一个数字的时候不需要排序)
        if(l >= r) return;
        //1.找到一个点point在数组中的索引位置
        int index = partition(nums,l,r);
        //2.递归调用方法
        Qsrot(nums,l,index-1);
        Qsrot(nums,index+1,r);
    }
    //核心算法找点
    public static int partition(int[] nums,int l, int r){
        //1.先确定一个点，就以第一个为最开始的点
        int point = nums[l];
        //2.定义指针
        int left = l,right = r;
        //3.返回point的索引位置
        int position = l;
        //4.最后的目的是让左指针和右指针相遇
        while (left<right){
            //左指针右移动，找到一个比point大的数，就停下来
            while (left<right&&nums[left]<=point)left++;
            while (left<right&&nums[right]>=point)right--;
            //判断左右指针是否相遇，还是要判断相遇没有
            if(left<right){
                change(nums,left,right);
            }else {//如过相遇,填入点point
                //判断当前位置和point的大小，确定位置
                if(nums[left]<point){
                    position = left;
                    change(nums,l,left);
                }else {
                    position = left-1;
                    change(nums,l,left-1);
                }
            }
        }
        return position;
    }

    public static void change(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2,6,3,45,23,6,43,3};
        Qsrot(nums,0,nums.length-1);
        pr(nums);
    }

    public static void pr(int[] nums){
        for(int i : nums){
            System.out.print(i+"\t");
        }
    }
}
