package br.com.cwi.crescer.melevaai.web;

import br.com.cwi.crescer.melevaai.domain.veiculo.Veiculo;
import br.com.cwi.crescer.melevaai.domain.veiculo.request.RequestVeiculo;
import br.com.cwi.crescer.melevaai.service.veiculo.BuscarTodosVeiculosService;
import br.com.cwi.crescer.melevaai.service.veiculo.SalvarVeiculoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private BuscarTodosVeiculosService buscarTodosVeiculosService;

    @Autowired
    private SalvarVeiculoService salvarVeiculoService;

    @GetMapping
    @RolesAllowed({"ROLE_ADMIN"})
    public Page<Veiculo> veiculos(@PageableDefault(sort = "ano") Pageable pageable) {
        return buscarTodosVeiculosService.buscarVeiculos(pageable);
    }

    @PostMapping
    @ApiOperation("Cadastrar um novo veiculo.")
    @ApiResponses({@ApiResponse(code = 201, message = "Sucesso"), @ApiResponse(code = 400, message = "Request inválido")})
    public ResponseEntity<Veiculo> cadastrarVeiculo(@RequestBody RequestVeiculo requestVeiculo) {

        Veiculo novoVeiculo = new Veiculo(requestVeiculo.getMarca(), requestVeiculo.getModelo(), requestVeiculo.getAno()
                , requestVeiculo.getCor(), requestVeiculo.getFoto(), requestVeiculo.getQuantidadeLugares()
                , requestVeiculo.getCategoria(), requestVeiculo.getPlaca(), null);

        salvarVeiculoService.salvar(novoVeiculo, requestVeiculo.getIdMotorista());

        return ResponseEntity.status(HttpStatus.CREATED).body(novoVeiculo);
    }

}
