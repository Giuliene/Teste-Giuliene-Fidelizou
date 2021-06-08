package elementos.test;

import org.junit.Test;

import elementos.Rover;
import elementos.Terreno;

public class TerrenoTest {

	/**
	 * Testa se a função verificaConformidade lança uma excessão nos casos
	 * inválidos (fora dos limites do terreno)
	 * 
	 * @throws IllegalAccessException
	 */
	@Test(expected = IllegalAccessException.class)
	public void testaForaDosLimites() throws IllegalAccessException {

		Terreno terreno = new Terreno(10, 10);

		// ultrapassando os limites ao norte
		Rover rover1 = new Rover(11, 10, 'N');
		terreno.verificaConformidadeLimites(rover1);

		// ultrapassando os limites ao sul
		Rover rover2 = new Rover(0, -1, 'S');
		terreno.verificaConformidadeLimites(rover2);

		// ultrapassando os limites a oeste
		Rover rover3 = new Rover(-1, 0, 'W');
		terreno.verificaConformidadeLimites(rover3);

		// ultrapassando os limites a leste
		Rover rover4 = new Rover(11, 10, 'E');
		terreno.verificaConformidadeLimites(rover1);

	}
}
