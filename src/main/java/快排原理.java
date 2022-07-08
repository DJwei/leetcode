/**
 * 核心算法优雅化
 */
class QuickSort1 {
    public static void qSort( int[] nums, int start, int end ){
        if ( start >= end )
            return;
        int mid = partition(nums, start, end);
        qSort( nums, start, mid - 1 );
        qSort( nums, mid + 1, end );
    }
    // 定义一个分区方法
    private static int partition( int[] nums, int start, int end ){
        int pivot = nums[start];
        int left = start;
        int right = end;
        while ( left < right ){
            while ( left < right && nums[right] >= pivot )
                right --;
            nums[left] = nums[right];
            while ( left < right && nums[left] <= pivot )
                left ++;
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
}

class Test10111{
    public static void main(String[] args) {
        int[] a = {3,5,1,7,8};
        Test10111 test10111 = new Test10111();
        QuickSort1 quickSort1 = new QuickSort1();
        System.out.println(quickSort1.equals(a));
    }
}

