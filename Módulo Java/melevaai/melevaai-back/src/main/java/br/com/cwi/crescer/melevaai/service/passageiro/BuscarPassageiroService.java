package br.com.cwi.crescer.melevaai.service.passageiro;

import br.com.cwi.crescer.melevaai.domain.pessoa.passageiro.Passageiro;
import br.com.cwi.crescer.melevaai.exception.ExceptionPassageiro;
import br.com.cwi.crescer.melevaai.repository.passageiro.PassageiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarPassageiroService {

    @Autowired
    private PassageiroRepository repository;

    public Passageiro buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ExceptionPassageiro("Passageiro não encontrado!"));
    }

}
