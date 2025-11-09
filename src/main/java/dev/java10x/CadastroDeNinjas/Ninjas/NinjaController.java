package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;

    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Hello World";
    }

    // Adicionar ninja (Create)


    // Mostrar todos os ninjas (Read)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    // Mostrar ninja por id (Read)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id) {
        NinjaDTO ninjaEncontrado = ninjaService.listarNinjasPorId(id);
        if (ninjaEncontrado != null) {
            return ResponseEntity.ok(ninjaEncontrado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja de id: " + id + " não encontrado");
        }
    }

    // Alterar dados dos ninjas (Update)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja de id: " + id + " não encontrado");
        }
    }

    // Deletar ninja (Delete)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {
        // vamos buscar se existe um ninja com esse id
        if (ninjaService.listarNinjasPorId(id) != null) {
            // Existe um ninja com esse id
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com o id: " + id + " deletado com sucesso");
        } else {
            // Status de não encontrado
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com id: " + id + " não existe");
        }
    }
}
