package br.com.cwi.crescer.melevaai.service.motorista;

import br.com.cwi.crescer.melevaai.domain.pessoa.motorista.Motorista;
import br.com.cwi.crescer.melevaai.repository.motorista.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarTodosMotoristasService {

    @Autowired
    private MotoristaRepository repository;

    public Page<Motorista> buscar(Pageable pageable) {
        return repository.findAll(pageable);
    }

}
