package br.com.cwi.crescer.melevaai.service.corrida;

import br.com.cwi.crescer.melevaai.domain.corrida.Corrida;
import br.com.cwi.crescer.melevaai.exception.ExceptionCorrida;
import br.com.cwi.crescer.melevaai.repository.corrida.CorridaRepository;
import br.com.cwi.crescer.melevaai.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvaliacaoPassageiroService {

    @Autowired
    private CorridaRepository repository;

    @Autowired
    private BuscarCorridaService buscarCorridaService;

    public Corrida avaliar(UserPrincipal currentUser, Long idCorrida, int nota){

        if(!(currentUser.getId() == idCorrida)){
            throw new ExceptionCorrida("Usuário não está habilitado para realizar a avaliação");
        }

        Corrida corrida = buscarCorridaService.buscar(idCorrida);

        if (nota < 1 || nota > 5) {
            throw new ExceptionCorrida("Nota inválida");
        }

        corrida.setNotaPassageiro(nota);

        return repository.save(corrida);

    }

}
