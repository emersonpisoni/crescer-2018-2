package br.com.cwi.crescer.melevaai.repository.veiculo;

import br.com.cwi.crescer.melevaai.domain.veiculo.Veiculo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface VeiculoRepository extends PagingAndSortingRepository<Veiculo, Long> {

    @Query("SELECT m FROM Veiculo m WHERE m.motorista.ocupado = false AND rownum = 1")
    Optional<Veiculo> findVeiculoDisponivel();

}
