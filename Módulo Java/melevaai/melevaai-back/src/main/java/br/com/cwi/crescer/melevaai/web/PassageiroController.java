package br.com.cwi.crescer.melevaai.web;

import br.com.cwi.crescer.melevaai.domain.pessoa.passageiro.Passageiro;
import br.com.cwi.crescer.melevaai.security.UserPrincipal;
import br.com.cwi.crescer.melevaai.service.passageiro.BuscarTodosPassageirosService;
import br.com.cwi.crescer.melevaai.service.passageiro.DepositarPassageiroService;
import br.com.cwi.crescer.melevaai.service.passageiro.SalvarPassageiroService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/passageiros")
public class PassageiroController {

    @Autowired
    private BuscarTodosPassageirosService buscarTodosPassageirosService;

    @Autowired
    private SalvarPassageiroService salvarPassageiroService;

    @Autowired
    private DepositarPassageiroService depositarPassageiroService;

    @RolesAllowed({"ROLE_ADMIN"})
    @GetMapping
    public Page<Passageiro> mostrarPassageiros(@PageableDefault(sort = "dataNascimento") Pageable pageable) {
        return buscarTodosPassageirosService.buscarPassageiros(pageable);
    }

    @PostMapping
    @ApiOperation("Cadastrar um novo passageiro.")
    @ApiResponses({@ApiResponse(code = 201, message = "Sucesso"), @ApiResponse(code = 400, message = "Request inválido")})
    public ResponseEntity<Passageiro> cadastrarPassageiro(@Valid @RequestBody Passageiro novoPassageiro) {

        Passageiro passageiro = salvarPassageiroService.salvar(novoPassageiro);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoPassageiro);
    }

    @PutMapping("/{cod-passageiro}/conta-virtual")
    @RolesAllowed({"ROLE_PASSAGEIRO"})
    public ResponseEntity<?> depositarPassageiro(@PathVariable("cod-passageiro") Long idPassageiro, @RequestParam BigDecimal valorDepositado) {

        Passageiro passageiro = depositarPassageiroService.depositar(idPassageiro, valorDepositado);

        return ResponseEntity.status(HttpStatus.CREATED).body(passageiro);
    }
}
