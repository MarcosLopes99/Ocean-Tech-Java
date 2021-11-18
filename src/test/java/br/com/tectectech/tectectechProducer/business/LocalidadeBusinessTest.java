package br.com.tectectech.tectectechProducer.business;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.tectectech.tectectechProducer.exception.ResponseBusinessException;
import br.com.tectectech.tectectechProducer.model.LocalidadeModel;
import br.com.tectectech.tectectechProducer.repository.LocalidadeRepository;

@SpringBootTest
public class LocalidadeBusinessTest {

	@InjectMocks
	public LocalidadeBusiness localidadeBusiness;
	
	@Mock
	public LocalidadeRepository localidadeRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test(expected = ResponseBusinessException.class)
	public void testeVerifyNomeLocalidadeWithTest() throws ResponseBusinessException {
		
		// GIVEN
		String nome = "Localidade Teste";
		
		
		// WHEN
		localidadeBusiness.verifyNomeLocalidade(nome);
		
	}
	
	@Test
	public void testeVerifyNomeLocalidadeWithoutTest() throws ResponseBusinessException {
		
		// GIVEN
		String nome = "Localidade Normal";
		
		
		// WHEN
		localidadeBusiness.verifyNomeLocalidade(nome);
		
	}
	
	@Test
	public void testChangeFirstLetterToUpperCaseNomeLocalidade() {
		
		// GIVEN
		String nome = "santos";
		String expected = "Santos";
		
		// WHEN
		String actual = localidadeBusiness.changeFirstLetterToUpperCaseNomeLocalidade(nome);
		
		// THEN
		assertEquals("Erro ao transformar a primeira letra do nome em maiuscula", expected, actual);
		
	}
	
	@Test
	public void testChangeFirstLetterToUpperCasePaisLocalidade() {
		
		// GIVEN
		String pais = "brasil";
		String expected = "Brasil";
		
		// WHEN
		String actual = localidadeBusiness.changeFirstLetterToUpperCasePaisLocalidade(pais);
		
		// THEN
		assertEquals("Erro ao transformar a primeira letra do pais em maiuscula", expected, actual);
		
	}
	
	@Test
	public void testChangeFirstLetterToUpperCaseEstadoLocalidade() {
		
		// GIVEN
		String estado = "bahia";
		String expected = "Bahia";
		
		// WHEN
		String actual = localidadeBusiness.changeFirstLetterToUpperCaseEstadoLocalidade(estado);
		
		// THEN
		assertEquals("Erro ao transformar a primeira letra do estado em maiuscula", expected, actual);
		
	}
	
	@Test
	public void testApplyBusiness() throws ResponseBusinessException {
		
		// GIVEN
		LocalidadeModel localidade = new LocalidadeModel(1, "nome", "pais", "estado", "23° 32' 56'' Sul", "46° 38' 20'' Oeste");
		LocalidadeModel expected = new LocalidadeModel(1, "Nome", "Pais", "Estado", "23° 32' 56'' Sul", "46° 38' 20'' Oeste");
		
		// WHEN
		Mockito.when(localidadeRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(localidade));
		LocalidadeModel actual = localidadeBusiness.applyBusiness(localidade);
		
		// THEN
		assertEquals(expected.getIdLocalidade(), actual.getIdLocalidade());
		assertEquals(expected.getNomeLocalidade(), actual.getNomeLocalidade());
		assertEquals(expected.getPaisLocalidade(), actual.getPaisLocalidade());
		assertEquals(expected.getEstadoLocalidade(), actual.getEstadoLocalidade());
		assertEquals(expected.getLatitudeLocalidade(), actual.getLatitudeLocalidade());
		assertEquals(expected.getLongitudeLocalidade(), actual.getLongitudeLocalidade());
		
	}
	
}
