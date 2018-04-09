package schatz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class parkplaetze {

	public static void main(String[] args) {
		String eingabel1 = "100 20";
		String eingabel2 = "19 -19 11 -11 1 -1 17 -17 10 7 -10 -7 3 14 -14 -3 13 -13 4 12 20 18 6 16 -18 -12 -16 5 -5 -20 -6 -4 8 15 -8 2 -15 9 -2 -9";
		String[] eingabe = eingabel1.split(" ");
		String[] autos = eingabel2.split(" ");
		int max = 0;
		int n = Integer.parseInt(eingabe[0]);
		int m = Integer.parseInt(eingabe[1]);
		int[] platz = new int[2000];
		int[] autosi = new int[autos.length];
		for(int i= 0; i < autos.length-1; i++) {
			autosi[i] = Integer.parseInt(autos[i]);
		}
		for(int i = 0; i < autosi.length-1; i++) {
			int counter = 0;
			if(autosi[i]>0) {
				platz[autosi[i]] = 1;
			} else {
				platz[(autosi[i])*=-1] = 0;
			}
			for(int c = 0; c < platz.length-1 ; c++) {
				if(platz[c]==1) {
					counter++;
				}
			}
			if(counter>max) {
				counter = max;
			}
		}
		
		
			
		
System.out.println(max);
	}
	public static String loadInputData(String datName) {
		String fileData = "";
		File file = new File(datName);

		if (!file.canRead() || !file.isFile()) {
			return "";
		}
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(datName));
			String zeile = null;
			while ((zeile = in.readLine()) != null) {
				fileData += zeile+"\r\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return fileData;
	}
}
