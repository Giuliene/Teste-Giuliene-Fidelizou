package elementos.test;

import org.junit.Assert;
import org.junit.Test;

import elementos.Rover;
import elementos.Terreno;

public class RoverTest {

	/**
	 * Verifica se a função mover funciona corretamente de acordo com as entradas
	 * fornecidas
	 * 
	 * @throws IllegalAccessException
	 */
	@Test
	public void testaMoverNosLimites() throws IllegalAccessException {
		Terreno terreno = new Terreno(10, 10);

		// mover para o norte
		Rover rover1 = new Rover(1, 1, 'N');
		rover1.mover(terreno);
		Assert.assertEquals(rover1.getX(), 1);
		Assert.assertEquals(rover1.getY(), 2);

		// mover para o sul
		Rover rover2 = new Rover(1, 1, 'S');
		rover2.mover(terreno);
		Assert.assertEquals(rover2.getX(), 1);
		Assert.assertEquals(rover2.getY(), 0);

		// mover para o oeste
		Rover rover3 = new Rover(1, 1, 'W');
		rover3.mover(terreno);
		Assert.assertEquals(rover3.getX(), 0);
		Assert.assertEquals(rover3.getY(), 1);

		// mover para o leste
		Rover rover4 = new Rover(1, 1, 'E');
		rover4.mover(terreno);
		Assert.assertEquals(rover4.getX(), 2);
		Assert.assertEquals(rover4.getY(), 1);
	}

	/**
	 * Verifica se a função mover lança uma excessão quando o rover ultrapassa os
	 * limites do terreno
	 * 
	 * @throws IllegalAccessException
	 */
	@Test(expected = IllegalAccessException.class)
	public void testaMoverForaDosLimites() throws IllegalAccessException {

		Terreno terreno = new Terreno(10, 10);

		// ultrapassando os limites ao norte
		Rover rover1 = new Rover(10, 10, 'N');
		rover1.mover(terreno);

		// ultrapassando os limites ao sul
		Rover rover2 = new Rover(0, 0, 'S');
		rover2.mover(terreno);

		// ultrapassando os limites a oeste
		Rover rover3 = new Rover(0, 0, 'W');
		rover3.mover(terreno);

		// ultrapassando os limites a leste
		Rover rover4 = new Rover(10, 10, 'E');
		rover4.mover(terreno);

	}
}
