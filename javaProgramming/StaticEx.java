class ArrayUtil {
    public static int[] concat(int[] a, int[] b){
        int tmp[] = new int [a.length + b.length];
        for(int i=0 ; i < a.length; i++)
            tmp[i] = a[i];

        for(int i = 0; i < b.length ; i++)
    }
}

public class StaticEx{
    public static void main(String[] args) {
        int [] array1 = {1,5,7,9};
        int [] array2 = {3,6,-1,100,77};
        int [] array3 = ArrayUtil.concat(a, b);
    }
}