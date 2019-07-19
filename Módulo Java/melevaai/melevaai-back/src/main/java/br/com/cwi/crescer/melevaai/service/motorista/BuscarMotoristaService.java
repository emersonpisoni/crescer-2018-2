package br.com.cwi.crescer.melevaai.service.motorista;

import br.com.cwi.crescer.melevaai.domain.pessoa.motorista.Motorista;
import br.com.cwi.crescer.melevaai.exception.ExceptionVeiculo;
import br.com.cwi.crescer.melevaai.repository.motorista.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarMotoristaService {

    @Autowired
    private MotoristaRepository repository;

    public Motorista buscar(final Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ExceptionVeiculo("Motorista não encontrado, informe um motorista disponivel"));
    }

}
