import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


import static java.lang.Integer.parseInt;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String phrase = sc.nextLine();            //"ввод выражения");
        String[] strings = phrase.split(" ");
        int U = strings[0].codePointAt(0);

        if (U < 67) {

            try {
                int x1 = parseInt(strings[0], 10);
                int x2 = parseInt(strings[2], 10);
                boolean A = x1 < 11 && x1 > 0;
                boolean B = x2 < 11 && x2 > 0;
                if (A && B) {
                    int m =articl(x1, x2, phrase);
                    System.out.println(m);


                } else {

                    throw new IOException();

                }

            } catch (NumberFormatException e) {

            }

        } else if (U > 66) {
            HashMap<String, Integer> map = new HashMap<>();
            map.put("I", new Integer(1));
            map.put("II", new Integer(2));
            map.put("III", new Integer(3));
            map.put("IV", new Integer(4));
            map.put("V", new Integer(5));
            map.put("VI", new Integer(6));
            map.put("VII", new Integer(7));
            map.put("VIII", new Integer(8));
            map.put("IX", new Integer(9));
            map.put("X", new Integer(10));

            byte exist = Byte.valueOf((map.containsKey(strings[0]) && map.containsKey(strings[2])) ? "1" : "0");

            if (exist == 1) {

                int x1 = map.get(strings[0]);
                int x2 = map.get(strings[2]);
                int m =articl(x1, x2, phrase);

                if (m > 0) {

                    String rim = " ";
                    while (m >= 100) {
                        rim += "C";
                        m -= 100;
                    }
                    while (m >= 90) {
                        rim += "XC";
                        m -= 90;
                    }
                    while (m >= 50) {
                        rim += "L";
                        m -= 50;
                    }
                    while (m >= 40) {
                        rim += "XL";
                        m -= 40;
                    }
                    while (m >= 10) {
                        rim += "X";
                        m -= 10;
                    }
                    while (m >= 9) {
                        rim += "IX";
                        m -= 9;
                    }
                    while (m >= 5) {
                        rim += "V";
                        m -= 5;
                    }
                    while (m >= 4) {
                        rim += "IV";
                        m -= 4;
                    }
                    while (m >= 1) {
                        rim += "I";
                        m -= 1;
                    }
                    System.out.println(rim);
                } else {
                    throw new IOException();
                }


            } else {
                throw new IOException();
            }

        } else {
            throw new IOException();
        }


    }

    private static int articl(int x, int y, String str1) throws IOException {
        int resul;
        if (str1.contains("-")) {
            resul = x - y;
        }else if (str1.contains("+")) {
            resul = x + y;
        } else if (str1.contains("/")) {
            resul = x / y;
        } else if (str1.contains("*")) {
            resul = x * y;
        } else {
            throw new IOException();
        }
        return resul;

    }


}

