package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissaoService {
    private MissaoRepository missaoRepository;
    private MissaoMapper missaoMapper;

    public MissaoService(MissaoRepository missaoRepository, MissaoMapper missaoMapper) {
        this.missaoRepository = missaoRepository;
        this.missaoMapper = missaoMapper;
    }

    public List<MissaoDTO> listarMissoes() {
        List<MissaoModel> missaoModelList = missaoRepository.findAll();
        return missaoModelList.stream().map(missaoMapper::map).collect(Collectors.toList());
    }

    public MissaoDTO listarMissaoPorId(Long id) {
        Optional<MissaoModel> missaoPorId = missaoRepository.findById(id);

        return missaoPorId.map(missaoMapper::map).orElse(null);
    }

    public MissaoDTO criarMissao(MissaoDTO newMissao) {
        MissaoModel missaoModel = missaoMapper.map(newMissao);
        missaoRepository.save(missaoModel);
        return missaoMapper.map(missaoModel);

    }

    public MissaoDTO atualizarMissao(Long id, MissaoDTO missaoAtualizada) {
        Optional<MissaoModel> missaoExistente = missaoRepository.findById(id);
        if (missaoExistente.isPresent()) {
            MissaoModel missaoModel = missaoMapper.map(missaoAtualizada);
            missaoModel.setId(id);
            MissaoModel missaoSalva = missaoRepository.save(missaoModel);
            return missaoMapper.map(missaoSalva);
        }
        return null;

    }

    public void deletarMissao(Long id) {
        missaoRepository.deleteById(id);
    }
}
