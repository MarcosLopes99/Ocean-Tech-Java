package br.com.tectectech.tectectechProducer.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="localidades")
public class LocalidadeModel {

	private long idLocalidade;
	private String nomeLocalidade;
	private String paisLocalidade;
	private String estadoLocalidade;
	private String latitudeLocalidade;
	private String longitudeLocalidade;
	private List<RelatorioModel> relatoriosLocalidade;
	
	public LocalidadeModel() {
	}

	public LocalidadeModel(long idLocalidade, String nomeLocalidade, String paisLocalidade, String estadoLocalidade,
			String latitudeLocalidade, String longitudeLocalidade) {
		this.idLocalidade = idLocalidade;
		this.nomeLocalidade = nomeLocalidade;
		this.paisLocalidade = paisLocalidade;
		this.estadoLocalidade = estadoLocalidade;
		this.latitudeLocalidade = latitudeLocalidade;
		this.longitudeLocalidade = longitudeLocalidade;
	}

	@Id
	@Column(name = "id_localidade")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "localidade_seq")
	@SequenceGenerator(name = "localidade_seq", sequenceName = "localidade_seq", allocationSize = 1)
	@ApiModelProperty(value = "ID da Localidade")
	public long getIdLocalidade() {
		return idLocalidade;
	}

	public void setIdLocalidade(long idLocalidade) {
		this.idLocalidade = idLocalidade;
	}

	@Column(name = "nome_localidade")
	@NotNull(message = "Nome da Localidade obrigatorio")
	@Size(min = 2, max = 60, message = "NOME DA LOCALIDADE deve conter entre 2 e 60 caracteres")
	@ApiModelProperty(value = "Nome da Localidade")
	public String getNomeLocalidade() {
		return nomeLocalidade;
	}

	public void setNomeLocalidade(String nomeLocalidade) {
		this.nomeLocalidade = nomeLocalidade;
	}

	@Column(name = "pais_localidade")
	@NotNull(message = "Nome do Pais obrigatorio")
	@Size(min = 2, max = 60, message = "NOME DO PAIS deve conter entre 2 e 60 caracteres")
	@ApiModelProperty(value = "Nome do Pais")
	public String getPaisLocalidade() {
		return paisLocalidade;
	}

	public void setPaisLocalidade(String paisLocalidade) {
		this.paisLocalidade = paisLocalidade;
	}

	@Column(name = "estado_localidade")
	@NotNull(message = "Nome do Estado obrigatorio")
	@Size(min = 2, max = 60, message = "NOME DO ESTADO deve conter entre 2 e 60 caracteres")
	@ApiModelProperty(value = "Nome do Estado")
	public String getEstadoLocalidade() {
		return estadoLocalidade;
	}

	public void setEstadoLocalidade(String estadoLocalidade) {
		this.estadoLocalidade = estadoLocalidade;
	}

	@Column(name = "latitude_localidade")
	@NotNull(message = "Latitude obrigatoria")
	@Size(min = 2, max = 20, message = "LATITUDE deve conter entre 2 e 20 caracteres")
	@ApiModelProperty(value = "Latitude da Localidade")
	public String getLatitudeLocalidade() {
		return latitudeLocalidade;
	}

	public void setLatitudeLocalidade(String latitudeLocalidade) {
		this.latitudeLocalidade = latitudeLocalidade;
	}

	@Column(name = "longitude_localidade")
	@NotNull(message = "Longitude obrigatoria")
	@Size(min = 2, max = 20, message = "LONGITUDE deve conter entre 2 e 20 caracteres")
	@ApiModelProperty(value = "Longitude da Localidade")
	public String getLongitudeLocalidade() {
		return longitudeLocalidade;
	}

	public void setLongitudeLocalidade(String longitudeLocalidade) {
		this.longitudeLocalidade = longitudeLocalidade;
	}

	@JsonIgnore
	@OneToMany(mappedBy = "localidadeRelatorio")
	public List<RelatorioModel> getRelatoriosLocalidade() {
		return relatoriosLocalidade;
	}

	public void setRelatoriosLocalidade(List<RelatorioModel> relatoriosLocalidade) {
		this.relatoriosLocalidade = relatoriosLocalidade;
	}
	
}
