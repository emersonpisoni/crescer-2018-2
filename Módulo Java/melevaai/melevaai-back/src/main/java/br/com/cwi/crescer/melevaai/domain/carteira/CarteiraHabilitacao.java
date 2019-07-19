package br.com.cwi.crescer.melevaai.domain.carteira;

import br.com.cwi.crescer.melevaai.domain.pessoa.Dominio;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.SequenceGenerator;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@Entity
@SequenceGenerator(name = "SEQ", sequenceName = "SEQ_CNH", initialValue = 1, allocationSize = 1)
public class CarteiraHabilitacao extends Dominio {

    private String numeroDoDocumento;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataVencimento;

    public boolean estaVencida() {
        return dataVencimento.isBefore(LocalDate.now());
    }

}
