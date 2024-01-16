public class Main {
    public static void main(String[] args) {
        System.out.println("Palindrom Sayıyı Bulma:" + isPalindrome(-1221));
        System.out.println("Palindrom Sayıyı Bulma:" + isPalindrome(707));
        System.out.println("Palindrom Sayıyı Bulma:" + isPalindrome(11212));

        System.out.println("Palindrom Sayıyı Bulma:" + isPalindrome2(-1221));
        System.out.println("Palindrom Sayıyı Bulma:" + isPalindrome2(707));
        System.out.println("Palindrom Sayıyı Bulma:" + isPalindrome2(11212));

        System.out.println("Palindrom Sayıyı Bulma:" + isPalindrome3(-1221));
        System.out.println("Palindrom Sayıyı Bulma:" + isPalindrome3(707));
        System.out.println("Palindrom Sayıyı Bulma:" + isPalindrome3(11212));

        System.out.println("Mükemmel Sayıyı Bulma:" + isPerfectNumber(6));
        System.out.println("Mükemmel Sayıyı Bulma:" + isPerfectNumber(28));
        System.out.println("Mükemmel Sayıyı Bulma:" + isPerfectNumber(5));
        System.out.println("Mükemmel Sayıyı Bulma:" + isPerfectNumber(-1));

        System.out.println("Sayıları Kelimelere Dök:" + numberToWords(123));
        System.out.println("Sayıları Kelimelere Dök:" + numberToWords(1010));
        System.out.println("Sayıları Kelimelere Dök:" + numberToWords(-12));



    }

    //NOT: toCharArray() -> karakterleri bir array olarak aliyor.
    //NOT: valueOf() -> gelen integeri string'e ceviriyor.
    //NOT: Math.abs -> sayinin mutlak degerini aliyor.
    public static boolean isPalindrome(int number){
        number = Math.abs(number);
        char[] digits = String.valueOf(number).toCharArray(); //rakamlari tek tek gezmek icin char arrayinin icine aldik.
        // TODO 122 => 221
        String reversed = "";
        for (int i=digits.length-1; i>= 0; i--){
            reversed += digits[i];

        }
        return reversed.equals(String.valueOf(number));
    }

    //FARKLI BİR YAKLAŞIM:
    public static boolean isPalindrome2(int number){
        number = Math.abs(number); //121
        int originalNum = number;  //originalNum = 121
        int reverseNumber = 0; //reverseNumber = 0

        // 121  12  1

        while (number > 0){
            int digit = number % 10; // digit = 1 digit = 2 digit = 1
            reverseNumber = reverseNumber*10+digit; //reverseNumber = 1 reverseNumber = 12 reverseNumber = 121
            number = number/10; //number = 12  number = 1 number = 0
        }
        return originalNum == reverseNumber; // originalNum = 121 reverseNumber = 121
    }

    //FARKLI BIR COZUM:

    public static boolean isPalindrome3(int number){
        number = Math.abs(number);
        String numberString = Integer.toString(number);
        char[] charNumber = numberString.toCharArray();

        int firstIndex = 0;
        int lastIndex = charNumber.length-1;

        while(firstIndex < lastIndex){
            if(charNumber[firstIndex] != charNumber[lastIndex]) return false;

            firstIndex++;
            lastIndex--;
        }
        return true;
    }

    //number = 6 diyelim:

    public static boolean isPerfectNumber(int number){
        if(number <= 0){
            return false;
        }
        int total = 0; //total = 0
        for(int i = 1; i <= number / 2; i++){ // i = 1 i<=3,   i=2 i<=3,  i=3 i<=3
            if (number % i == 0) total += i;  //total = 1; total = 2+1; total = 3+3;
        }
        return number == total;
    }

    public static String numberToWords(int number){
        if(number<0){
            return "Invalid Value";
        }
        char[] digits = String.valueOf(number).toCharArray();
        String numberToText = "";
        for(char digit: digits){
            switch (digit){
                case '0':
                    numberToText += "Zero ";
                    break;
                case '1':
                    numberToText += "One ";
                    break;
                case '2':
                    numberToText += "Two ";
                    break;
                case '3':
                    numberToText += "Three ";
                    break;
                case '4':
                    numberToText += "Four ";
                    break;
                case '5':
                    numberToText += "Five ";
                    break;
                case '6':
                    numberToText += "Six ";
                    break;
                case '7':
                    numberToText += "Seven ";
                    break;
                case '8':
                    numberToText += "Eight ";
                    break;
                case '9':
                    numberToText += "Nine ";
                    break;

            }
        }
        return numberToText.trim(); //trim bosluklari siler!
    }


}