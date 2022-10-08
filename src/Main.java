import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


import static java.lang.Integer.parseInt;

public class Main {
    public static void  main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String phrase = sc.nextLine();            //"ввод выражения");
        int x1;
        int x2;
        int resul;
        String str1 = new String(phrase);
        String[] strings = str1.split(" ");
        int U = strings[0].codePointAt(0);

        if(U<67) {

            try {
                x1 = parseInt(strings[0], 10);
                x2 = parseInt(strings[2], 10);
                boolean A = x1 < 11 && x1 > 0;
                boolean B = x2 < 11 && x2 > 0;
                if (A && B) {
                    if (phrase.contains("-")) {
                        resul=x1 - x2;
                    }else if(phrase.contains("+")) {
                        resul= x1 + x2;
                    }else if(phrase.contains("/")) {
                        resul= x1 / x2;
                    }else if(phrase.contains("*")) {
                        resul= x1 * x2;
                    }else {
                        throw new IOException();
                    }
                    System.out.println(resul);

                } else {

                    throw new IOException();

                }

            } catch (NumberFormatException e) {

            }


        }else if(U>66) {
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

            Integer exist = Integer.valueOf((map.containsKey(strings[0]) && map.containsKey(strings[2])) ? "1" : "0");

            if (exist == 1) {
                //int xi;
                //int xv;
                //int xx;
                x1 = map.get(strings[0]);
                x2 = map.get(strings[2]);
                if (phrase.contains("-")) {
                    resul=x1 - x2;
                }else if(phrase.contains("+")) {
                    resul= x1 + x2;
                }else if(phrase.contains("/")) {
                    resul= x1 / x2;
                }else if(phrase.contains("*")) {
                    resul= x1 * x2;
                }else {
                    throw new IOException();
                }

                    if(resul>0){

                    String rim = " ";
                    while ( resul>= 100) {
                        rim += "C";
                        resul -= 100;
                    }
                    while (resul >= 90) {
                        rim += "XC";
                        resul-= 90;
                    }
                    while (resul >= 50) {
                        rim += "L";
                        resul -= 50;
                    }
                    while (resul >= 40) {
                        rim += "XL";
                        resul -= 40;
                    }
                    while (resul >= 10) {
                        rim += "X";
                        resul -= 10;
                    }
                    while (resul >= 9) {
                        rim += "IX";
                        resul -= 9;
                    }
                    while (resul >= 5) {
                        rim += "V";
                        resul -= 5;
                    }
                    while (resul >= 4) {
                        rim += "IV";
                        resul -= 4;
                    }
                    while (resul >= 1) {
                        rim += "I";
                        resul -= 1;
                    }
                    System.out.println(rim);
                } else {
                    throw new IOException();
                }



            } else {
                throw new IOException();
            }

        }else {
            throw new IOException();
        }



    }
}
