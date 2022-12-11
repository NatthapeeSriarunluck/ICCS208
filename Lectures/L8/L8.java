package L8;


public class L8 {
    class DataOutOfBoundsException extends Exception{
        public DataOutOfBoundsException(String dataName){
            super("Data value" + dataName + "is out of bounds");
        }
    }
    /*
    int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(); //since we're "throwing" an object of an exception, we have to use the "new" keyword
        }
    }
     */
    void setAge(int age)
            throws DataOutOfBoundsException{  // we need to define "throws" because it is to say that this method has a possibility or an ability to throw an exception
        if (age <= 0 || age >= 200) {
            throw new DataOutOfBoundsException("age"); //it is possible to throw multiple exceptions
        }
    }
    public static void main(String[] args) {
        throw new ArithmeticException();
    }
}

