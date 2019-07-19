package br.com.cwi.crescer.melevaai.service.corrida;

import br.com.cwi.crescer.melevaai.domain.corrida.Corrida;
import br.com.cwi.crescer.melevaai.domain.pessoa.motorista.Motorista;
import br.com.cwi.crescer.melevaai.domain.pessoa.passageiro.Passageiro;
import br.com.cwi.crescer.melevaai.exception.ExceptionCorrida;
import br.com.cwi.crescer.melevaai.repository.corrida.CorridaRepository;
import br.com.cwi.crescer.melevaai.repository.passageiro.PassageiroRepository;
import br.com.cwi.crescer.melevaai.service.motorista.BuscarMotoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuscarTodasCorridasPorIdPassageiroService {

    @Autowired
    private CorridaRepository repository;

    @Autowired
    private BuscarCorridaService buscarCorridaService;

    @Autowired
    private PassageiroRepository passageiroRepository;

    public List<Corrida> buscar(Long id) {

        Optional<Passageiro> passageiro = passageiroRepository.findById(id);

        if(!passageiro.isPresent()){
            throw new ExceptionCorrida("Passageiro não existe");
        }

        List<Corrida> corridas = repository.findByPassageiro_Id(id);

        if(corridas.size() == 0){
            throw new ExceptionCorrida("Não há registro de corridas para este passageiro");
        }

        return corridas;
    }

}
