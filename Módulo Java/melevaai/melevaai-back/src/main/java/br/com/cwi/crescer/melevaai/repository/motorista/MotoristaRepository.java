package br.com.cwi.crescer.melevaai.repository.motorista;

import br.com.cwi.crescer.melevaai.domain.pessoa.motorista.Motorista;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface MotoristaRepository extends PagingAndSortingRepository<Motorista, Long> {


}
