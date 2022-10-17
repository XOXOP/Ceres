import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


import static java.lang.Integer.parseInt;
public class Main {

    public static void main(String[] args) throws IOException {


        String n = calc(" ");
        System.out.println(n);

    }

    public static String calc(String input) throws IOException{
        Scanner sc = new Scanner(System.in);
        String phrase = sc.nextLine();//"ввод выражения");
        String[] strings = phrase.split(" ");

        String result = " ";
        if(strings.length == 3) {

            int U = strings[0].codePointAt(0);

            if (U < 67) {

                try {
                    int x1 = parseInt(strings[0], 10);
                    int x2 = parseInt(strings[2], 10);
                    boolean A = x1 < 11 && x1 > 0;
                    boolean B = x2 < 11 && x2 > 0;
                    if (A && B) {
                        int m = articl(x1, x2, phrase);

                        result +=m;

                    } else {

                        throw new IOException();

                    }

                } catch (NumberFormatException e) {
                    e.printStackTrace();

                }

            } else if (U > 66) {
                HashMap<String, Byte> map = new HashMap<>();
                map.put("I", (byte) 1);
                map.put("II", (byte) 2);
                map.put("III", (byte) 3);
                map.put("IV", (byte) 4);
                map.put("V", (byte) 5);
                map.put("VI", (byte) 6);
                map.put("VII", (byte) 7);
                map.put("VIII", (byte) 8);
                map.put("IX", (byte) 9);
                map.put("X", (byte) 10);

                byte exist = Byte.valueOf((map.containsKey(strings[0]) && map.containsKey(strings[2])) ? "1" : "0");

                if (exist == 1) {

                    int x1 = map.get(strings[0]);
                    int x2 = map.get(strings[2]);
                    int m = articl(x1, x2, phrase);

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
                        //System.out.println(rim);
                        result += rim;
                    } else {
                        throw new IOException();
                    }


                } else {
                    throw new IOException();
                }

            } else {
                throw new IOException();
            }

        }else {
            throw new IOException();
        }

        return result;
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
