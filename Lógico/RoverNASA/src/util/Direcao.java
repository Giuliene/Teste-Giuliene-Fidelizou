package util;

public class Direcao {

	private char direcaoAtual;

	/**
	 * construtor
	 * 
	 * @param direcao_atual
	 */
	public Direcao(char direcao_atual) {
		this.direcaoAtual = direcao_atual;
	}

	/**
	 * gira para o lado espefificado de acordo com os quatro pontos cardeais da
	 * bússola
	 * 
	 * @param lado
	 */
	public void girar(char lado) {
		char[] bussola = { 'N', 'E', 'S', 'W' };
		int posicao = 0;
		for (int i = 0; i < 4; i++) {
			if (direcaoAtual == bussola[i]) {
				posicao = i;
				break;
			}
		}
		// girar para a direita
		if (lado == 'R') {
			posicao++;
		} else if (lado == 'L') { // girar para a esquerda
			posicao--;
			posicao = posicao + 4;
		} else {
			throw new IllegalArgumentException("Unexpected value: " + lado);
		}
		direcaoAtual = bussola[posicao % 4];
	}

	/**
	 * @return direcaoAtual
	 */
	public char getDirecaoAtual() {
		return direcaoAtual;
	}

	/**
	 * @param direcaoAtual
	 */
	public void setDirecaoAtual(char direcaoAtual) {
		this.direcaoAtual = direcaoAtual;
	}

}
