package week11;

import java.io.*;

public class BinaryCopyEx {
	public static void main(String[] args) {
		String src = "/Users/machoney/Desktop/Miel.jpg";
		String dest = "copyimg.jpg";
		int c;
		try {
			FileInputStream fi = new FileInputStream(src);
			FileOutputStream fo = new FileOutputStream(dest);
			while ((c = fi.read()) != -1) {
				fo.write((byte) c);
			}
			fi.close();
			fo.close();
			System.out.println(src + "를 " + dest + "로 복사하였습니다.");
		} catch (IOException e) {
			System.out.println("IOException");
		}
	}
}
