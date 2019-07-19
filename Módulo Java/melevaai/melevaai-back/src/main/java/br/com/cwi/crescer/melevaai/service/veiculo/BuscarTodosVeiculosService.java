package br.com.cwi.crescer.melevaai.service.veiculo;

import br.com.cwi.crescer.melevaai.domain.veiculo.Veiculo;
import br.com.cwi.crescer.melevaai.repository.veiculo.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarTodosVeiculosService {

    @Autowired
    private VeiculoRepository repository;

    public Page<Veiculo> buscarVeiculos(Pageable pageable){
        return repository.findAll(pageable);
    }
}
