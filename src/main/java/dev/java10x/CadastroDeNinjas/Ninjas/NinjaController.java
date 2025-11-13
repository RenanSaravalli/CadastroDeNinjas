package dev.java10x.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Mensagem de boas vindas",description = "Essa rota da uma mensagem de boas vindas")
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
    @Operation(summary = "Lista o ninja por Id", description = "Rota para listar um ninja pelo id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Ninja não encontrado")
    })
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id) {
        NinjaDTO ninjaEncontrado = ninjaService.listarNinjasPorId(id);
        if (ninjaEncontrado != null) {
            return ResponseEntity.ok(ninjaEncontrado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja de id: " + id + " não encontrado");
        }
    }

    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja", description = "Rota cria um novo ninja e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do ninja")
    }) // Respostas da api oq acontece de acordo com o status
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja) {
        return ninjaService.criarNinja(ninja);
    }

    // Alterar dados dos ninjas (Update)
    @PutMapping("/alterar/{id}")
    @Operation(summary = "Altera um ninja", description = "Rota altera um ninja pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Ninja não encontado, não foi possível alterar")
    })
    public ResponseEntity<?> alterarNinjaPorId(
            @Parameter(description = "Usuário manda o id no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuário manda os dados do ninja a ser atualizado no corpo da requisição")
            @RequestBody NinjaDTO ninjaAtualizado) {

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
