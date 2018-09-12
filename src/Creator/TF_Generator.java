package Creator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TF_Generator {
	public FileReader arqPositive;
	public FileReader arqTotal;
	public FileReader arqNegative;
	public FileReader arqResult;
	
	public TF_Generator(FileReader arqPositive, FileReader arqTotal, FileReader arqNegative){
		this.arqPositive = arqPositive;
		this.arqTotal = arqTotal;
		this.arqNegative = arqNegative;
	}
	
	public void makeDictionary() throws IOException{
		
		BufferedReader lerArq = new BufferedReader(this.arqResult);
		
		File arquivo1 = new File ("new_words_TF.txt");
		FileWriter fw = new FileWriter("TF\\" + arquivo1 );
		BufferedWriter bw = new BufferedWriter( fw );
		
		String linha;
		int cont = 0;
		
		lerArq.mark(1000000);
		
		while ((linha = lerArq.readLine()) != null) {
			cont++;
		}
		
		lerArq.reset();
				
		String paragraph[][] = new String[cont][4];
		
		int i = 0;
		String a[];
		
		while ((linha = lerArq.readLine()) != null) {
			
			a = linha.split(" ");
			
			for (int j = 0; j < a.length; j++) {
				paragraph[i][j] = a[j];
			}
			i++;
		}
				
		for (int j = 0; j < paragraph.length; j++) {
			
			Float medP, medN;
			
			medP = Float.parseFloat(paragraph[j][2])/Float.parseFloat(paragraph[j][1]);
			medN = Float.parseFloat(paragraph[j][3])/Float.parseFloat(paragraph[j][1]);
			
			if (medP > medN) {
				medP = medP*5;
				if (medP.intValue() != 0) {
					bw.write(paragraph[j][0] + "	" + medP.intValue());
					bw.write("\n");
				}
			}else{
				medN = medP*-5;
				if (medN.intValue() != 0) {
					bw.write(paragraph[j][0] + "	" + medN.intValue());
					bw.write("\n");

				}
				
			}
		}
	 
		bw.close();
		fw.close();
	}
	
	public void getFrequence() throws IOException{

		BufferedReader lerArq = new BufferedReader(this.arqTotal);
		
		BufferedReader lerArq2 = new BufferedReader(this.arqPositive);
		
		BufferedReader lerArq3 = new BufferedReader(this.arqNegative);
				
		String principal[][] = new String[tam(lerArq)][4];
		String positivas[][] = new String[tam(lerArq2)][2];
		String negativas[][] = new String[tam(lerArq3)][2];
		
		principal = construct(lerArq, principal);
		positivas = construct(lerArq2, positivas);
		negativas = construct(lerArq3, negativas);
				
		File arquivo1 = new File ("frequence_relation.txt");
		FileWriter fw = new FileWriter( "TF\\" + arquivo1 );
		BufferedWriter bw = new BufferedWriter( fw );
		
		for (int i = 0; i < principal.length; i++) {
			for (int j = 0; j < positivas.length; j++) {
				if (principal[i][0].equals(positivas[j][0])) {
					principal[i][2] = positivas[j][1];
				}
				if (j == positivas.length-1 && principal[i][2] == null) {
					principal[i][2] = "0";
				}
			}
		}
				
		for (int i = 0; i < principal.length; i++) {
			for (int j = 0; j < negativas.length; j++) {
				if (principal[i][0].equals(negativas[j][0])) {
					principal[i][3] = negativas[j][1];
				}
				if (j == negativas.length-1 && principal[i][3] == null) {
					principal[i][3] = "0";
				}
			}
		}
				
		for (int i = 0; i < principal.length; i++) {
			for (int j = 0; j < 4; j++) {
				bw.write((principal[i][j]) + " ");
			}
			bw.newLine();
		}
		
		bw.close();
		fw.close();
		
		this.arqResult = new FileReader("TF\\frequence_relation.txt");
		
	}
	
	public static int tam(BufferedReader lerArq) throws IOException {

		@SuppressWarnings("unused")
		String linha;
		int cont = 0;

		lerArq.mark(1000000);

		while ((linha = lerArq.readLine()) != null) {
			cont++;
		}

		lerArq.reset();

		return cont;

	}

	public static String[][] construct(BufferedReader lerArq, String[][] mat) throws IOException {

		String linha;
		int i = 0;
		String a[];

		while ((linha = lerArq.readLine()) != null) {

			a = linha.split("\t");

			for (int j = 0; j < a.length; j++) {
				mat[i][j] = a[j];
			}
			i++;
		}

		return mat;
	}

}
