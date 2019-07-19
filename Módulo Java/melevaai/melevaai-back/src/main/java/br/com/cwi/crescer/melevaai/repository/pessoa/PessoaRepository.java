package br.com.cwi.crescer.melevaai.repository.pessoa;

import br.com.cwi.crescer.melevaai.domain.pessoa.Pessoa;
import br.com.cwi.crescer.melevaai.domain.pessoa.passageiro.Passageiro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

    List<Pessoa> findAllByEmail(String email);

    Optional<Pessoa> findByEmail(String email);

    Optional<Pessoa> findById(Long id);
}
