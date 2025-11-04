package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;

    }

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
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    // Mostrar ninja por id (Read)
    @GetMapping("/listarID")
    public String mostrarTodosOsNinjasPorId() {
        return "Ninja por Id";
    }

    // Alterar dados dos ninjas (Update)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId() {
        return "Alterar ninja por Id";
    }

    // Deletar ninja (Delete)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId() {
        return "Deletar ninja por Id";
    }
}
