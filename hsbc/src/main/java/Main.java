public class Main {

    public static int upsideDownDigit(int N){

        String number = Integer.toString(N);

//        for(char c:number.toCharArray()){
//            if (c == '6'){
//                number.replace(c,'9');
//                break;
//            }
//        }

        number = number.replaceFirst("6","9");

        return Integer.parseInt(number);
    }

    public static void main(String[] args) {

        // ✅ 测试用例
        System.out.println(upsideDownDigit(696));     // 996
        System.out.println(upsideDownDigit(99));      // 99
        System.out.println(upsideDownDigit(99666));   // 99966
        System.out.println(upsideDownDigit(666));     // 966
        System.out.println(upsideDownDigit(969969));  // 999969

    }
}
