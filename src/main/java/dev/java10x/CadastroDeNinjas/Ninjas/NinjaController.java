package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {
    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Hello World";
    }

    // Adicionar ninja (Create)
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja Criado!";
    }

    // Mostrar todos os ninjas (Read)
    @GetMapping("/todos")
    public String mostrarTodosOsNinjas() {
        return "Mostrar todos os ninjas";
    }

    // Mostrar ninja por id (Read)
    @GetMapping("/todosID")
    public String mostrarTodosOsNinjasPorId() {
        return "Ninja por Id";
    }

    // Alterar dados dos ninjas (Update)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId() {
        return "Alterar ninja por Id";
    }

    // Deletar ninja (Delete)
    @DeleteMapping("/deletarPorID")
    public String deletarNinjaPorId() {
        return "Deletar ninja por Id";
    }
}
