package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

// localhost:8080/missao
@RestController
@RequestMapping("/missao")
public class MissaoController {

    // GET -- Mandar uma requisição para mostrar as missões
    @GetMapping("/listar")
    public String listarMissoes() {
        return "Missões listadas com sucesso";
    }

    // post -- Mandar uma requisição para criar as missões
    @PostMapping("/criar")
    public String criarMissao() {
        return "Missão criado com sucesso";
    }

    // PUT -- Mandar uma requisição para ALterar as missões
    @PutMapping("/alterar")
    public String alterarMissao() {
        return "Missão alterada com sucesso";
    }

    // DELETE -- Mandar uma requisição para Deletar as missões
    @DeleteMapping("/deletar")
    public String deletarMissao() {
        return "Missão deletada com sucesso";
    }

}
