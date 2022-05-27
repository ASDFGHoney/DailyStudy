package week13;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WordCount {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Source file name: ");
		String src = sc.next();
		System.out.print("Dest file name: ");
		String dest = sc.next();
		int c;
		byte[] buf = new byte[1024];
		try {
			FileInputStream fi = new FileInputStream(src);
			FileOutputStream fo = new FileOutputStream(dest);
			c = fi.read(buf);
			do {
				fo.write(buf);
				c = fi.read(buf);
			} while (c == 1024);
			fi.close();
			fo.close();
			System.out.println("ms : "+src + "를 " + dest + "로 복사하였습니다.");
		} catch (IOException e) {
			System.out.println("파일 복사 오류");
		}
	}
}
