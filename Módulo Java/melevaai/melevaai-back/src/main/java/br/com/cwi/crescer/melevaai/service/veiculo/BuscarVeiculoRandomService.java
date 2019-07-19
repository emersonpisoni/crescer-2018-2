package br.com.cwi.crescer.melevaai.service.veiculo;

import br.com.cwi.crescer.melevaai.domain.veiculo.Veiculo;
import br.com.cwi.crescer.melevaai.exception.ExceptionVeiculo;
import br.com.cwi.crescer.melevaai.repository.veiculo.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscarVeiculoRandomService {

    @Autowired
    private VeiculoRepository repository;

    public Optional<Veiculo> buscarVeiculoRandom(){

        Optional<Veiculo> veiculo = repository.findVeiculoDisponivel();
        if (!veiculo.isPresent()){
            throw new ExceptionVeiculo("Nenhum veículo disponível no momento!");
        }
        return repository.findVeiculoDisponivel();
    }

}
