package br.com.alurafood.pagamentos.controller;

import br.com.alurafood.pagamentos.dto.PagamentoDto;
import br.com.alurafood.pagamentos.service.PagamentoService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    PagamentoService pagamentoService;

    @GetMapping
    public Page<PagamentoDto> listar(@PageableDefault(size = 10) Pageable paginacao) {
        return pagamentoService.obeterTodos(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoDto> detalhar(@PathVariable @NotNull Long id){
        PagamentoDto dto = pagamentoService.obterPorId(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<PagamentoDto> cadastrar(@RequestBody @Valid PagamentoDto dto, UriComponentsBuilder uriBuilder) {
        PagamentoDto pagamento = pagamentoService.criarPagamento(dto);
        URI endereco = uriBuilder.path("/pagamentos/{id}").buildAndExpand(pagamento.getId()).toUri();
        return ResponseEntity.created(endereco).body(pagamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PagamentoDto> atualizar(@PathVariable @NotNull Long id, @RequestBody @Valid PagamentoDto dto) {
        PagamentoDto atualizado = pagamentoService.atualizarPagamento(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PagamentoDto> remover(@PathVariable @NotNull Long id) {
        pagamentoService.excluirPagamento(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/porta")
    public String retornaPorta(@Value("${local.server.port}") String porta){
        return String.format("Requisição respondida pela instância executando na porta %s", porta);
    }

    @PatchMapping("/{id}/confirmar")
    @CircuitBreaker(name = "atualizaPedido", fallbackMethod = "")
    public void confirmarPagamento(@PathVariable @NotNull Long id){
        pagamentoService.confirmarPagamento(id);
    }

    public void pagamentoAutorizadoComIntegracaoPendente(Long id, Exception e){
        pagamentoService.alteraStatus(id);
    }
}
