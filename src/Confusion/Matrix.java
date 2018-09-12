package Confusion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Matrix {
	
	public FileReader arqCompare;
	
	public Matrix(FileReader arqCompare){
		this.arqCompare = arqCompare;
	}
	
	public void makeConfusion(int num, String name) throws IOException{
		
		int PP = 0, PN = 0, PNeg = 0;
		int NP = 0, NN = 0, NNeg = 0;
		int NegP = 0, NegN = 0, NegNeg = 0;
		
		BufferedReader lerArq = new BufferedReader(this.arqCompare);
		
		File arquivo1 = new File ("Matrix/Arquivo"+ num + "/cabou_" + name +"_"+ num +".txt");
		FileWriter fw = new FileWriter( arquivo1 );
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
			
			a = linha.split("	");
			
			for (int j = 0; j < a.length; j++) {
				paragraph[i][j] = a[j];
			}
			i++;
		}
				
		for (int j = 0; j < paragraph.length; j++) {
						
			if (paragraph[j][0].equals("Positivo") && paragraph[j][1].equals("Positivo")) {
				PP++;
			}
			if (paragraph[j][0].equals("Positivo") && paragraph[j][1].equals("Neutra")) {
				PN++;
			}
			if (paragraph[j][0].equals("Positivo") && paragraph[j][1].equals("Negativo")) {
				PNeg++;
			}
			
			if (paragraph[j][0].equals("Neutra") && paragraph[j][1].equals("Positivo")) {
				NP++;
			}
			if (paragraph[j][0].equals("Neutra") && paragraph[j][1].equals("Neutra")) {
				NN++;
			}
			if (paragraph[j][0].equals("Neutra") && paragraph[j][1].equals("Negativo")) {
				NNeg++;
			}
			
			if (paragraph[j][0].equals("Negativo") && paragraph[j][1].equals("Positivo")) {
				NegP++;
			}
			if (paragraph[j][0].equals("Negativo") && paragraph[j][1].equals("Neutra")) {
				NegN++;
			}
			if (paragraph[j][0].equals("Negativo") && paragraph[j][1].equals("Negativo")) {
				NegNeg++;
			}
			
		}
		
		bw.write(PP + "\t" + NP + "\t" + NegP);
		bw.newLine();
		bw.write(PN + "\t" + NN + "\t" + NegN);
		bw.newLine();
		bw.write(PNeg + "\t" + NNeg + "\t" + NegNeg);
		bw.newLine();
		bw.newLine();
		
		bw.write("Acur�cia: " + (100*(PP + NN + NegNeg))/cont + "%");
		bw.newLine();
		bw.newLine();
		
		bw.write("Cobertura Positiva: " + (100*PP)/(PP + PN + PNeg) + "%");
		bw.newLine();
		bw.write("Cobertura Neutra: " + (100*NN)/(NP + NN + NNeg) + "%");
		bw.newLine();
		bw.write("Cobertura Negativa: " + (100*NegNeg)/(NegP + NegN + NegNeg) + "%");
		bw.newLine();
		bw.newLine();
		
		bw.write("Precis�o Positiva: " + (100*PP)/(PP + NP + NegP) + "%");
		bw.newLine();
		bw.write("Precis�o Neutra: " + (100*NN)/(PN + NN + NegN) + "%");
		bw.newLine();
		bw.write("Precis�o Negativa: " + (100*NegNeg)/(PNeg + NNeg + NegNeg) + "%");
		bw.newLine();
		bw.newLine();
		
		bw.write("Recall Positiva: " + (100*PP)/(PP + PN + PNeg) + "%");
		bw.newLine();
		bw.write("Recall Neutra: " + (100*NN)/(NP + NN + NNeg) + "%");
		bw.newLine();
		bw.write("Recall Negativa: " + (100*NegNeg)/(NegP + NegN + NegNeg) + "%");
		bw.newLine();
		bw.newLine();
		
		float precPositivo = (100*PP)/(PP + NP + NegP);
		float precNeutra = (100*NN)/(PN + NN + NegN);
		float precNegativo = (100*NegNeg)/(PNeg + NNeg + NegNeg);
		
		float recallPositivo = (100*PP)/(PP + PN + PNeg);
		float recallNeutra = (100*NN)/(NP + NN + NNeg);
		float recallNegativo = (100*NegNeg)/(NegP + NegN + NegNeg);
		
		bw.write("F-Measure Positiva: " + 2*(1/((1/precPositivo) + (1/recallPositivo))) + "%");
		bw.newLine();
		bw.write("F-Measure Neutra: " + 2*(1/((1/precNeutra) + (1/recallNeutra))) + "%");
		bw.newLine();
		bw.write("F-Measure Negativa: " + 2*(1/((1/precNegativo) + (1/recallNegativo))) + "%");
		bw.newLine();
		bw.newLine();
				
		bw.close();
		fw.close();
		
		lerArq.close();
		
	}

}
