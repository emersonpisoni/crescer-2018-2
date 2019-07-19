package br.com.cwi.crescer.melevaai.service.veiculo;

import br.com.cwi.crescer.melevaai.domain.veiculo.Veiculo;
import br.com.cwi.crescer.melevaai.exception.RegistroNaoEncontradoException;
import br.com.cwi.crescer.melevaai.repository.veiculo.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarVeiculoService {

    @Autowired
    private VeiculoRepository repository;

    public Veiculo buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RegistroNaoEncontradoException(Veiculo.class.getSimpleName()));
    }

}
