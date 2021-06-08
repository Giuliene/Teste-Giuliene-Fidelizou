package main;

import java.io.IOException;

import util.ManipuladorDeArquivos;

/**
 * 
 * @author Giuliene
 *
 */
public class Main {

	/*
	 * altere aqui o nome do seu arquivo de entrada
	 */
	public static final String NOME_ARQUIVO_ENTRADA = "entrada.txt";
	public static final String NOME_ARQUIVO_SAIDA = "saida.txt";

	/**
	 * Lê o arquivo de entrada, interpreta e escreve o resultado no arquivo de saída
	 */
	public static void main(String[] args) throws IOException, IllegalAccessException {
		ManipuladorDeArquivos m = new ManipuladorDeArquivos(NOME_ARQUIVO_ENTRADA, NOME_ARQUIVO_SAIDA);
		m.interpretaArquivo();
		m.escreve();
	}
}
