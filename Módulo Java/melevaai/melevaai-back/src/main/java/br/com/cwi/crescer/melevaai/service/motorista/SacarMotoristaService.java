package br.com.cwi.crescer.melevaai.service.motorista;

import br.com.cwi.crescer.melevaai.domain.pessoa.motorista.Motorista;
import br.com.cwi.crescer.melevaai.exception.ExceptionMotorista;
import br.com.cwi.crescer.melevaai.repository.motorista.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SacarMotoristaService {

    @Autowired
    private BuscarMotoristaService buscarMotoristaService;

    @Autowired
    private MotoristaRepository repository;

    public Motorista sacar(Long idMotorista, BigDecimal valorSacado) {

        Motorista motorista = buscarMotoristaService.buscar(idMotorista);

        if (valorSacado.compareTo(motorista.getSaldo()) == 1) {
            throw new ExceptionMotorista("Saldo insuficiente");
        }

        motorista.setSaldo(motorista.getSaldo().subtract(valorSacado));
        repository.save(motorista);

        return motorista;

    }
}
