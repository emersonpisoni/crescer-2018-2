package br.com.cwi.crescer.melevaai.service.corrida;

import br.com.cwi.crescer.melevaai.domain.corrida.Corrida;
import br.com.cwi.crescer.melevaai.repository.corrida.CorridaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarTodasCorridasService {

    @Autowired
    private CorridaRepository repository;

    public List<Corrida> buscar() {
        return repository.findAll();
    }

}
