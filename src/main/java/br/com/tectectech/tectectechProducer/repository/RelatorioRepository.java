package br.com.tectectech.tectectechProducer.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.tectectech.tectectechProducer.model.RelatorioModel;

@Repository
public interface RelatorioRepository extends JpaRepository<RelatorioModel, Long> {

	@Query("SELECT r from RelatorioModel r JOIN LocalidadeModel l ON r.localidadeRelatorio.idLocalidade = l.idLocalidade WHERE l.nomeLocalidade = ?1")
	List<RelatorioModel> findRelatoriosByLocalidade(String nomeLocalidade);
	
	@Query("SELECT r from RelatorioModel r JOIN LocalidadeModel l ON r.localidadeRelatorio.idLocalidade = l.idLocalidade WHERE l.paisLocalidade = ?1")
	List<RelatorioModel> findRelatoriosByPais(String paisLocalidade);
	
	@Query("SELECT r from RelatorioModel r WHERE r.dataRelatorio >= ?1 AND r.dataRelatorio <= ?2")
	List<RelatorioModel> findRelatoriosByData(Date dataRelatorioInicio, Date dataRelatorioFim);
	
	@Query("SELECT r from RelatorioModel r ORDER BY r.phRelatorio ASC")
	List<RelatorioModel> findAllRelatoriosPhCrescente();
	
	@Query("SELECT r from RelatorioModel r WHERE r.phRelatorio >= ?1 ORDER BY r.phRelatorio ASC")
	List<RelatorioModel> findRelatoriosByPhMaiorQue(float phRelatorio);
	
	@Query("SELECT r from RelatorioModel r WHERE r.phRelatorio <= ?1 ORDER BY r.phRelatorio DESC")
	List<RelatorioModel> findRelatoriosByPhMenorQue(float phRelatorio);
	
	@Query("SELECT r from RelatorioModel r JOIN LocalidadeModel l ON r.localidadeRelatorio.idLocalidade = l.idLocalidade WHERE l.nomeLocalidade = ?1 ORDER BY r.phRelatorio ASC")
	List<RelatorioModel> findAllRelatoriosPhCrescenteByLocalidade(String nomeLocalidade);
	
	@Query("SELECT r from RelatorioModel r JOIN LocalidadeModel l ON r.localidadeRelatorio.idLocalidade = l.idLocalidade WHERE r.phRelatorio >= ?1 AND l.nomeLocalidade = ?2 ORDER BY r.phRelatorio ASC")
	List<RelatorioModel> findRelatoriosByPhMaiorQueAndLocalidade(float phRelatorio, String nomeLocalidade);
	
	@Query("SELECT r from RelatorioModel r JOIN LocalidadeModel l ON r.localidadeRelatorio.idLocalidade = l.idLocalidade WHERE r.phRelatorio <= ?1 AND l.nomeLocalidade = ?2 ORDER BY r.phRelatorio DESC")
	List<RelatorioModel> findRelatoriosByPhMenorQueAndLocalidade(float phRelatorio, String nomeLocalidade);
	
	@Query("SELECT r from RelatorioModel r JOIN LocalidadeModel l ON r.localidadeRelatorio.idLocalidade = l.idLocalidade WHERE l.paisLocalidade = ?1 ORDER BY r.phRelatorio ASC")
	List<RelatorioModel> findAllRelatoriosPhCrescenteByPais(String paisLocalidade);
	
	@Query("SELECT r from RelatorioModel r JOIN LocalidadeModel l ON r.localidadeRelatorio.idLocalidade = l.idLocalidade WHERE r.phRelatorio >= ?1 AND l.paisLocalidade = ?2 ORDER BY r.phRelatorio ASC")
	List<RelatorioModel> findRelatoriosByPhMaiorQueAndPais(float phRelatorio, String paisLocalidade);
	
	@Query("SELECT r from RelatorioModel r JOIN LocalidadeModel l ON r.localidadeRelatorio.idLocalidade = l.idLocalidade WHERE r.phRelatorio <= ?1 AND l.paisLocalidade = ?2 ORDER BY r.phRelatorio DESC")
	List<RelatorioModel> findRelatoriosByPhMenorQueAndPais(float phRelatorio, String paisLocalidade);
	
}
