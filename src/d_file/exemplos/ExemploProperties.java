package d_file.exemplos;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;

public class ExemploProperties {

	//um arquivo de propriedade tem o formato chave-valor 
	public static void escreveProperties() {
		Properties properties = new Properties();
		properties.setProperty("Usuario", "Ana");
		properties.setProperty("CorDeFundo", "Azul");
		properties.setProperty("LarguraTela", "200");
		properties.setProperty("AlturaTela", "400");
		
		try {
			FileWriter fw = new FileWriter("conf.properties");
			properties.store(fw, "ARQUIVO CONF PROPERTIES");
			
			fw.close();
		} catch (Exception e) {

		}
		
	}
	public static void lerArquivo() {
		Properties properties = new Properties();
		try {
			FileReader fr = new FileReader("conf.properties");
			properties.load(fr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String p1 = properties.getProperty("Usuario");
		String p2 = properties.getProperty("CorDeFundo");
		String p3 = properties.getProperty("LarguraTela");
		String p4 = properties.getProperty("AlturaTela");
		
		System.out.println(p1 + "\n" + p2 + "\n" + p3 + "\n" + p4);
	}
}
