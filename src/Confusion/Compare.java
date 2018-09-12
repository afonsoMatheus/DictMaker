package Confusion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Compare {
	
	public FileReader arqTeste;
	
	
	public Compare(FileReader arqTeste){
		this.arqTeste = arqTeste;
	}
	
	public void discoverPolarity(int num, String name) throws IOException{
		
		BufferedReader lerArq = new BufferedReader(this.arqTeste);
		
		File arquivo1 = new File ("Matrix/Arquivo"+ num +"/Pol_Results_" + name + "_" + num +".txt");
		FileWriter fw = new FileWriter( arquivo1 );
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
			
			a = linha.split("	");
			
			for (int j = 0; j < a.length; j++) {
				paragraph[i][j] = a[j];
			}
			i++;
		}
					
		for (int j = 0; j < paragraph.length; j++) {
			if (Integer.parseInt(paragraph[j][2]) > -Integer.parseInt(paragraph[j][3])) {
				bw.write("Positivo");
				bw.newLine();
			}
			if(Integer.parseInt(paragraph[j][2]) < -Integer.parseInt(paragraph[j][3])){
				bw.write("Negativo");
				bw.newLine();
			}
			if(Integer.parseInt(paragraph[j][2]) == -Integer.parseInt(paragraph[j][3])){
				bw.write("Neutra");
				bw.newLine();
			}
		}
		
		bw.close();
		fw.close();
		lerArq.close();
	
	}
	
	

}
