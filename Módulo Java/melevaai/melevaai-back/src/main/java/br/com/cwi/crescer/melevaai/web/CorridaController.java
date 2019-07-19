package br.com.cwi.crescer.melevaai.web;

import br.com.cwi.crescer.melevaai.domain.corrida.Corrida;
import br.com.cwi.crescer.melevaai.domain.corrida.Situacao;
import br.com.cwi.crescer.melevaai.domain.dto.CustoPorPassageiroDto;
import br.com.cwi.crescer.melevaai.domain.dto.CustosCorridaDto;
import br.com.cwi.crescer.melevaai.domain.pessoa.passageiro.Passageiro;
import br.com.cwi.crescer.melevaai.domain.veiculo.Cor;
import br.com.cwi.crescer.melevaai.domain.veiculo.Veiculo;
import br.com.cwi.crescer.melevaai.exception.ExceptionCorrida;
import br.com.cwi.crescer.melevaai.security.UserPrincipal;
import br.com.cwi.crescer.melevaai.service.corrida.*;
import br.com.cwi.crescer.melevaai.service.passageiro.BuscarPassageiroService;
import br.com.cwi.crescer.melevaai.service.veiculo.SalvarVeiculoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/corridas")
public class CorridaController {

    @Autowired
    private SalvarCorridaService salvarCorridaService;

    @Autowired
    private AvaliacaoMotoristaService avaliacaoMotoristaService;

    @Autowired
    private AvaliacaoPassageiroService avaliacaoPassageiroService;

    @Autowired
    private IniciarCorridaService iniciarCorridaService;

    @Autowired
    private FinalizarCorridaService finalizarCorridaService;

    @Autowired
    private BuscarTodasCorridasService buscarTodasCorridasService;

    @Autowired
    private BuscarGastosCorridasService buscarGastosCorridasService;

    @Autowired
    private BuscarGastosPassageirosPorDataService buscarGastosPassageirosPorDataService;

    @Autowired
    private BuscarTodasCorridasPorIdPassageiroService buscarTodasCorridasPorIdPassageiroService;

    @GetMapping
    @RolesAllowed({"ROLE_ADMIN"})
    public ResponseEntity<List<Corrida>> corridas() {
        return ResponseEntity.ok(buscarTodasCorridasService.buscar());
    }

    @GetMapping("/gastos")
    @RolesAllowed({"ROLE_ADMIN"})
    public ResponseEntity<List<?>> gastoCorridas() {
        return ResponseEntity.ok(buscarGastosCorridasService.buscar());
    }

    @GetMapping("/gastos/passageiros/{id}/periodo")
    @RolesAllowed({"ROLE_ADMIN"})
    public ResponseEntity<?> gastoCorridasPassageiro(@PathVariable("id") Long idPassageiro
            , @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime data1
            , @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime data2) {
        return ResponseEntity.ok(buscarGastosPassageirosPorDataService.buscar(idPassageiro, data1, data2));
    }

    @GetMapping("/passageiros")
    @RolesAllowed({"ROLE_PASSAGEIRO"})
    public ResponseEntity<?> listarCorridasPassageiro(@AuthenticationPrincipal UserPrincipal currentUser) {

        List<Corrida> listaCorridasPassageiro = buscarTodasCorridasPorIdPassageiroService.buscar(currentUser.getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(listaCorridasPassageiro);
    }

    @PostMapping("/passageiros")
    @ApiOperation("Cadastrar uma nova corrida.")
    @ApiResponse(code = 201, message = "Sucesso")
    @RolesAllowed({"ROLE_PASSAGEIRO"})
    public ResponseEntity<?> chamarCorrida(@AuthenticationPrincipal UserPrincipal currentUser , @RequestBody Corrida novaCorrida) {

        Corrida corrida = salvarCorridaService.salvar(currentUser.getId(), novaCorrida);

        return ResponseEntity.status(HttpStatus.CREATED).body(corrida);
    }

    @PostMapping("/{cod-corrida}")
    @ApiOperation("Iniciar uma nova corrida.")
    @RolesAllowed({"ROLE_MOTORISTA"})
    @ApiResponses({@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 400, message = "Request inválido")})
    public ResponseEntity<?> iniciarCorrida(@PathVariable("cod-corrida") Long idCorrida) {

        String[] iniciarCorridaDados = iniciarCorridaService.iniciar(idCorrida);

        return ResponseEntity.status(HttpStatus.CREATED).body(iniciarCorridaDados);

    }

    @PutMapping("/{cod-corrida}/passageiros/avaliacao")
    @RolesAllowed({"ROLE_MOTORISTA"})
    public ResponseEntity<?> avaliarPassageiro(@AuthenticationPrincipal UserPrincipal currentUser, @PathVariable("cod-corrida") Long idCorrida, @RequestParam int nota) {

        Corrida corrida = avaliacaoPassageiroService.avaliar(currentUser, idCorrida, nota);

        return ResponseEntity.status(HttpStatus.CREATED).body(corrida);
    }

    @PutMapping("/{cod-corrida}/motoristas/avaliacao")
    @RolesAllowed({"ROLE_PASSAGEIRO"})
    public ResponseEntity<?> avaliarMotorista(@PathVariable("cod-corrida") Long idCorrida, @RequestParam int nota) {

        Corrida corrida = avaliacaoMotoristaService.avaliar(idCorrida, nota);

        return ResponseEntity.status(HttpStatus.CREATED).body(corrida);

    }

    @PutMapping("/{cod-corrida}")
    @RolesAllowed({"ROLE_MOTORISTA"})
    public ResponseEntity<?> finalizarCorrida(@PathVariable("cod-corrida") Long idCorrida) {

        Corrida corridaEmAndamento = finalizarCorridaService.finalizar(idCorrida);

        return ResponseEntity.status(HttpStatus.CREATED).body(corridaEmAndamento);

    }

}
