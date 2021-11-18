package br.com.tectectech.tectectechProducer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.tectectech.tectectechProducer.model.LocalidadeModel;

@Repository
public interface LocalidadeRepository extends JpaRepository<LocalidadeModel, Long> {

	@Query("SELECT l from LocalidadeModel l WHERE l.nomeLocalidade = ?1")
	LocalidadeModel findLocalidadeByNome(String nomeLocalidade);
	
	@Query("SELECT l from LocalidadeModel l WHERE l.paisLocalidade = ?1")
	List<LocalidadeModel> findLocalidadesByPais(String paisLocalidade);
	
	@Query("SELECT l from LocalidadeModel l WHERE l.estadoLocalidade = ?1")
	List<LocalidadeModel> findLocalidadesByEstado(String estadoLocalidade);
	
}
