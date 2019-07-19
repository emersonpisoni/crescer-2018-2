package br.com.cwi.crescer.melevaai.service.passageiro;

import br.com.cwi.crescer.melevaai.domain.pessoa.passageiro.Passageiro;
import br.com.cwi.crescer.melevaai.exception.ExceptionPassageiro;
import br.com.cwi.crescer.melevaai.repository.passageiro.PassageiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DepositarPassageiroService {

    @Autowired
    private PassageiroRepository repository;

    @Autowired
    private BuscarPassageiroService buscarPassageiroService;

    public Passageiro depositar(Long idPassageiro, BigDecimal valorDepositado) {

        Passageiro passageiro = buscarPassageiroService.buscar(idPassageiro);

        if (valorDepositado.compareTo(BigDecimal.valueOf(0)) < 0) {
            throw new ExceptionPassageiro("Não é possível depositar valores negativos");

        }

        passageiro.setSaldo(passageiro.getSaldo().add(valorDepositado));

        return repository.save(passageiro);

    }
}
