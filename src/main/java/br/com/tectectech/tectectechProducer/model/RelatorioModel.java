package br.com.tectectech.tectectechProducer.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="relatorios")
public class RelatorioModel {

	private long idRelatorio;
	private LocalidadeModel localidadeRelatorio;
	private Date dataRelatorio;
	private float temperaturaRelatorio;
	private float profundidaRelatorio;
	private float phRelatorio;
	private float oxigenioDissolvidoRelatorio;
	
	public RelatorioModel() {
	}
	
	public RelatorioModel(long idRelatorio, LocalidadeModel localidadeRelatorio, Date dataRelatorio,
			float temperaturaRelatorio, float profundidaRelatorio, float phRelatorio,
			float oxigenioDissolvidoRelatorio) {
		this.idRelatorio = idRelatorio;
		this.localidadeRelatorio = localidadeRelatorio;
		this.dataRelatorio = dataRelatorio;
		this.temperaturaRelatorio = temperaturaRelatorio;
		this.profundidaRelatorio = profundidaRelatorio;
		this.phRelatorio = phRelatorio;
		this.oxigenioDissolvidoRelatorio = oxigenioDissolvidoRelatorio;
	}

	@Id
	@Column(name = "id_relatorio")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "relatorio_seq")
	@SequenceGenerator(name = "relatorio_seq", sequenceName = "relatorio_seq", allocationSize = 1)
	@ApiModelProperty(value = "ID do Relatorio")
	public long getIdRelatorio() {
		return idRelatorio;
	}

	public void setIdRelatorio(long idRelatorio) {
		this.idRelatorio = idRelatorio;
	}

	@ManyToOne()
	@JoinColumn(name = "id_localidade", nullable = false)
	@NotNull
	@ApiModelProperty(value = "Localidade do relatorio")
	public LocalidadeModel getLocalidadeRelatorio() {
		return localidadeRelatorio;
	}

	public void setLocalidadeRelatorio(LocalidadeModel localidadeRelatorio) {
		this.localidadeRelatorio = localidadeRelatorio;
	}

	@Column(name = "data_relatorio")
	@NotNull(message = "Data obrigatoria")
	@ApiModelProperty(value = "Data de geracao do relatorio")
	public Date getDataRelatorio() {
		return dataRelatorio;
	}

	public void setDataRelatorio(Date dataRelatorio) {
		this.dataRelatorio = dataRelatorio;
	}

	@Column(name = "temperatura_relatorio")
	@NotNull(message = "Temperatura obrigatoria")
	@ApiModelProperty(value = "Temperatura da agua segundo o relatorio")
	public float getTemperaturaRelatorio() {
		return temperaturaRelatorio;
	}

	public void setTemperaturaRelatorio(float temperaturaRelatorio) {
		this.temperaturaRelatorio = temperaturaRelatorio;
	}

	@Column(name = "profundidade_relatorio")
	@NotNull(message = "Profundidade obrigatoria")
	@ApiModelProperty(value = "Profundidade que foi realizada a medicao contida no relatorio")
	public float getProfundidaRelatorio() {
		return profundidaRelatorio;
	}

	public void setProfundidaRelatorio(float profundidaRelatorio) {
		this.profundidaRelatorio = profundidaRelatorio;
	}

	@Column(name = "ph_relatorio")
	@NotNull(message = "PH obrigatorio")
	@ApiModelProperty(value = "PH da agua segundo o relatorio")
	public float getPhRelatorio() {
		return phRelatorio;
	}

	public void setPhRelatorio(float phRelatorio) {
		this.phRelatorio = phRelatorio;
	}

	@Column(name = "oxigenio_dissolvido_relatorio")
	@NotNull(message = "Oxigenio dissolvido obrigatorio")
	@ApiModelProperty(value = "Oxigenio dissolvido na agua segundo o relatorio")
	public float getOxigenioDissolvidoRelatorio() {
		return oxigenioDissolvidoRelatorio;
	}

	public void setOxigenioDissolvidoRelatorio(float oxigenioDissolvidoRelatorio) {
		this.oxigenioDissolvidoRelatorio = oxigenioDissolvidoRelatorio;
	}
	
}
