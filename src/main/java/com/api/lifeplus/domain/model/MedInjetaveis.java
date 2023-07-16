package com.api.lifeplus.domain.model;

import com.api.lifeplus.domain.dto.CadastrarInjetavelDto;
import lombok.*;

import javax.persistence.*;
import java.util.List;
@Table(name = "medicamentos_injetaveis")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class MedInjetaveis extends Medicamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="tipo_de_aplicacao",nullable = false)
    private String tipoDeAplicacao;

    @ManyToMany
    @JoinTable(
            name = "medicamentos_med_injetaveis",
            joinColumns = @JoinColumn(name = "medicamentos_injetaveis_id"),
            inverseJoinColumns = @JoinColumn(name = "medicamentos_id")
    )
    private List<Medicamentos> medicamentos;

    public MedInjetaveis(CadastrarInjetavelDto cadastrarInjetavelDto) {
        super(cadastrarInjetavelDto.getId(), cadastrarInjetavelDto.getNome(), cadastrarInjetavelDto.getConcentracao(),
                cadastrarInjetavelDto.getApresentacao(), cadastrarInjetavelDto.getQtdPorUnidade(),
                cadastrarInjetavelDto.getMarca(), cadastrarInjetavelDto.getDescricao(),cadastrarInjetavelDto.getPreco(),
                cadastrarInjetavelDto.getPrecoComDesconto());
        this.tipoDeAplicacao = cadastrarInjetavelDto.getTipoDeAplicacao();
    }
}



