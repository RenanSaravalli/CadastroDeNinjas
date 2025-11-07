package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissaoService {
    private MissaoRepository missaoRepository;


    public MissaoService(MissaoRepository missaoRepository) {
        this.missaoRepository = missaoRepository;
    }

    public List<MissaoModel> listarMissoes() {
        return missaoRepository.findAll();
    }

    public MissaoModel listarMissaoPorId(Long id) {
        Optional<MissaoModel> missaoPorId = missaoRepository.findById(id);

        return missaoPorId.orElse(null);
    }

    public MissaoModel criarMissao(MissaoModel missaoModel) {
        return missaoRepository.save(missaoModel);
    }

    public void deletarMissao(Long id) {
        missaoRepository.deleteById(id);
    }
}
