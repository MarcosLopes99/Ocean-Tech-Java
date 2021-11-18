package br.com.tectectech.tectectechProducer.business;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.tectectech.tectectechProducer.exception.ResponseBusinessException;
import br.com.tectectech.tectectechProducer.model.LocalidadeModel;
import br.com.tectectech.tectectechProducer.model.RelatorioModel;
import br.com.tectectech.tectectechProducer.repository.RelatorioRepository;

@SpringBootTest
public class RelatorioBusinessTest {

	@InjectMocks
	public RelatorioBusiness relatorioBusiness;

	@Mock
	public RelatorioRepository relatorioRepository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test(expected = ResponseBusinessException.class)
	public void testVerifyPhRelatorioMaior() throws ResponseBusinessException {
		
		// GIVEN
		float ph = 15;
		
		// WHEN
		relatorioBusiness.verifyPhRelatorio(ph);
		
	}
	
	@Test(expected = ResponseBusinessException.class)
	public void testVerifyPhRelatorioMenor() throws ResponseBusinessException {
		
		// GIVEN
		float ph = -1;
		
		// WHEN
		relatorioBusiness.verifyPhRelatorio(ph);
		
	}
	
	@Test
	public void testApplyBusiness() throws ResponseBusinessException {
		
		// GIVEN
		LocalidadeModel localidade = new LocalidadeModel();
		Date data = new Date(2001, 01, 01, 01, 01, 01);
		RelatorioModel relatorio = new RelatorioModel(1, localidade, data, 30, 5, 7, 10);
		RelatorioModel expected = new RelatorioModel(1, localidade, data, 30, 5, 7, 10);
		
		// WHEN
		Mockito.when(relatorioRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(relatorio));
		RelatorioModel actual = relatorioBusiness.applyBusiness(relatorio);
		
		// THEN
		assertEquals(expected.getIdRelatorio(), actual.getIdRelatorio());
		assertEquals(expected.getLocalidadeRelatorio(), actual.getLocalidadeRelatorio());
		assertEquals(expected.getDataRelatorio(), actual.getDataRelatorio());
		assertEquals(expected.getTemperaturaRelatorio(), actual.getTemperaturaRelatorio(), 0);
		assertEquals(expected.getProfundidaRelatorio(), actual.getProfundidaRelatorio(), 0);
		assertEquals(expected.getPhRelatorio(), actual.getPhRelatorio(), 0);
		assertEquals(expected.getOxigenioDissolvidoRelatorio(), actual.getOxigenioDissolvidoRelatorio(), 0);
		
	}
	
}
