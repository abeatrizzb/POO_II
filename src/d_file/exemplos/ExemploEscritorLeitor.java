package d_file.exemplos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class ExemploEscritorLeitor {

	public static void main(String[] args) {
		
		try {
			FileWriter fw = new FileWriter("teste.txt", false); //ao colocar false o que havia antes será substituído 
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 1; i <= 10; i++) {
				bw.append("linha: " + i + "\n");
			}
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			FileReader fr = new FileReader("teste.txt");
			BufferedReader br = new BufferedReader(fr);
			String linha;
			while((linha = br.readLine()) != null) {
				System.out.println(linha);
			}
			br.close();
		} catch (Exception e) {

		}
	}

}
