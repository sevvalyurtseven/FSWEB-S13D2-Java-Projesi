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
}