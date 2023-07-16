package com.api.lifeplus.domain.model;

import com.api.lifeplus.domain.dto.CadastrarMedicamentoDto;
import lombok.*;

import javax.persistence.*;

@Table(name = "medicamentos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class Medicamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)

    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "concentracao")
    private String concentracao;
    @Column(name = "apresentacao")
    private String apresentacao;
    @Column(name = "qtd_por_unidade")
    private String qtdPorUnidade;
    @Column(name = "marca")
    private String marca;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "preco")
    private int preco;
    @Column(name = "preco_com_desconto")
    private int precoComDesconto;

    public Medicamentos(CadastrarMedicamentoDto cadastrarMedicamentoDto) {
        this.nome = cadastrarMedicamentoDto.getNome();
        this.concentracao = cadastrarMedicamentoDto.getConcentracao();
        this.apresentacao = cadastrarMedicamentoDto.getApresentacao();
        this.qtdPorUnidade = cadastrarMedicamentoDto.getQtdPorUnidade();
        this.marca = cadastrarMedicamentoDto.getMarca();
        this.descricao = cadastrarMedicamentoDto.getDescricao();
        this.preco = cadastrarMedicamentoDto.getPreco();
        this.precoComDesconto = cadastrarMedicamentoDto.getPrecoComDesconto();

    }

}


