package br.com.cwi.crescer.melevaai.domain.pessoa;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Perfil {

    ADMINISTRADOR("ROLE_ADMIN"),
    MOTORISTA("ROLE_MOTORISTA"),
    PASSAGEIRO("ROLE_PASSAGEIRO");

    private final String role;
}
