import java.util.ArrayList;
import java.util.List;

class Test37 {
     public static void main(String[] args) {

     }

     public List<String> letterCombinations(String digits) { //23
         Character[] dig = {'2','3','4','5','6','7','8','9'};
         String a = "a";String b = "b";
         String c = "c";String d = "d";
         String[] end = {a,b,c,d};
         int n = 0;
         String[] nums = {"null","null","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
         List<String> list = new ArrayList<>();
         //用数组来接收输入的号码对应的值
         for(int i=0;i<digits.length();i++){
             //n = digits.charAt(i)-'0';
             end[i] = nums[digits.charAt(i)-'0'];
             //用n来记载有几个号码
             n++;
         }
         //找出数组中最长的长度
         int p = 0;
         for(int i=0;i<end.length;i++){
             p = Math.max(end[i].length(),p);
         }

         for(int i=0;i<end[0].length();i++){//abc
            int m = 0;
             String[] reuslt = new String[end[0].length()*end[1].length()*end[2].length()*end[3].length()];
             for(int j=0;j<p;j++){
                 String sum = "";
                 sum = end[i].charAt(j)+""+end[i+1];
                 //list.add()
             }
         }
         return null;
     }
}
