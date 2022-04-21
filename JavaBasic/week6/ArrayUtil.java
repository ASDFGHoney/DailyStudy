package week6;

public class ArrayUtil {
	public static int[] concat(int[] arr1, int[] arr2) {
		int[] concatedArr = new int[arr1.length + arr2.length];
		for (int i = 0; i < arr1.length; i++) {
			concatedArr[i] = arr1[i];
		}
		for (int i = 0; i < arr2.length ; i++) {
			concatedArr[arr1.length+i] = arr2[i];
		}

		return concatedArr;
	}

	public static void print(int[] arr){
	}
}
