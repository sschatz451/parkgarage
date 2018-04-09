package schatz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class parkplaetze {

	public static void main(String[] args) {
		String haupteingabe = loadInputData("TestDaten_Level1.1");
		String[] haupteingabea = haupteingabe.split(" ");
		String eingabel1 = (haupteingabea[0]) + " " + (haupteingabea[0]);
		String eingabel2 = "";
		for(int i = 2; i < haupteingabea.length-1; i++) {
			eingabel2 += haupteingabea[i];
		}
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
				platz[((autosi[i])*=-1)] = 0;
			}
			for(int c = 0; c < platz.length-1 ; c++) {
				if(platz[c]==1) {
					counter++;
				}
			}
			if(counter>max) {
				max = counter;
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
