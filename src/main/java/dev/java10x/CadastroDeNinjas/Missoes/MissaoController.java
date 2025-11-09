package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// localhost:8080/missao
@RestController
@RequestMapping("/missao")
public class MissaoController {

    private MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    // GET -- Mandar uma requisição para mostrar as missões
    @GetMapping("/listar")
    public List<MissaoDTO> listarMissoes() {
        return missaoService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissaoDTO listarMissaoPorId(@PathVariable Long id) {
        return missaoService.listarMissaoPorId(id);
    }

    // post -- Mandar uma requisição para criar as missões
    @PostMapping("/criar")
    public MissaoDTO criarMissao(@RequestBody MissaoDTO missaoModel) {
        return missaoService.criarMissao(missaoModel);
    }

    // PUT -- Mandar uma requisição para ALterar as missões
    @PutMapping("/alterar/{id}")
    public MissaoDTO alterarMissao(@PathVariable Long id, @RequestBody MissaoDTO missaoAtualizada) {
        return missaoService.atualizarMissao(id, missaoAtualizada);
    }

    // DELETE -- Mandar uma requisição para Deletar as missões
    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id) {
        missaoService.deletarMissao(id);
    }

}
