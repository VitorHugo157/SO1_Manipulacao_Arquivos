package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.ArquivosController;
import controller.IArquivosController;

public class Principal {

	public static void main(String[] args) {

		IArquivosController arqCont = new ArquivosController();
		String path = "C:\\Users\\f-win\\OneDrive\\Documentos\\Fatec\\3º Semestre\\SO1\\Manipulacao Arquivos";
		String nome = "relatorio.txt";
		int opc = -1;
		while(opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Ler arquivo relatorio.txt \n2 - Gerar arquivo relatorio.csv \n9 - Finalizar"));
			switch(opc) {
			case 1:
				try {
					arqCont.readFile(path, nome);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
			case 2:
				try {
					arqCont.arquivoTxtToCsv(path, nome);
					int opc1 = -1;
					while(opc1 != 0) {
						opc1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Arquivo CSV gerado com sucesso. Deseja abri-lo? \n1 - Sim \n0 - Não"));
						switch(opc1) {
						case 1:
							try {
								arqCont.openFile(path, nome.replace(".txt", ".csv"));
							} catch (Exception e) {
								e.printStackTrace();
							}
							return; // para finalizar o programa
							
						case 0:
							break;
							
						default:
							JOptionPane.showMessageDialog(null, "Opção inválida!");
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
			case 9:
				break;
				
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida!");
			}
		}
	}

}