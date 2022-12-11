public class Roman {
    public static int value(char letter) {
        int value = 0;
        switch (letter) {
            case 'I':
                value = 1;
                break;
            case 'V':
                value = 5;
                break;
            case 'X':
                value = 10;
                break;
            case 'L':
                value = 50;
                break;
            case 'C':
                value = 100;
                break;
            case 'D':
                value = 500;
                break;
            case 'M':
                value = 1000;
                break;
        }
        return value;
    }

    public static int romanToInt(String romanNum) {
        int val = 0;
        char[] letters = romanNum.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            val += value(letters[i]);
            if (i>0 && value(letters[i])>value(letters[i-1])){
                val -= value(letters[i-1])*2;
            }
        }
        return val;
    }
}