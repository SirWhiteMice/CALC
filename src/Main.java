import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws User_is_bad_boy {
        Scanner scanner = new Scanner(System.in);
        input_string = scanner.nextLine().toUpperCase().replaceAll(" ", "");
        calc(input_string);

    }
    public static String input_string;
    public static String calc (String input) throws User_is_bad_boy {
        splitting(input);
        System.out.println("КОНЕЧНЫЙ ВЫВОД!!!!!" + output_string);
        return output_string;
    }
    public static void splitting (String splitting_input) throws User_is_bad_boy {
        String[] array = splitting_input.split("\\*|\\/|\\+|\\-");
        if (array.length != 2){
            throw new User_is_bad_boy("Lisa says あらあらあ!");
        }
        String[] arabic_values = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] roman_values = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};

        int count_arabic_value = 0;
        int count_roman_value = 0;

        for (int i = 0; i < array.length; ++i) {
            for (int ii = 0; ii < arabic_values.length; ++ii) {
                if (array[i].toString().equals(arabic_values[ii].toString()))
                    count_arabic_value++;
            }
        }

        for (int i = 0; i < array.length; ++i) {
            for (int ii = 0; ii < roman_values.length; ++ii) {
                if (array[i].toString().equals(roman_values[ii].toString()))
                    count_roman_value++;
            }
        }
        if (count_arabic_value == 2) {
            int a = Integer.parseInt(array[0].toString());
            int b = Integer.parseInt(array[1].toString());
            calculating_arabic (a, b);
        }
        if (count_roman_value == 2) {
            RomanNumeral RN_1 = RomanNumeral.valueOf(array[0].toString());
            RomanNumeral RN_2 = RomanNumeral.valueOf(array[1].toString());
            int a = RN_1.arabic;
            int b = RN_2.arabic;
            calculating_roman (a, b);

        }
        if ((count_arabic_value | count_roman_value) != 2){
            throw new User_is_bad_boy("Lisa says あらあらあ!");
        }
    }

    public static void calculating_arabic (int a, int b) throws User_is_bad_boy {
        char[] input_calc = input_string.toCharArray();

        int reselut = 0;

        for (int i = 0; i < input_calc.length; i++) {
            if (input_calc[i] == '+') {
                reselut = a + b;
            }
            if (input_calc[i] == '-') {
                reselut = a - b;
            }
            if (input_calc[i] == '*') {
                reselut = a * b;
            }
            if (input_calc[i] == '/') {
                reselut = a / b;
            }
        }
        output_string = Integer.toString(reselut);
    }
    public static void calculating_roman (int a, int b) throws User_is_bad_boy {
        char[] input_calc = input_string.toCharArray();

        int reselut = 0;

        for (int i = 0; i < input_calc.length; i++) {
            if (input_calc[i] == '+') {
                reselut = a + b;
            }
            if (input_calc[i] == '-') {
                reselut = a - b;
            }
            if (input_calc[i] == '*') {
                reselut = a * b;
            }
            if (input_calc[i] == '/') {
                reselut = a / b;
            }
        }
        if (reselut > 0){
            RomanNumeral RN_output = RomanNumeral.values()[--reselut];
            output_string = RN_output.toString();
        } else {
            throw new User_is_bad_boy("Lisa says あらあらあ!");

        }
    }
    public static String output_string;
}
