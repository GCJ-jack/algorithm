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

    public static boolean robotMovement(String s){

        int x = 0;
        int y = 0;

        for(char c:s.toCharArray()){
            switch (c){
                case 'L' : x--; break;
                case 'R' : x++; break;
                case 'U' : y++; break;
                case 'D' : y--; break;
                default:
                    break;
            }

        }

        if(x == 0 && y == 0){
            return true;
        }

        return  false;

    }

    public static String latestValidDate(String date){
        int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};

        String monthStr = date.substring(0, 2);
        String dayStr = date.substring(3, 5);

        // --- 处理月份 ---
        char m1 = monthStr.charAt(0);
        char m2 = monthStr.charAt(1);
        int month = 0;

        if (m1 == '?' && m2 == '?') {
            month = 12;
        } else if (m1 == '?') {
            // ?X
            int x = m2 - '0';
            if (x <= 2) month = 12;      // 最高合法 12
            else month = 9;              // 否则最大是 09
        } else if (m2 == '?') {
            // X?
            int x = m1 - '0';
            if (x == 0) month = 9;
            else if (x == 1) month = 12;
            else return "xx-xx";         // 月份非法
        } else {
            month = Integer.parseInt(monthStr);
        }

        if (month < 1 || month > 12) return "xx-xx";

        // --- 处理天数 ---
        int maxDay = daysInMonth[month - 1];
        char d1 = dayStr.charAt(0);
        char d2 = dayStr.charAt(1);
        int day = 0;

        if (d1 == '?' && d2 == '?') {
            day = maxDay;
        } else if (d1 == '?') {
            // ?X
            int x = d2 - '0';
            int try1 = 30 + x; // 尝试 3x, 2x
            int try2 = 20 + x;
            int try3 = 10 + x;
            int try0 = x;

            if (try1 <= maxDay) day = try1;
            else if (try2 <= maxDay) day = try2;
            else if (try3 <= maxDay) day = try3;
            else if (try0 <= maxDay) day = try0;
            else return "xx-xx";

        } else if (d2 == '?') {
            // X?
            int x = d1 - '0';
            for (int i = 9; i >= 0; i--) {
                int tmp = x * 10 + i;
                if (tmp <= maxDay) {
                    day = tmp;
                    break;
                }
            }
            if (day == 0) return "xx-xx";
        } else {
            day = Integer.parseInt(dayStr);
        }

        if (day < 1 || day > maxDay) return "xx-xx";

        return String.format("%02d-%02d", month, day);
    }


    public static void main(String[] args) {

//        // ✅ 测试用例
//        System.out.println(upsideDownDigit(696));     // 996
//        System.out.println(upsideDownDigit(99));      // 99
//        System.out.println(upsideDownDigit(99666));   // 99966
//        System.out.println(upsideDownDigit(666));     // 966
//        System.out.println(upsideDownDigit(969969));  // 999969

        System.out.println(robotMovement("UD"));           // true  → 上一步、下一步
        System.out.println(robotMovement("LL"));           // false → 向左两步没回来
        System.out.println(robotMovement("UDLR"));         // true  → 四个方向抵消
        System.out.println(robotMovement("UUDDLRLR"));     // true  → 上下左右抵消
        System.out.println(robotMovement("UUUDDD"));       // true  → 三上三下
        System.out.println(robotMovement("UUUDD"));        // false → (0,1)
        System.out.println(robotMovement("UDUDUD"));       // true  → 多次抵消
        System.out.println(robotMovement("LRLRLRR"));      // false → 向右多一步
        System.out.println(robotMovement("U"));            // false → 只上一步
        System.out.println(robotMovement("UDLRUDLRUDLR")); // true  → 多次重复也回原点

    }
}
