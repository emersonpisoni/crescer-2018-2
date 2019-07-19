package br.com.cwi.crescer.melevaai.service.motorista;

import br.com.cwi.crescer.melevaai.repository.motorista.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoverMotoristaService {

    @Autowired
    private MotoristaRepository repository;

    @Autowired
    private BuscarMotoristaService buscarMotoristaService;

    public void remover(final Long id) {

        repository.delete(buscarMotoristaService.buscar(id));

    }
}
