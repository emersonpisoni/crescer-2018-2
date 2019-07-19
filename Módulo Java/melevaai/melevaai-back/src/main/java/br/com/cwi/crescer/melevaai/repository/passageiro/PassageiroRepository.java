package br.com.cwi.crescer.melevaai.repository.passageiro;

import br.com.cwi.crescer.melevaai.domain.pessoa.passageiro.Passageiro;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface PassageiroRepository extends PagingAndSortingRepository<Passageiro, Long> {

}
