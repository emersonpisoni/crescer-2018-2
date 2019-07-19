package br.com.cwi.crescer.melevaai.service.passageiro;

import br.com.cwi.crescer.melevaai.domain.pessoa.passageiro.Passageiro;
import br.com.cwi.crescer.melevaai.repository.motorista.MotoristaRepository;
import br.com.cwi.crescer.melevaai.repository.passageiro.PassageiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarTodosPassageirosService {

    @Autowired
    private PassageiroRepository repository;

    public Page<Passageiro> buscarPassageiros(Pageable pageable){
        return repository.findAll(pageable);
    }
}
