package br.com.cwi.crescer.melevaai.service.motorista;

import br.com.cwi.crescer.melevaai.domain.pessoa.motorista.Motorista;
import br.com.cwi.crescer.melevaai.exception.ExceptionMotorista;
import br.com.cwi.crescer.melevaai.repository.motorista.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SalvarMotoristaService {

    @Autowired
    private MotoristaRepository repository;

    @Autowired
    private PasswordEncoder password;

    public Motorista cadastrar(Motorista novoMotorista) {
        if (!novoMotorista.verificaIdade()) {
            throw new ExceptionMotorista("O motorista não possui a idade mínima necessária segundo a legislação brasileira.");
        }

        if (novoMotorista.getCarteiraHabilitacao().estaVencida()) {
            throw new ExceptionMotorista("A CNH do motorista não pode estar vencida.");
        }

        novoMotorista.setSenha(password.encode(novoMotorista.getSenha()));

        return repository.save(novoMotorista);
    }

}
