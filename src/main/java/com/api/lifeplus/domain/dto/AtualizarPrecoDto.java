package com.api.lifeplus.domain.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AtualizarPrecoDto {
    private int preco;
    private int precoComDesconto;
}
