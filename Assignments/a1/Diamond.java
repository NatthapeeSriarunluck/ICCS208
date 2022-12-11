public class Diamond {
    public static void printDiamond(int k){
        for (int i=1;i<=k;i++){
            for (int j=0; j<k+1-i;j++) {
                System.out.print('#');
            }
            for (int j=0;j<2*i-1;j++){
                System.out.print('*');
            }
            for (int j=0; j<k+1-i;j++){
                System.out.print('#');
            }
            System.out.printf("%n");
        }
        for (int i=k-1;i>0;i--){
            for (int j=0; j< k+1-i;j++) {
                System.out.print('#');
            }
            for (int j=0;j<2*i-1;j++){
                System.out.print('*');
            }
            for (int j=0; j<k+1-i;j++){
                System.out.print('#');
            }
            System.out.printf("%n");
        }
    }
}

