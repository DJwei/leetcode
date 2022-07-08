/**
 *实现 strStr()暴力for循环
 */
class Test18 {
    public static void main(String[] args) {
        Test18 test18 = new Test18();
//        String o = "helllo";//7
//        String p = "ll";//4
        /*String o = "missi";//7
        String p = "issi";//4*/
        String o = "isss";//7
        String p = "ss";//4
        System.out.println(test18.strStr(o,p));
    }

    public int strStr(String haystack, String needle) {

        if(haystack.equals("")&&needle.equals("")){
            return 0;
        }
        if(haystack.equals(needle)){
            return 0;
        }
        String a = "";
        //String b = a;
        int n = haystack.length()-needle.length()+1;
        for(int i=0;i<n;i++){
            for(int j=i;j<i+needle.length();j++){
                a = a + haystack.charAt(j);
                if(a.equals(needle)) {
                    return i;
                }
            }
            a = "";
        }
        return -1;
    }
}

/**
 * 利用api方法
 */
class Test18_1 {
    public static void main(String[] args) {
        Test18_1 test18_1 = new Test18_1();
        String o = "";//6
        String p = "";//2
        System.out.println(test18_1.strStr(o,p));
    }

    public int strStr(String haystack, String needle) {
        for(int i=0;i<haystack.length()-needle.length()+1;i++){
            if(haystack.startsWith(needle,i))return i;
        }
        return -1;
    }
}

/**
 * 进阶思想kmp算法
 */
class Test18_2{
    public static void main(String[] args) {
        Test18_2 test18_2 = new Test18_2();
//        String o = "helllo";//7
//        String p = "ll";//4
        /*String o = "missi";//7
        String p = "issi";//4*/
        String o = "iskkss";//7
        String p = "ss";//4
        System.out.println(test18_2.strStr(o,p));
    }

    public int strStr(String haystack, String needle) {
        String S = haystack;
        String P = needle;
        int i = 0;    // S 的下标
        int j = 0;    // P 的下标
        int s_len = S.length();
        int p_len = P.length();

        while (i < s_len && j < p_len)
        {
            if (S.charAt(i) == P.charAt(j))  // 若相等，都前进一步
            {
                i++;
                j++;
            }
            else               // 不相等
            {
                i = i - j + 1; //String o = "ooisssjkskssk";//7 String p = "sss65k";//4
                j = 0;
            }
        }
        if (j == p_len)        // 匹配成功
            return i - j;

        return -1;
    }
}
