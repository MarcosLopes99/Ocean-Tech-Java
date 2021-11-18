package br.com.tectectech.tectectecProducer.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class LocalidadeControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;
	
	@Test
	@DisplayName("Deve listar todas as localidades e retornar status 200")
	public void shouldListAllLocalidades() throws Exception {
		
		mvc.perform(get("/localidade")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
	
	@Test
	@DisplayName("Deve retornar uma localidade pelo ID e com status 200")
	public void shouldFindLocalidadeById() throws Exception {
		
		mvc.perform(get("/localidade/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().string("{\"idLocalidade\":1,\"nomeLocalidade\":\"Santos\"}"));
	}
	
	@Test
	@DisplayName("Deve salvar uma localidade, retornar status 201 e Location no Header")
	public void shouldSaveLocalidade() throws Exception {
		
		mvc.perform(post("/localidade")
			.contentType(MediaType.APPLICATION_JSON)
			.content("{\"nomeLocalidade\": \"Santos\"}"))
			.andDo(print())
			.andExpect(status().isCreated())
			.andExpect(header().exists("Location"));
	}
	
	@Test
	@DisplayName("Deve atualizar uma localidade pelo id e retornar status 200")
	public void shouldUpdateLocalidade() throws Exception {
		
		mvc.perform(put("/localidade/2")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"nomeCategoria\": \"Localidade Atualizada\"}"))
				.andDo(print())
				.andExpect(status().isOk());
	}
	
	@Test
	@DisplayName("Deve deletar uma localidade pelo id e retornar status 204")
	public void shouldDeleteLocalidadeById() throws Exception {
		
		mvc.perform(delete("/localidade/5")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}
	
}
