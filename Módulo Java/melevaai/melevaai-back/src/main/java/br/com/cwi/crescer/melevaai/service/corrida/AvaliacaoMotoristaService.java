package br.com.cwi.crescer.melevaai.service.corrida;

import br.com.cwi.crescer.melevaai.domain.corrida.Corrida;
import br.com.cwi.crescer.melevaai.exception.ExceptionCorrida;
import br.com.cwi.crescer.melevaai.repository.corrida.CorridaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvaliacaoMotoristaService {

    @Autowired
    private CorridaRepository repository;

    @Autowired
    private BuscarCorridaService buscarCorridaService;

    public Corrida avaliar(Long idCorrida, int nota){

        Corrida corrida = buscarCorridaService.buscar(idCorrida);

        if (nota < 1 || nota > 5) {
            throw new ExceptionCorrida("Nota inválida");
        }

        corrida.setNotaMotorista(nota);

        return repository.save(corrida);

    }

}
