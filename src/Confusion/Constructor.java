package Confusion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Constructor {

	public FileReader arqOri;
	public FileReader arqOld;
	public FileReader arqNew;


	public Constructor(FileReader arqOri, FileReader arqOld, FileReader arqNew){
		this.arqOri = arqOri;
		this.arqOld = arqOld;
		this.arqNew = arqNew;
	}
	
	public void makeArchieve(int num) throws IOException{
		BufferedReader lerArq = new BufferedReader(this.arqOri);
		BufferedReader lerArq2 = new BufferedReader(this.arqOld);
		BufferedReader lerArq3 = new BufferedReader(this.arqNew);
		
		File arquivo1 = new File ("Matrix/Arquivo"+ (num) +"/ori_x_old_" + num);
		FileWriter fw = new FileWriter(arquivo1);
		BufferedWriter bw = new BufferedWriter( fw );
		
		File arquivo2 = new File ("Matrix/Arquivo"+ (num) +"/ori_x_new_" + num);
		FileWriter fw2 = new FileWriter(arquivo2);
		BufferedWriter bw2 = new BufferedWriter( fw2 );
		
		String linha;
		String linha2;
		String linha3;

		
		int cont = 0;
		
		lerArq.mark(1000000);
		
		while ((linha = lerArq.readLine()) != null) {
			cont++;
		}
		
		lerArq.reset();
				
		String paragraph[][] = new String[cont][3];
		
		int i = 0;
		int j = 0;
		int k = 0;

		String a[];
		
		while ((linha = lerArq.readLine()) != null) {
			
			a = linha.split("	");
						
			paragraph[i][0] = a[1];
			
			i++;
		}
		
		while ((linha2 = lerArq2.readLine()) != null) {
			
			System.out.println(i);
						
			paragraph[j][1] = linha2;
			
			j++;
			
		}
		
		while ((linha3 = lerArq3.readLine()) != null) {
			
			paragraph[k][2] = linha3;
			
			k++;
			
		}
		
		for (int l = 0; l < paragraph.length; l++) {
			
			bw.write(paragraph[l][0] + "\t" + paragraph[l][1]);
			bw.write("\n");
			
		}
		
		for (int m = 0; m < paragraph.length; m++) {
			
			bw2.write(paragraph[m][0] + "\t" + paragraph[m][2]);
			bw2.write("\n");
			
		}
		
		bw.close();
		bw2.close();
				
	}

}
