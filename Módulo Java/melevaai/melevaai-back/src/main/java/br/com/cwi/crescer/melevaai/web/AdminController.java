package br.com.cwi.crescer.melevaai.web;

import br.com.cwi.crescer.melevaai.domain.pessoa.Pessoa;
import br.com.cwi.crescer.melevaai.service.admin.SalvarAdminService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private SalvarAdminService salvarAdminService;

    @PostMapping
    @ApiOperation("Cadastrar um novo admin.")
    @ApiResponses({@ApiResponse(code = 201, message = "Sucesso"), @ApiResponse(code = 400, message = "Request inválido")})
    public ResponseEntity<Pessoa> cadastrarMotorista(@Valid @RequestBody Pessoa admin) {

        Pessoa administrador = salvarAdminService.cadastrar(admin);

        return ResponseEntity.status(HttpStatus.CREATED).body(admin);

    }

}