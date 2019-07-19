package br.com.cwi.crescer.melevaai.service.passageiro;

import br.com.cwi.crescer.melevaai.domain.pessoa.passageiro.Passageiro;
import br.com.cwi.crescer.melevaai.exception.ExceptionMotorista;
import br.com.cwi.crescer.melevaai.repository.passageiro.PassageiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SalvarPassageiroService {

    @Autowired
    private PassageiroRepository repository;

    @Autowired
    private PasswordEncoder password;

    public Passageiro salvar(Passageiro novoPassageiro){

        if(!novoPassageiro.verificaIdade()){
            throw new ExceptionMotorista("O passageiro não possui a idade mínima necessária segundo a legislação brasileira.");
        }

        novoPassageiro.setSenha(password.encode(novoPassageiro.getSenha()));

        return repository.save(novoPassageiro);
    }
}
