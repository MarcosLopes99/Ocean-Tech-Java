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
public class RelatorioControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;
	
	@Test
	@DisplayName("Deve listar todos os relatorios e retornar status 200")
	public void shouldListAllRelatorios() throws Exception {
		
		mvc.perform(get("/relatorio")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
	
	@Test
	@DisplayName("Deve retornar um relatorio pelo ID e com status 200")
	public void shouldFindRelatorioById() throws Exception {
		
		mvc.perform(get("/relatorio/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().string("{\"idRelatorio\":1}"));
	}
	
	@Test
	@DisplayName("Deve salvar um relatorio, retornar status 201 e Location no Header")
	public void shouldSaveRelatorio() throws Exception {
		
		mvc.perform(post("/relatorio")
			.contentType(MediaType.APPLICATION_JSON)
			.content("{\"phRelatorio\": \"7\"}"))
			.andDo(print())
			.andExpect(status().isCreated())
			.andExpect(header().exists("Location"));
	}
	
	@Test
	@DisplayName("Deve atualizar um relatorio pelo id e retornar status 200")
	public void shouldUpdateRelatorio() throws Exception {
		
		mvc.perform(put("/relatorio/2")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"phRelatorio\": \"4\"}"))
				.andDo(print())
				.andExpect(status().isOk());
	}
	
	@Test
	@DisplayName("Deve deletar um relatorio pelo id e retornar status 204")
	public void shouldDeleteRelatorioById() throws Exception {
		
		mvc.perform(delete("/relatorio/5")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}
	
}
