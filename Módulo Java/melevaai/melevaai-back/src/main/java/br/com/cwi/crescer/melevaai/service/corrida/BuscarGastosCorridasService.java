package br.com.cwi.crescer.melevaai.service.corrida;

import br.com.cwi.crescer.melevaai.domain.dto.CustosCorridaDto;
import br.com.cwi.crescer.melevaai.exception.ExceptionCorrida;
import br.com.cwi.crescer.melevaai.repository.corrida.CorridaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarGastosCorridasService {

    @Autowired
    private CorridaRepository repository;

    public List<CustosCorridaDto> buscar() {

        List<CustosCorridaDto> custosCorridaDtos = repository.buscarGastoCorridas();

        if (custosCorridaDtos == null) {
            throw new ExceptionCorrida("Nenhuma corrida encontrada!");
        }

        return custosCorridaDtos;
    }
}
