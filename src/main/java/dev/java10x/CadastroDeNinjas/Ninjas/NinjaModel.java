package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissaoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Ele transforma uma classe numa Entidade do BD
@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    // Aqui com essa anotação. Estamos falando que ela é única
    @Column(unique = true, name = "email")
    private String email;

    @Column(name = "imgUrl")
    private String imgUrl;

    @Column(name = "rank")
    private String rank;

    @Column(name = "idade")
    private int idade;

    // Um ninja tem uma única missão.
    @ManyToOne
    @JoinColumn(name = "missao_id") // Foreign_key
    private MissaoModel missao;
}
