package br.com.tectectech.tectectechProducer.controller;

import java.net.URI;
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

import br.com.tectectech.tectectechProducer.business.LocalidadeBusiness;
import br.com.tectectech.tectectechProducer.exception.ResponseBusinessException;
import br.com.tectectech.tectectechProducer.model.LocalidadeModel;
import br.com.tectectech.tectectechProducer.repository.LocalidadeRepository;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/localidade")
public class LocalidadeController {

	@Autowired
	public LocalidadeRepository localidadeRepository;
	
	@Autowired
	public LocalidadeBusiness localidadeBusiness;
	
	@GetMapping()
	@ApiOperation(value = "Retorna uma lista de localidades")
	public ResponseEntity<List<LocalidadeModel>> findAll(Model model) {

		List<LocalidadeModel> localidades = localidadeRepository.findAll();
		return ResponseEntity.ok(localidades);
	}
	
	@GetMapping("/{idLocalidade}")
	@ApiOperation(value = "Retorna uma localidade pelo id")
	public ResponseEntity<LocalidadeModel> findById(@PathVariable("idLocalidade") long idLocalidade) {
		
		LocalidadeModel localidade = localidadeRepository.findById(idLocalidade).get();
		return ResponseEntity.ok(localidade);
	}
	
	@GetMapping("/nome/{nomeLocalidade}")
	@ApiOperation(value = "Retorna uma localidade pelo seu nome")
	public ResponseEntity<LocalidadeModel> findByNome(@PathVariable("nomeLocalidade") String nomeLocalidade) {
		
		LocalidadeModel localidade = localidadeRepository.findLocalidadeByNome(nomeLocalidade);
		return ResponseEntity.ok(localidade);
	}
	
	@GetMapping("/pais/{paisLocalidade}")
	@ApiOperation(value = "Retorna as localidades em um pais")
	public ResponseEntity<List<LocalidadeModel>> findByPais(@PathVariable("paisLocalidade") String paisLocalidade) {
		
		List<LocalidadeModel> localidades = localidadeRepository.findLocalidadesByPais(paisLocalidade);
		return ResponseEntity.ok(localidades);
	}
	
	@GetMapping("/estado/{estadoLocalidade}")
	@ApiOperation(value = "Retorna as localidades em um estado")
	public ResponseEntity<List<LocalidadeModel>> findByEstado(@PathVariable("estadoLocalidade") String estadoLocalidade) {
		
		List<LocalidadeModel> localidades = localidadeRepository.findLocalidadesByEstado(estadoLocalidade);
		return ResponseEntity.ok(localidades);
	}
	
	@PostMapping()
	@ApiOperation(value = "Salva uma nova localidade")
	public ResponseEntity save(@RequestBody @Valid LocalidadeModel localidadeModel, BindingResult bindingResult) throws ResponseBusinessException {
		
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}
		
		LocalidadeModel localidade = localidadeBusiness.applyBusiness(localidadeModel);
		
		localidadeRepository.save(localidade);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idLocalidade}")
				.buildAndExpand(localidade.getIdLocalidade()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/{idLocalidade}")
	@ApiOperation(value = "Atualiza uma localidade a partir do id")
	public ResponseEntity update(@PathVariable("idLocalidade") long idLocalidade, @RequestBody @Valid LocalidadeModel localidadeModel, BindingResult bindingResult) throws ResponseBusinessException {
		
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}
		
		LocalidadeModel localidade = localidadeBusiness.applyBusiness(localidadeModel);
		
		localidade.setIdLocalidade(idLocalidade);
		localidadeRepository.save(localidade);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{idLocalidade}")
	@ApiOperation(value = "Deleta uma localidade a partir do id")
	public ResponseEntity deleteById(@PathVariable("idLocalidade") long idLocalidade) {
		
		localidadeRepository.deleteById(idLocalidade);
		return ResponseEntity.noContent().build();
	}
	
}
