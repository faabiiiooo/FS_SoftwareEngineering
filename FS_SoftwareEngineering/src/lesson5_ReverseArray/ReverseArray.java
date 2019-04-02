package lesson5_ReverseArray;

public class ReverseArray {

    public static void main(String[] args){

        int[] myArray = {1,2,3,4,5};
        reverseArray(myArray,0);


    }

    private static void reverseArray(int[] myArray, int pos){

        if(pos >= myArray.length / 2){
            for(int i : myArray){
                System.out.println(i);
            }
        } else {
            int tmp = myArray[pos];
            myArray[pos]= myArray[myArray.length-1-pos];
            myArray[myArray.length-1-pos]=tmp;
            reverseArray(myArray, pos+1);
        }


    }
}
