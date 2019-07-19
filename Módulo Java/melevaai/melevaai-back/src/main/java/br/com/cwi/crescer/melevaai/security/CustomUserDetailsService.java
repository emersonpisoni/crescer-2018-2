package br.com.cwi.crescer.melevaai.security;

import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.melevaai.domain.pessoa.Pessoa;
import br.com.cwi.crescer.melevaai.repository.pessoa.PessoaRepository;

/*
* Service para obter dados do usuário no contexto de autenticação
*/
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Pessoa pessoa = getUser(() -> pessoaRepository.findByEmail(username));
        return UserPrincipal.create(pessoa);
    }

    public UserDetails loadUserById(Long id) {
        Pessoa pessoa = getUser(() -> pessoaRepository.findById(id));
        return UserPrincipal.create(pessoa);
    }

    private Pessoa getUser(Supplier<Optional<Pessoa>> supplier) {
        return supplier.get().orElseThrow(() ->
            new UsernameNotFoundException("Usuário não cadastrado")
        );
    }
}
