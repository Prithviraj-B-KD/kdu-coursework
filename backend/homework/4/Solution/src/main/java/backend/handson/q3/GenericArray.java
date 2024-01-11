package backend.handson.q3;

public class GenericArray {

    private GenericArray() {
        throw new IllegalStateException("Utility class");
    }
    public static <T>  void swap (T[] array, int index1 , int index2){
        if (index2 < 0 || index1 >= array.length || index1 < 0 || index2 >= array.length ){
            throw new IllegalArgumentException("Invalid Indices");
        }
      T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;

    }
}
