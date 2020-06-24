package controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ArquivosController implements IArquivosController{

	public void arquivoTxtToCsv(String path, String nome) throws IOException {
		File arqTxt = new File(path, nome);
		File arqCsv = new File(path, nome.replace(".txt", ".csv"));
		File dir = new File(path);
		if (dir.exists() && dir.isDirectory()) {
			if (arqTxt.exists()) {
				
				// lendo o Conteúdo do arquivo TXT
				FileInputStream fluxo = new FileInputStream(arqTxt);
				InputStreamReader reader = new InputStreamReader(fluxo, "UTF-8");
				BufferedReader buffer = new BufferedReader(reader);
				String linha = buffer.readLine();
				String conteudo = "";
				while (linha != null) {
					linha = linha.replace(" ", ";"); // para separar cada palavra em uma célula
					conteudo += (linha + "\n");
					linha = buffer.readLine();
				}
				buffer.close();
				reader.close();
				fluxo.close();
				
				// escrevendo o Conteúdo no arquivo CSV
				FileWriter fileWriter = new FileWriter(arqCsv);
				PrintWriter print = new PrintWriter(fileWriter);
				print.write(conteudo);
				print.flush();
				print.close();
				fileWriter.close();
			}else {
				throw new IOException("Arquivo não existe !");
			}
		}else {
			throw new IOException("Diretório inválido !");
		}
	}
	
	@Override
	public void readFile(String path, String nome) throws IOException {
		File arq = new File(path, nome);
		if(arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo, "UTF-8");
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha != null) { //procurando EOF
				System.out.println(linha);
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		}else {
			throw new IOException("Arquivo inválido");
		}
	}
	
	@Override
	public void openFile(String path, String nome) throws IOException {
		File arqCsv = new File(path, nome);
		if(arqCsv.exists() && arqCsv.isFile()) {
			Desktop desktop = Desktop.getDesktop();
			desktop.open(arqCsv);
		}else {
			throw new IOException("Arquivo inválido");
		}
	}
}

