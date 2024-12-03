package computacao.paralela.produtor11.repository;

import computacao.paralela.produtor11.dto.DadosProducao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CooperativaRepository extends JpaRepository<DadosProducao,Integer> {
}
