package br.com.cwi.crescer.melevaai.service.admin;

import br.com.cwi.crescer.melevaai.domain.pessoa.Pessoa;
import br.com.cwi.crescer.melevaai.repository.pessoa.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SalvarAdminService {

    @Autowired
    private PessoaRepository repository;

    @Autowired
    private PasswordEncoder password;

    public Pessoa cadastrar(Pessoa admin) {

        admin.setSenha(password.encode(admin.getSenha()));

        return repository.save(admin);
    }

}
