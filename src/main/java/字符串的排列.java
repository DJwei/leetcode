import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 字符串排序
 */
class Test24 {
    public static void main(String[] args) {
        Test24 test24 = new Test24();
        String s = "abb";
      //  System.out.println(test24_1.permutation(s));
        for(String i : test24.permutation(s)){
            System.out.println(i);
        }
    }

   List<String> res = new LinkedList<>();
    char[] c;
    public String[] permutation(String s) {

        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }
    void dfs(int x) {
        if(x == c.length - 1) {
            res.add(String.valueOf(c));      // 添加排列方案
            return;
        }

        HashSet<Character> set = new HashSet<>();
        for(int i = x; i < c.length; i++) {
            if(set.contains(c[i])) continue; // 重复，因此剪枝
            set.add(c[i]);
            swap(i, x);                      // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1);                      // 开启固定第 x + 1 位字符
            swap(i, x);                      // 恢复交换
        }
    }
    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}
