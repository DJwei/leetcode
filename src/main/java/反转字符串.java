import java.util.Arrays;

/**
 * 击败100%时间复杂度O(N)
 */
class Test35 {
    public static void main(String[] args) {
        Test35 test35 = new Test35();
        char[] s = {'h','e','l','l','o','g'};
        test35.reverseString(s);
    }

    public void reverseString(char[] s) {
        //int n = s.length;//n=5
        char[] a = new char[1];
        for(int i=0;i<s.length/2;i++){//"h","e","l","l","o"
            a[0] = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = a[0];
        }
        System.out.println(Arrays.toString(s));
    }
}
