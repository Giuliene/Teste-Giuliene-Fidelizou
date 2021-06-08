package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import elementos.Rover;
import elementos.Terreno;

/**
 * @author Giuliene
 *
 */
public class ManipuladorDeArquivos {

	private String nomeArquivoLeitura, nomeArquivoDeEscrita;
	private ArrayList<Rover> rovers;

	/**
	 * construtor
	 * 
	 * @param nome do arquivo de entrada
	 * @param nome do arquivo de saida
	 */
	public ManipuladorDeArquivos(String entrada, String saida) {
		this.nomeArquivoLeitura = entrada;
		this.nomeArquivoDeEscrita = saida;
		this.rovers = new ArrayList<Rover>();
	}

	/**
	 * lê o arquivo e interpreta seu conteúdo
	 * 
	 * @throws IOException
	 * @throws IllegalAccessException
	 */
	public void interpretaArquivo() throws IOException, IllegalAccessException {
		int maxX, maxY, xRover, yRover;
		String linha;
		String[] linhaDividida;
		char direcao;

		BufferedReader b = new BufferedReader(new FileReader(nomeArquivoLeitura));
		linha = b.readLine();

		// coordenadas maximas do terreno
		linhaDividida = linha.split(" ");
		maxX = Integer.parseInt(linhaDividida[0]);
		maxY = Integer.parseInt(linhaDividida[1]);

		// cria um terreno
		Terreno terreno = new Terreno(maxX, maxY);

		// dados dos rovers
		linha = b.readLine();
		while (true) {
			if (linha != null) {
				linhaDividida = linha.split(" ");
				xRover = Integer.parseInt(linhaDividida[0]);
				yRover = Integer.parseInt(linhaDividida[1]);
				direcao = linhaDividida[2].charAt(0);

				Rover rover = new Rover(xRover, yRover, direcao);
				linha = b.readLine();
				char[] direcoes = linha.toCharArray();
				for (int i = 0; i < direcoes.length; i++) {
					switch (direcoes[i]) {
					case 'L':
						rover.girar(direcoes[i]);
						break;
					case 'R':
						rover.girar(direcoes[i]);
						break;
					case 'M':
						rover.mover(terreno);
						break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + direcoes[i]);
					}

				}
				rover.imprime();
				rovers.add(rover);
			} else {
				break;
			}
			linha = b.readLine();
		}
		b.close();
	}

	/**
	 * Escreve o resultado no arquivo de saída
	 * 
	 * @throws IOException
	 */
	public void escreve() throws IOException {

		// criando o arquivo de escrita
		FileWriter arq = new FileWriter(nomeArquivoDeEscrita);
		PrintWriter gravarArq = new PrintWriter(arq);

		//obtendo cada rover, recuperando sua posição e escrevendo no arquivo de saída
		Iterator<Rover> it = rovers.iterator();
		while (it.hasNext()) {
			Rover r = it.next();
			gravarArq.printf(r.getX() + " " + r.getY() + " " + r.getDirecao().getDirecaoAtual() + "%n");
		}
		arq.close();
	}

}
