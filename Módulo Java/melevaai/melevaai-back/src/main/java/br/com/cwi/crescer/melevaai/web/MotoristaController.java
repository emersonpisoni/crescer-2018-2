package br.com.cwi.crescer.melevaai.web;

import br.com.cwi.crescer.melevaai.domain.pessoa.motorista.Motorista;
import br.com.cwi.crescer.melevaai.service.motorista.BuscarTodosMotoristasService;
import br.com.cwi.crescer.melevaai.service.motorista.RemoverMotoristaService;
import br.com.cwi.crescer.melevaai.service.motorista.SacarMotoristaService;
import br.com.cwi.crescer.melevaai.service.motorista.SalvarMotoristaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
@RequestMapping("/motoristas")
public class MotoristaController {

    @Autowired
    private BuscarTodosMotoristasService findAllService;

    @Autowired
    private SacarMotoristaService sacarService;

    @Autowired
    private SalvarMotoristaService saveService;

    @Autowired
    private RemoverMotoristaService removeByIdService;

    @GetMapping
    public Page<Motorista> motoristas(@PageableDefault(sort = "nome") Pageable pageable) {
        return findAllService.buscar(pageable);
    }

    @PostMapping
    @ApiOperation("Cadastrar um novo motorista.")
    @ApiResponses({@ApiResponse(code = 201, message = "Sucesso"), @ApiResponse(code = 400, message = "Request inválido")})
    public ResponseEntity<Motorista> cadastrarMotorista(@Valid @RequestBody Motorista novoMotorista) {

        Motorista motorista = saveService.cadastrar(novoMotorista);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoMotorista);

    }

    @PutMapping("/{cod-motorista}/conta-virtual")
    @ApiOperation("Sacar da conta do motorista")
    @RolesAllowed({"ROLE_MOTORISTA"})
    public ResponseEntity<?> sacarMotorista(@PathVariable("cod-motorista") Long idMotorista, @RequestParam BigDecimal valorSacado) {

        Motorista motorista = sacarService.sacar(idMotorista, valorSacado);

        return ResponseEntity.status(HttpStatus.CREATED).body(motorista);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Deletar motorista")
    @ApiResponse(code = 204, message = "Sucesso")
    @RolesAllowed({"ROLE_ADMIN"})
    public void deixarServico(@PathVariable("id") @NonNull Long id) {

        removeByIdService.remover(id);

    }
}


