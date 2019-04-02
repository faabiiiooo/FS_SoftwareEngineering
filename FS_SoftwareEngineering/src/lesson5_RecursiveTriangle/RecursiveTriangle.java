package lesson5_RecursiveTriangle;

public class RecursiveTriangle {

    public static void main(String[] args){

        System.out.println(calculateTriangle(5));

    }

    private static int calculateTriangle(int n){

        if(n == 1){
            return 1;
        } else {
           return n + calculateTriangle(n-1);
        }
    }
}
