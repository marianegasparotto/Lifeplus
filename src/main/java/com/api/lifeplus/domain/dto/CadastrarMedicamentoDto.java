package com.api.lifeplus.domain.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
//o que sera usado no controller para realizar o método
public class CadastrarMedicamentoDto {
    private String nome;
    private String concentracao;
    private String apresentacao;
    private String qtdPorUnidade;
    private String marca;
    private String descricao;
    private int preco;
    private int precoComDesconto;

}
