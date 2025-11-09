package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {
    //aqui tb podemos usar a anotação @Autowired para iniciar
    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // listar todos os meus ninjas
    public List<NinjaDTO> listarNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        // vamos transformar cada um dos objetos da lista
        return ninjas.stream().map(ninjaMapper::map).collect(Collectors.toList());

    }

    // Listar ninja por Id
    public NinjaDTO listarNinjasPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);

        return ninjaPorId.map(ninjaMapper::map).orElse(null);
    }

    // Criar um novo ninja.
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        // Mapeamos um DTO para model para usar no ninjaRepository
        // usar o JPA o métod save()
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninjaRepository.save(ninja);
        // Mapeamos novamente, mas agora para DTO para retornar no métod
        return ninjaMapper.map(ninja);

    }

    // Deletar o ninja (tem que ser um métod void)
    public void deletarNinjaPorId(Long id) {
        ninjaRepository.deleteById(id);
    }

    // Atualizar ninja
    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaAtualizado) {
      Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if (ninjaExistente.isPresent()) {
            NinjaModel ninja = ninjaMapper.map(ninjaAtualizado);
            ninja.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninja);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }
}

