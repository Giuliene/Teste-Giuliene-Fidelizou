/**
 * 
 */
package elementos;

import util.Direcao;

/**
 * @author Giuliene
 *
 */
public class Rover {
	private int x, y;
	private Direcao direcao;

	/**
	 * construtor
	 * 
	 * @param x
	 * @param y
	 * @param direcao
	 */
	public Rover(int x, int y, char direcao) {
		this.x = x;
		this.y = y;
		this.direcao = new Direcao(direcao);
	}

	/**
	 * Gira o rover para o lado especificado
	 * 
	 * @param lado
	 */
	public void girar(char lado) {
		direcao.girar(lado);
	}

	/**
	 * move o rover em 1 unidade na direção em que ele estiver, verificando para que
	 * ele não ultrapasse os limites do terreno
	 * 
	 * @param terreno
	 * @throws IllegalAccessException
	 */
	public void mover(Terreno terreno) throws IllegalAccessException {
		switch (direcao.getDirecaoAtual()) {
		case 'N':
			this.y++;
			break;
		case 'S':
			this.y--;
			break;
		case 'W':
			this.x--;
			break;
		case 'E':
			this.x++;
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + direcao);
		}
		terreno.verificaConformidadeLimites(this);
	}

	/**
	 * imprime as coordenadas e a direção atual do rover
	 */
	public void imprime() {
		System.out.println("x = " + x + ", y = " + y + ", direcao = " + direcao.getDirecaoAtual());
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return direcao
	 */
	public Direcao getDirecao() {
		return direcao;
	}

	/**
	 * @param direcao direcao
	 */
	public void setDirecao(Direcao direcao) {
		this.direcao = direcao;
	}

}
