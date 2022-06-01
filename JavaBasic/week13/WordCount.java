package week13;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class WordCount {
	public static void main(String[] args) {
		String stkTmp;
		int index;
		ArrayList<String> words = new ArrayList<>();
		ArrayList<Integer> wordCounter = new ArrayList<>();
		System.out.println("송치헌/컴퓨터공학과/12171637\n");

		try {
			BufferedReader reader = new BufferedReader(new FileReader("hw3.txt"));
			String line = reader.readLine();
			while (line != null) {
				StringTokenizer stk = new StringTokenizer(line, " ,.:;?![]()’");
				while(stk.hasMoreTokens()){
					stkTmp = stk.nextToken().toLowerCase();
					index = words.indexOf(stkTmp);
					if (index == -1){
						words.add(stkTmp);
						wordCounter.add(1);
					}else{
						wordCounter.set(index, wordCounter.get(index)+1);
					}
				}
				line = reader.readLine();
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter("hw3_out.txt", false));

			for(int i = 0 ; i < words.size(); i++) {
				writer.write(words.get(i)+"\t"+wordCounter.get(i));
				writer.newLine();
			}

			writer.flush();
			writer.close();
			reader.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
