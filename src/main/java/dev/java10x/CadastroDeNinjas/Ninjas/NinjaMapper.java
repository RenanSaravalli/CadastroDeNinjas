package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {
      public NinjaModel map(NinjaDTO ninjaDTO) {
          NinjaModel ninjaModel = new NinjaModel();

          ninjaModel.setId(ninjaDTO.getId());
          ninjaModel.setNome(ninjaDTO.getNome());
          ninjaModel.setEmail(ninjaDTO.getEmail());
          ninjaModel.setImgUrl(ninjaDTO.getImgUrl());
          ninjaModel.setRank(ninjaDTO.getRank());
          ninjaModel.setIdade(ninjaDTO.getIdade());
          ninjaModel.setMissao(ninjaDTO.getMissao());

          return ninjaModel;
      }

      public NinjaDTO map(NinjaModel ninjaModel) {
          NinjaDTO ninjaDTO = new NinjaDTO();

          ninjaDTO.setId(ninjaModel.getId());
          ninjaDTO.setNome(ninjaModel.getNome());
          ninjaDTO.setEmail(ninjaModel.getEmail());
          ninjaDTO.setImgUrl(ninjaModel.getImgUrl());
          ninjaDTO.setRank(ninjaModel.getRank());
          ninjaDTO.setIdade(ninjaModel.getIdade());
          ninjaDTO.setMissao(ninjaModel.getMissao());

          return ninjaDTO;
      }
}
