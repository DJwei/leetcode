import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class TestSet {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(2);
        set.add(1);
        set.add(5);
        System.out.println(set);

        String[] str =new String[] {"aaa","bbb","ccc","ddd"};

        //1. 通过先转List之后引入Set
        Set set1 = new HashSet<>(Arrays.asList(str));
        set1.add("aaa");
        System.out.println(set1);

    }
}
