package com.api.lifeplus.domain.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CadastrarInjetavelDto {
    private long id;
    private String nome;
    private String concentracao;
    private String apresentacao;
    private String qtdPorUnidade;
    private String marca;
    private String descricao;
    private int preco;
    private int precoComDesconto;
    private String tipoDeAplicacao;

}
