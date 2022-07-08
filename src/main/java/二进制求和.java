class Test22 {
    public static void main(String[] args) {
        Test22 test22 = new Test22();
        String a = "1011";
        String b = "1010";//10101
        /*String a = "111";
        String b = "111";*/
        System.out.println(test22.addBinary(a,b));
    }

    public String addBinary(String a, String b) {
        StringBuffer stringBuffer = new StringBuffer();
        int A = a.length();
        int B = b.length();
        int i = 0;
        int j = 0;
        int cus = 0;
        if (a.equals("0") && b.equals("0")) return "0";
        while ((A != 0 && A > 0) || (B != 0 && B > 0) || cus != 0) {
            if (A != 0 && A > 0) {
                i = a.charAt(A - 1) - '0';
            } else if (A == 0) {
                i = 0;
            }
            if (B != 0 && B > 0) {
                j = b.charAt(B - 1) - '0';
            } else if (B == 0) {
                j = 0;
            }
            //cus = (i+j)%2;
            if ((i + j + cus) % 2 == 0) {
                stringBuffer.append(0);
                cus = 1;
            } else if ((i + j + cus) % 2 != 0 && (i + j + cus) % 2 != 1) {
                stringBuffer.append(1);
                cus = 0;
            } else if ((i + j + cus) % 2 == 1) {
                stringBuffer.append(1);
                cus = 1;
                if (((A != 0 && A > 0) || (B != 0 && B > 0)) == false) break;
            }
            A--;
            B--;

        }
       /* if(stringBuffer.substring(stringBuffer.length()-1).equals("0")){
            stringBuffer.append(1);
        }*/
        return stringBuffer.reverse().toString();
    }
}

/**
 * 字符串相加
 */
class Test22_1 {
    public static void main(String[] args) {
        Test22_1 test22_1 = new Test22_1();
        /*String a = "1011";
        String b = "1010";//10101*/
        String a = "111";
        String b = "111";
        System.out.println(test22_1.addBinary(a, b));
    }

    public String addBinary(String a, String b) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int cus = 0;
        while (i >= 0 || j >= 0 || cus != 0) {
            int x = i >= 0 ? a.charAt(i) - '0' : 0;
            int y = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = x + y + cus;
            i--;
            j--;
            cus = sum / 2;
            stringBuffer.append(sum % 2);
        }
        return stringBuffer.reverse().toString();
    }
}

/**
 * 抓住二进制运算只有0，1进位也只有0，1
 */
class Test22_2{
    public static void main(String[] args) {
        Test22_2 test22_2 = new Test22_2();
        /*String a = "1011";
        String b = "1010";//10101*/
        String a = "11";
        String b = "1";
        System.out.println(test22_2.addBinary(a, b));
    }

    public String addBinary(String a, String b) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = a.length()-1;
        int j = b.length()-1;
        int cus = 0;
        while (i>=0||j>=0||cus!=0){
            if(i>=0) cus = cus + a.charAt(i)-'0';
            if(j>=0) cus = cus + b.charAt(j)-'0';
            i--;
            j--;
           // cus = cus/2;
            stringBuffer.append(cus%2);
            cus = cus/2;
        }
        return stringBuffer.reverse().toString();
    }
}
