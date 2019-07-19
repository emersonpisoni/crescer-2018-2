package br.com.cwi.crescer.melevaai.repository.corrida;

import br.com.cwi.crescer.melevaai.domain.corrida.Corrida;
import br.com.cwi.crescer.melevaai.domain.dto.CustoPorPassageiroDto;
import br.com.cwi.crescer.melevaai.domain.dto.CustosCorridaDto;
import br.com.cwi.crescer.melevaai.domain.pessoa.passageiro.Passageiro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CorridaRepository extends Repository<Corrida, Long> {

    List<Corrida> findAll();

    @Query("SELECT new br.com.cwi.crescer.melevaai.domain.dto.CustosCorridaDto" +
            "(c.dataHoraInicio, c.veiculo.motorista.nome, c.veiculo.placa, c.passageiro.nome,  c.valorCorrida) FROM Corrida c WHERE c.situacao LIKE 'FINALIZADA'")
    List<CustosCorridaDto> buscarGastoCorridas();

    @Query("SELECT new br.com.cwi.crescer.melevaai.domain.dto.CustoPorPassageiroDto(c.passageiro.nome, SUM(c.valorCorrida))" +
            "FROM Corrida c WHERE c.passageiro.id = ?3 AND c.dataHoraInicio BETWEEN ?1 AND ?2 GROUP BY c.passageiro.id, c.passageiro.nome")
    Optional<CustoPorPassageiroDto> buscarGastoCorridasPorPassageiro(LocalDateTime dataInicio, LocalDateTime dataFim, Long passageiro);

    Optional<Corrida> findById(final Long id);

    Corrida save(Corrida novaCorrida);

    List<Corrida> findByPassageiro_Id(Long id);

}
