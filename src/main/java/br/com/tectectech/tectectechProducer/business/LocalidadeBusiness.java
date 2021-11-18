package br.com.tectectech.tectectechProducer.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.tectectech.tectectechProducer.exception.ResponseBusinessException;
import br.com.tectectech.tectectechProducer.model.LocalidadeModel;
import br.com.tectectech.tectectechProducer.repository.LocalidadeRepository;

@Component
public class LocalidadeBusiness {

	@Value("${rest.exception.business.contains-teste}")
	private String containsTeste;

	@Autowired
	public LocalidadeRepository localidadeRepository;

	public LocalidadeModel applyBusiness(LocalidadeModel localidade) throws ResponseBusinessException {

		// #1
		verifyNomeLocalidade(localidade.getNomeLocalidade());

		// #2
		String nome = changeFirstLetterToUpperCaseNomeLocalidade(localidade.getNomeLocalidade());
		localidade.setNomeLocalidade(nome);

		// #3
		String pais = changeFirstLetterToUpperCasePaisLocalidade(localidade.getPaisLocalidade());
		localidade.setPaisLocalidade(pais);

		// #4
		String estado = changeFirstLetterToUpperCaseEstadoLocalidade(localidade.getEstadoLocalidade());
		localidade.setEstadoLocalidade(estado);

		return localidade;

	}

	// #1
	protected void verifyNomeLocalidade(String nome) throws ResponseBusinessException {

		String nomeLocalidade = nome.toUpperCase();

		if (nomeLocalidade.contains("TESTE")) {
			throw new ResponseBusinessException(containsTeste);
		}
	}

	// #2
	protected String changeFirstLetterToUpperCaseNomeLocalidade(String nome) {
		String nomeLocalidade = nome;
		nomeLocalidade = nomeLocalidade.substring(0, 1).toUpperCase() + nomeLocalidade.substring(1);
		return nomeLocalidade;
	}

	// #3
	protected String changeFirstLetterToUpperCasePaisLocalidade(String pais) {
		String paisLocalidade = pais;
		paisLocalidade = paisLocalidade.substring(0, 1).toUpperCase() + paisLocalidade.substring(1);
		return paisLocalidade;
	}

	// #4
	protected String changeFirstLetterToUpperCaseEstadoLocalidade(String estado) {
		String estadoLocalidade = estado;
		estadoLocalidade = estadoLocalidade.substring(0, 1).toUpperCase() + estadoLocalidade.substring(1);
		return estadoLocalidade;
	}

}
