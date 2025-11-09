package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Component;

@Component
public class MissaoMapper {
    public MissaoModel map(MissaoDTO missaoDTO) {
        MissaoModel missaoModel = new MissaoModel();

        missaoModel.setId(missaoDTO.getId());
        missaoModel.setNome(missaoDTO.getNome());
        missaoModel.setRank(missaoDTO.getRank());
        missaoModel.setNinjas(missaoDTO.getNinjas());

        return missaoModel;
    }

    public MissaoDTO map(MissaoModel missaoModel) {
        MissaoDTO missaoDTO = new MissaoDTO();

        missaoDTO.setId(missaoModel.getId());
        missaoDTO.setNome(missaoModel.getNome());
        missaoDTO.setRank(missaoModel.getRank());
        missaoDTO.setNinjas(missaoModel.getNinjas());

        return missaoDTO;
    }
}
