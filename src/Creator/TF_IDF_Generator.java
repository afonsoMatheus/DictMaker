package Creator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TF_IDF_Generator {
	
	public FileReader arq;
	
	public TF_IDF_Generator(FileReader arq){
		this.arq = arq;
	}

	public void makeDictionary(String name, String signal, int id) throws IOException{
		
		BufferedReader lerArq = new BufferedReader(this.arq);
		
		File arquivo1 = new File (name);
		FileWriter fw = new FileWriter( "TF_IDF/Arquivo"+ id + arquivo1 );
		BufferedWriter bw = new BufferedWriter( fw );
		
		String linha;
		int cont = 0;
		
		lerArq.mark(1000000);
		
		while ((linha = lerArq.readLine()) != null) {
			cont++;
		}
		
		lerArq.reset();
				
		String paragraph[][] = new String[cont][2];
		
		int i = 0;
		String a[];
		
		while ((linha = lerArq.readLine()) != null) {
			
			a = linha.split("\t");
			
			for (int j = 0; j < a.length; j++) {
				paragraph[i][j] = a[j];
			}
			i++;
		}
		
		Float high;
				
		high = Float.parseFloat(paragraph[0][1]);
				
		for (int j = 0; j < cont; j++) {
			
			Float num;
			
			num = 5*(Float.parseFloat(paragraph[j][1]))/high;
			
			if (num >= 0 && num < 3) {
				bw.write(paragraph[j][0] + "	" + signal + "2");
				bw.write("\n");
			}else{
				bw.write(paragraph[j][0] + "	" + signal  + num.intValue());
				bw.write("\n");
			}
			
		}
	 
		bw.close();
		fw.close();
	}
}
	

