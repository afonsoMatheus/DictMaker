package Database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class DB_Generator {

	public BufferedReader arqTreinamento;
	public FileReader arqTeste1;
	public FileReader arqTeste2;
	public FileReader arqTeste3;

	public DB_Generator(BufferedReader arqTreinamento) {
		this.arqTreinamento = arqTreinamento;
	}

	public DB_Generator(FileReader arqTeste1, FileReader arqTeste2, FileReader arqTeste3) {
		this.arqTeste1 = arqTeste1;
		this.arqTeste2 = arqTeste2;
		this.arqTeste3 = arqTeste3;
	}

	public void genDatabase(String name, int num) throws IOException {

		BufferedReader lerArq = this.arqTreinamento;
        OutputStreamWriter bw1 = new OutputStreamWriter(new FileOutputStream("Bases/Arquivo" + num + "/Treinamento_" + name + ".txt"),"UTF-8");


//		File arquivo1 = new File("Bases/Arquivo" + num + "/Treinamento_" + name + ".txt");
//		FileWriter fw1 = new FileWriter(arquivo1);
//		BufferedWriter bw1 = new BufferedWriter(fw1);

		File arquivo2 = new File("Bases/Arquivo" + num + "/Teste_" + name + ".txt");
		FileWriter fw2 = new FileWriter(arquivo2);
		BufferedWriter bw2 = new BufferedWriter(fw2);

		String linha;

		ArrayList<String> list = new ArrayList<>();

		while ((linha = lerArq.readLine()) != null) {

			list.add(linha);

		}

		Collections.shuffle(list);

		showData(list);

		genDocument(bw1, bw2, list);

		bw1.close();
		bw2.close();
	}

	public void genDocument(OutputStreamWriter bw1, BufferedWriter bw2, ArrayList<String> list) throws IOException {

		for (int i = 0; i < list.size(); i++) {

			if (i < list.size() * 0.75) {
				bw1.write(list.get(i));
				bw1.write("\n");
			} else {
				bw2.write(list.get(i));
				bw2.write("\n");
			}

		}
	}

	public void genDocument(BufferedWriter bw1, ArrayList<String> list) throws IOException {

		for (int i = 0; i < list.size(); i++) {

			bw1.write(list.get(i));
			bw1.write("\n");

		}
	}

	public void mergeTest(int num) throws IOException {
		BufferedReader lerArq1 = new BufferedReader(this.arqTeste1);
		BufferedReader lerArq2 = new BufferedReader(this.arqTeste2);
		BufferedReader lerArq3 = new BufferedReader(this.arqTeste3);

		File arquivo1 = new File("Bases/Arquivo" + num + "/Teste_"+ num +".txt");
		FileWriter fw1 = new FileWriter(arquivo1);
		BufferedWriter bw1 = new BufferedWriter(fw1);

		String linha;

		ArrayList<String> list = new ArrayList<>();

		while ((linha = lerArq1.readLine()) != null) {

			list.add(linha + "\t" + "Positivo");

		}

		while ((linha = lerArq2.readLine()) != null) {

			list.add(linha + "\t" + "Neutra");
		}

		while ((linha = lerArq3.readLine()) != null) {

			list.add(linha+ "\t" + "Negativo");
		}

		genDocument(bw1, list);
		
		bw1.close();

	}

	public void showData(ArrayList<String> list) {
		System.out.println("Total:" + list.size());
		System.out.println("Treinamento:" + list.size() * 0.75);
		System.out.println("Teste:" + list.size() * 0.25);
		System.out.println();
	}

}
