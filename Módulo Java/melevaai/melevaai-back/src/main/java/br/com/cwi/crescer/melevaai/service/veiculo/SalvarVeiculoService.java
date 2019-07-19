package br.com.cwi.crescer.melevaai.service.veiculo;

import br.com.cwi.crescer.melevaai.domain.pessoa.motorista.Motorista;
import br.com.cwi.crescer.melevaai.domain.veiculo.Veiculo;
import br.com.cwi.crescer.melevaai.exception.ExceptionVeiculo;
import br.com.cwi.crescer.melevaai.repository.veiculo.VeiculoRepository;
import br.com.cwi.crescer.melevaai.service.motorista.BuscarMotoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalvarVeiculoService {

    @Autowired
    private VeiculoRepository repository;

    @Autowired
    private BuscarMotoristaService buscarMotoristaService;

    public Veiculo salvar(Veiculo novoVeiculo, Long idMotorista) {

        Motorista motorista = buscarMotoristaService.buscar(idMotorista);

        if (!(motorista.getCarteiraHabilitacao().getCategoria().equals(novoVeiculo.getCategoria()))) {
            throw new ExceptionVeiculo("Motorista não habilitado");
        }

        novoVeiculo.setMotorista(motorista);

        return repository.save(novoVeiculo);
    }
}
