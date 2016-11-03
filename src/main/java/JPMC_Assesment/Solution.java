package JPMC_Assesment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.util.Collections.sort;

public class Solution {
    static String[] ones = {
            "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    static String[] tens = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    static String[] large_values = {"Thousand", "Million", "Billion"};


    public static  String forNumbersUnder_100(int num){
        if(num<=20){
            return ones[num];
        }
        String string1 = tens[num/10-2];
        if (num %10 == 0)
        {
            return string1;
        }
        return string1+ ones[num %10];
    }
    public  static String forNumbersUnder_1000(int num){
        String string1 = ones[num/100]+"Hundred";
        String string2 =forNumbersUnder_100(num% 100);
        if(num <=99){
            return string2;
        }
        else if (num % 100 ==0){
            return string1;
        }
        else {
            return string1 + string2;
        }

    }
    public static void  main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String s;



        while ((s = in.readLine()) != null) {
            int result = Integer.parseInt(s);
            if (result <= 999) {
                System.out.println(forNumbersUnder_1000(result) + "Dollars");
            } else if (result>999){
                String str = null;
                int next = 0;
                while (result > 0) {
                    if (result % 1000 != 0) {
                        String string = forNumbersUnder_1000(result % 1000);
                        if (next > 0) {
                            string = string + large_values[next - 1];
                        }
                        if (str == null) {
                            str = string;

                        } else {
                            str = string + str;

                        }

                    }
                    result /= 1000;
                    next++;
                }

                System.out.println(str + "Dollars");
            }
        }


    }


    }






