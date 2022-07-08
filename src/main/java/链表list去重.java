

import java.util.*;

class TestList {
    public static void main(String[] args) {
        ArrayList<Integer> listt = new ArrayList<>();
        listt.add(0, 2);
        System.out.println(listt.get(0));
        listt.add(0, 1);
        listt.add(0, 4);
        System.out.println(listt.get(0) + "+" + listt.get(1));
        listt.add(3, 8);
        System.out.println(listt);

    }
}
