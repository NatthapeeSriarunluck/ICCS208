package L2;

public class Lecture2{
    
    public static int maxFullFor(int[] numbers){
        int maxSofar = numbers[0];
        for (int index = 1; index < numbers.length;index++){
            if (numbers[index] > maxSofar){
                maxSofar = numbers[index]; 
            }
        }
        return maxSofar;
    }         
}

//
