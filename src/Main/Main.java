package Main;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import Confusion.Compare;
import Confusion.Constructor;
import Confusion.Matrix;
import Creator.TF_Generator;
import Creator.TF_IDF_Generator;
import Database.DB_Generator;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws IOException {
		
		//Generating Database
		
		//for (int i = 0; i < 10; i++) {
			
//			File diretorio = new File("Bases/Arquivo" + (i + 1));
//	        diretorio.mkdir();
//	        
//	        BufferedReader arqPositivas = new BufferedReader(new InputStreamReader(new FileInputStream("Base_Original_Positivas.txt"), "UTF-8"));
//	        BufferedReader arqNeutras = new BufferedReader(new InputStreamReader(new FileInputStream("Base_Original_Neutras.txt"), "UTF-8"));
//	        BufferedReader arqNegativas = new BufferedReader(new InputStreamReader(new FileInputStream("Base_Original_Negativas.txt"), "UTF-8"));
//
//			
////			FileReader arqPositivas = new FileReader("Base_Original_Positivas.txt");
////			FileReader arqNeutras = new FileReader("Base_Original_Neutras.txt");
////			FileReader arqNegativas = new FileReader("Base_Original_Negativas.txt");
//			
//			DB_Generator dbOperatorPos = new DB_Generator(arqPositivas);
//			DB_Generator dbOperatorNeu = new DB_Generator(arqNeutras);
//			DB_Generator dbOperatorNeg = new DB_Generator(arqNegativas);
//			
//			dbOperatorPos.genDatabase("Positivas_" + (i + 1), i + 1);
//			dbOperatorNeu.genDatabase("Neutras_" + (i + 1), i + 1);
//			dbOperatorNeg.genDatabase("Negativas_" + (i + 1), i + 1);
//			
//			FileReader testPositivas = new FileReader("Bases/Arquivo" + (i + 1) + "/Teste_Positivas_" + (i + 1) + ".txt");
//			FileReader testNeutras = new FileReader("Bases/Arquivo" + (i + 1) + "/Teste_Neutras_" + (i + 1)+ ".txt");
//			FileReader testNegativas = new FileReader("Bases/Arquivo" + (i + 1) + "/Teste_Negativas_" + (i + 1)+ ".txt");
//			
//			DB_Generator dbTest = new DB_Generator(testPositivas, testNeutras, testNegativas);
//			dbTest.mergeTest(i + 1);
//			
//		}
		
//		//Term Frequence solution
//		
//		FileReader wordsPositivas = new FileReader("TF/PositivasWordList.txt");
//		FileReader wordsNegative = new FileReader("TF/NegativasWordList.txt");
//		FileReader wordsTotal = new FileReader("TF/TotalWordList.txt");
//		
//		TF_Generator tfOperator = new TF_Generator(wordsPositivas, wordsTotal, wordsNegative);
//
//		tfOperator.getFrequence();
//		tfOperator.makeDictionary();
		
		//Term Frequence - Inverse Document Frequence solution
		
//		for (int i = 0; i < 10; i++) {
//
//			FileReader tfIdfPositivas = new FileReader("TF_IDF/Arquivo"+ (i + 1) +"/tf_idf_positivas.txt");
//			FileReader tfIdfNegativas = new FileReader("TF_IDF/Arquivo"+ (i + 1) +"/tf_idf_negativas.txt");
//			
//			TF_IDF_Generator tfIdfOperatorPos = new TF_IDF_Generator(tfIdfPositivas);
//			TF_IDF_Generator tfIdfOperatorNeg = new TF_IDF_Generator(tfIdfNegativas);
//			
//			tfIdfOperatorPos.makeDictionary("/new_words_positive.txt", "", i + 1);
//			tfIdfOperatorNeg.makeDictionary("/new_words_negative.txt", "-", i + 1);
//			
//		}
		
		
		
		//Discovering
		
//		for (int i = 0; i < 1; i++) {
//			File diretorio = new File("Matrix/Arquivo" + (i + 1));
//	        diretorio.mkdir();
//			
//			FileReader arq = new FileReader("Confusion/Arquivo"+ (i + 1) +"/Teste_"+ (i+1) +"+results_old.txt");
//			FileReader arq2 = new FileReader("Confusion/Arquivo"+ (i + 1) +"/Teste_"+ (i+1) +"+results_new.txt");
//
//			Compare com = new Compare(arq);
//			Compare com2 = new Compare(arq2);
//			
//			com.discoverPolarity(i + 1, "old");
//			com2.discoverPolarity(i + 1, "new");
//		}
		
		//Constructor
		
//		for (int i = 0; i < 1; i++) {
//			
//			FileReader arq = new FileReader("Bases/Arquivo"+ (i + 1) +"/Teste_"+ (i + 1) +".txt");
//			FileReader arq2 = new FileReader("Matrix/Arquivo"+ (i + 1) +"/Pol_Results_old_"+ (i + 1) +".txt");
//			FileReader arq3 = new FileReader("Matrix/Arquivo"+ (i + 1) +"/Pol_Results_new_"+ (i + 1) +".txt");
//			
//			Constructor cons = new Constructor(arq, arq2, arq3);
//			
//			cons.makeArchieve(i + 1);
//			
//		}
		
		//Matrix of Confusion
		
		for (int i = 0; i < 1; i++) {
			
			FileReader fin = new FileReader("Matrix/Arquivo"+ (i+1) +"/ori_x_old_"+ (i+1));
			FileReader fin2 = new FileReader("Matrix/Arquivo"+ (i+1) +"/ori_x_new_"+ (i+1));

		
			Matrix mat = new Matrix(fin);
		    Matrix mat2 = new Matrix(fin2);
			
			mat.makeConfusion(i + 1, "old");
			mat2.makeConfusion(i + 1, "new");
		}
		
	}

}