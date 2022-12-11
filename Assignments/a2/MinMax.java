public class MinMax {

    public static double minMaxAverage(int[] numbers) {
        int myMin;
        int myMax;
        int i;
        int n = numbers.length;
        if (n % 2 == 0) {
            if (numbers[0] > numbers[1]) {
                myMin = numbers[1];
                myMax = numbers[0];
            } else {
                myMin = numbers[0];
                myMax = numbers[1];
            }
            i = 2;
        } else {
            myMin = numbers[0];
            myMax = numbers[1];
            i = 1;
        }
        while (i < n - 1) {
            if (numbers[i] < numbers[i + 1]) {
                if (numbers[i] < myMin) {
                    myMin = numbers[i];
                }
                if (numbers[i + 1] > myMax) {
                    myMax = numbers[i + 1];
                }
            } else {
                if (numbers[i] > myMax) {
                    myMax = numbers[i];
                }
                if (numbers[i + 1] < myMin) {
                    myMin = numbers[i + 1];
                }
            }
            i += 2;
        }
        System.out.println(myMin + ", " + myMax);
        return (myMin + myMax) / 2.0;
    }
}

