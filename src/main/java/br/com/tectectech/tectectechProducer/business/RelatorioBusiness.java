package br.com.tectectech.tectectechProducer.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.tectectech.tectectechProducer.exception.ResponseBusinessException;
import br.com.tectectech.tectectechProducer.model.RelatorioModel;
import br.com.tectectech.tectectechProducer.repository.RelatorioRepository;

@Component
public class RelatorioBusiness {

	@Value("${rest.exception.business.invalid-ph}")
	private String invalidPh;

	@Autowired
	public RelatorioRepository relatorioRepository;

	public RelatorioModel applyBusiness(RelatorioModel relatorio) throws ResponseBusinessException {

		// #1
		verifyPhRelatorio(relatorio.getPhRelatorio());

		return relatorio;

	}

	// #1
	protected void verifyPhRelatorio(double ph) throws ResponseBusinessException {

		double phRelatorio = ph;

		if (phRelatorio < 0 || phRelatorio > 14) {
			throw new ResponseBusinessException(invalidPh);
		}
	}

}
