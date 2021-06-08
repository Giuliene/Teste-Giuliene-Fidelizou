package elementos;

/**
 * 
 * @author Giuliene
 *
 */
public class Terreno {

	private int xMax, yMax;

	/**
	 * construtor
	 * 
	 * @param xMax
	 * @param yMax
	 */
	public Terreno(int xMax, int yMax) {
		this.xMax = xMax;
		this.yMax = yMax;
	}

	/**
	 * Verifica se o rover está dentro dos limites do terreno
	 * 
	 * @param rover lança uma excessao caso nao esteja dentro das medidas do terreno
	 * @throws IllegalAccessException
	 */
	public void verificaConformidadeLimites(Rover rover) throws IllegalAccessException {
		if ((rover.getX() <= xMax) && (rover.getY() <= yMax) && (rover.getX() >= 0) && (rover.getY() >= 0)) {
			return;
		} else {
			throw new IllegalAccessException("Rover excedeu os limites do terreno!");
		}
	}

	/**
	 * @return xMax
	 */
	public int getXMax() {
		return xMax;
	}

	/**
	 * @param xMax
	 */
	public void setXMax(int xMax) {
		this.xMax = xMax;
	}

	/**
	 * @return yMax
	 */
	public int getYMax() {
		return yMax;
	}

	/**
	 * @param yMax
	 */
	public void setYMax(int yMax) {
		this.yMax = yMax;
	}

}
