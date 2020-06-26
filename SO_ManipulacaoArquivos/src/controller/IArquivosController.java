package controller;

import java.io.IOException;

public interface IArquivosController {
	public void verificaDirTemp(String path) throws IOException;
	public boolean verificaRegistro(String path, String arquivo, int codigo) throws IOException;
	public void imprimeCadastro(String path, String arquivo, int codigo) throws IOException;
	public void insereCadastro(String path, String arquivo, int codigo, String nome, String email) throws IOException;
}
