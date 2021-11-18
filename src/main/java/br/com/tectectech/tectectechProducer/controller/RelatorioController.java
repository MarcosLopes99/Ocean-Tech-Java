package br.com.tectectech.tectectechProducer.controller;

import java.net.URI;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.tectectech.tectectechProducer.business.RelatorioBusiness;
import br.com.tectectech.tectectechProducer.exception.ResponseBusinessException;
import br.com.tectectech.tectectechProducer.model.RelatorioModel;
import br.com.tectectech.tectectechProducer.repository.RelatorioRepository;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/relatorio")
public class RelatorioController {

	@Autowired
	public RelatorioRepository relatorioRepository;
	
	@Autowired
	public RelatorioBusiness relatorioBusiness;
	
	@GetMapping()
	@ApiOperation(value = "Retorna uma lista de relatorios")
	public ResponseEntity<List<RelatorioModel>> findAll(Model model) {

		List<RelatorioModel> relatorios = relatorioRepository.findAll();
		return ResponseEntity.ok(relatorios);
	}
	
	@GetMapping("/{idRelatorio}")
	@ApiOperation(value = "Retorna um relatorio pelo id")
	public ResponseEntity<RelatorioModel> findById(@PathVariable("idRelatorio") long idRelatorio) {
		
		RelatorioModel relatorio = relatorioRepository.findById(idRelatorio).get();
		return ResponseEntity.ok(relatorio);
	}
	
	@GetMapping("/localidade/{nomeLocalidade}")
	@ApiOperation(value = "Retorna uma lista de relatorios de uma localidade")
	public ResponseEntity<List<RelatorioModel>> findByLocalidade(@PathVariable("nomeLocalidade") String nomeLocalidade) {
		
		List<RelatorioModel> relatorios = relatorioRepository.findRelatoriosByLocalidade(nomeLocalidade);
		return ResponseEntity.ok(relatorios);
	}
	
	@GetMapping("/pais/{paisLocalidade}")
	@ApiOperation(value = "Retorna uma lista de relatorios de um pais")
	public ResponseEntity<List<RelatorioModel>> findByPais(@PathVariable("paisLocalidade") String paisLocalidade) {
		
		List<RelatorioModel> relatorios = relatorioRepository.findRelatoriosByPais(paisLocalidade);
		return ResponseEntity.ok(relatorios);
	}
	
	@GetMapping("/data/{dataRelatorioInicio}/{dataRelatorioFim}")
	@ApiOperation(value = "Retorna uma lista de relatorios de periodo especificado")
	public ResponseEntity<List<RelatorioModel>> findByData(@PathVariable("dataRelatorioInicio") Date dataRelatorioInicio, @PathVariable("dataRelatorioFim") Date dataRelatorioFim) {
		
		List<RelatorioModel> relatorios = relatorioRepository.findRelatoriosByData(dataRelatorioInicio, dataRelatorioFim);
		return ResponseEntity.ok(relatorios);
	}
	
	@GetMapping("/ph")
	@ApiOperation(value = "Retorna uma lista de relatorios organizada pelo ph")
	public ResponseEntity<List<RelatorioModel>> findAllPh(Model model) {
		
		List<RelatorioModel> relatorios = relatorioRepository.findAllRelatoriosPhCrescente();
		return ResponseEntity.ok(relatorios);
	}
	
	@GetMapping("/ph/maior/{phRelatorio}")
	@ApiOperation(value = "Retorna uma lista de relatorios com ph maior que o especificado")
	public ResponseEntity<List<RelatorioModel>> findByPhMaiorQue(@PathVariable("phRelatorio") float phRelatorio) {
		
		List<RelatorioModel> relatorios = relatorioRepository.findRelatoriosByPhMaiorQue(phRelatorio);
		return ResponseEntity.ok(relatorios);
	}
	
	@GetMapping("/ph/menor/{phRelatorio}")
	@ApiOperation(value = "Retorna uma lista de relatorios com ph menor que o especificado")
	public ResponseEntity<List<RelatorioModel>> findByPhMenorQue(@PathVariable("phRelatorio") float phRelatorio) {
		
		List<RelatorioModel> relatorios = relatorioRepository.findRelatoriosByPhMenorQue(phRelatorio);
		return ResponseEntity.ok(relatorios);
	}
	
	@GetMapping("/ph/localidade/{nomeLocalidade}")
	@ApiOperation(value = "Retorna uma lista de relatorios de uma localidade organizada pelo ph")
	public ResponseEntity<List<RelatorioModel>> findAllPhByLocalidade(@PathVariable("nomeLocalidade") String nomeLocalidade) {
		
		List<RelatorioModel> relatorios = relatorioRepository.findAllRelatoriosPhCrescenteByLocalidade(nomeLocalidade);
		return ResponseEntity.ok(relatorios);
	}
	
	@GetMapping("/ph/maior/{phRelatorio}/localidade/{nomeLocalidade}")
	@ApiOperation(value = "Retorna uma lista de relatorios de uma localidade com ph maior que o especificado")
	public ResponseEntity<List<RelatorioModel>> findByPhMaiorAndLocalidade(@PathVariable("phRelatorio") float phRelatorio, @PathVariable("nomeLocalidade") String nomeLocalidade) {
		
		List<RelatorioModel> relatorios = relatorioRepository.findRelatoriosByPhMaiorQueAndLocalidade(phRelatorio, nomeLocalidade);
		return ResponseEntity.ok(relatorios);
	}
	
	@GetMapping("/ph/menor/{phRelatorio}/localidade/{nomeLocalidade}")
	@ApiOperation(value = "Retorna uma lista de relatorios de uma localidade com ph menor que o especificado")
	public ResponseEntity<List<RelatorioModel>> findByPhMenorAndLocalidade(@PathVariable("phRelatorio") float phRelatorio, @PathVariable("nomeLocalidade") String nomeLocalidade) {
		
		List<RelatorioModel> relatorios = relatorioRepository.findRelatoriosByPhMenorQueAndLocalidade(phRelatorio, nomeLocalidade);
		return ResponseEntity.ok(relatorios);
	}
	
	@GetMapping("/ph/pais/{paisLocalidade}")
	@ApiOperation(value = "Retorna uma lista de relatorios de um pais organizada pelo ph")
	public ResponseEntity<List<RelatorioModel>> findAllPhByPais(@PathVariable("paisLocalidade") String paisLocalidade) {
		
		List<RelatorioModel> relatorios = relatorioRepository.findAllRelatoriosPhCrescenteByPais(paisLocalidade);
		return ResponseEntity.ok(relatorios);
	}
	
	@GetMapping("/ph/maior/{phRelatorio}/pais/{paisLocalidade}")
	@ApiOperation(value = "Retorna uma lista de relatorios de um pais com ph maior que o especificado")
	public ResponseEntity<List<RelatorioModel>> findByPhMaiorAndPais(@PathVariable("phRelatorio") float phRelatorio, @PathVariable("paisLocalidade") String paisLocalidade) {
		
		List<RelatorioModel> relatorios = relatorioRepository.findRelatoriosByPhMaiorQueAndPais(phRelatorio, paisLocalidade);
		return ResponseEntity.ok(relatorios);
	}
	
	@GetMapping("/ph/menor/{phRelatorio}/pais/{paisLocalidade}")
	@ApiOperation(value = "Retorna uma lista de relatorios de um pais com ph menor que o especificado")
	public ResponseEntity<List<RelatorioModel>> findByPhMenorAndPais(@PathVariable("phRelatorio") float phRelatorio, @PathVariable("paisLocalidade") String paisLocalidade) {
		
		List<RelatorioModel> relatorios = relatorioRepository.findRelatoriosByPhMenorQueAndPais(phRelatorio, paisLocalidade);
		return ResponseEntity.ok(relatorios);
	}
	
	@PostMapping()
	@ApiOperation(value = "Salva um novo relatorio")
	public ResponseEntity save(@RequestBody @Valid RelatorioModel relatorioModel, BindingResult bindingResult) throws ResponseBusinessException {
		
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}
		
		RelatorioModel relatorio = relatorioBusiness.applyBusiness(relatorioModel);
		
		relatorioRepository.save(relatorio);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idRelatorio}")
				.buildAndExpand(relatorio.getIdRelatorio()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/{idRelatorio}")
	@ApiOperation(value = "Atualiza um relatorio a partir do id")
	public ResponseEntity update(@PathVariable("idRelatorio") long idRelatorio, @RequestBody @Valid RelatorioModel relatorioModel, BindingResult bindingResult) throws ResponseBusinessException {
		
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}
		
		RelatorioModel relatorio = relatorioBusiness.applyBusiness(relatorioModel);
		
		relatorio.setIdRelatorio(idRelatorio);
		relatorioRepository.save(relatorio);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{idRelatorio}")
	@ApiOperation(value = "Deleta um relatorio a partir do id")
	public ResponseEntity deleteById(@PathVariable("idRelatorio") long idRelatorio) {
		
		relatorioRepository.deleteById(idRelatorio);
		return ResponseEntity.noContent().build();
	}
	
}
