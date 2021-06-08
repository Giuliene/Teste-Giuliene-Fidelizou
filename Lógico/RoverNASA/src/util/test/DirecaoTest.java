package util.test;

import org.junit.Assert;
import org.junit.Test;

import util.Direcao;

/**
 * @author Giuliene
 *
 */
public class DirecaoTest {

	/**
	 * verifica se o rover � girado corretamente
	 */
	@Test
	public void testeGirarCorretamente() {
		Direcao direcao = new Direcao('N');
		
		direcao.girar('L');
		Assert.assertEquals('W', direcao.getDirecaoAtual());

		direcao.girar('R');
		Assert.assertEquals('N', direcao.getDirecaoAtual());
		
	}
	
	/**
	 * verifica se a fun��o lan�a uma excess�o quando passado par�metros n�o aceitos
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testeGirarErrado() {
		
		Direcao direcao = new Direcao('N');
				
		direcao.girar('A');
	}
}
