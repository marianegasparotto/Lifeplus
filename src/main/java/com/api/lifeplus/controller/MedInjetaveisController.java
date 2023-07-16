package com.api.lifeplus.controller;

import com.api.lifeplus.domain.dto.AtualizarPrecoInjetavelDto;
import com.api.lifeplus.domain.dto.CadastrarInjetavelDto;
import com.api.lifeplus.domain.dto.ExcluirInjetavelDto;
import com.api.lifeplus.domain.model.MedInjetaveis;
import com.api.lifeplus.infra.repository.MedInjetaveisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medinjetaveis")
public class MedInjetaveisController {

    @Autowired
    private MedInjetaveisRepository medInjetaveisRepository;

    @GetMapping("/ordenar_injetavel")
    public List<MedInjetaveis> getAllMedInjetaveis() {
        return medInjetaveisRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedInjetaveis> getMedInjetaveisById(@PathVariable Long id) {
        MedInjetaveis medInjetaveis = medInjetaveisRepository.findById(id)
                .orElse(null);

        if (medInjetaveis != null) {
            return ResponseEntity.ok(medInjetaveis);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping ("/cadastro_injetavel")
    public MedInjetaveis createInjetaveis(@RequestBody CadastrarInjetavelDto injetaveis) {
        MedInjetaveis newMedInjetaveis = new MedInjetaveis(injetaveis);
        return medInjetaveisRepository.save(newMedInjetaveis);
    }

    @PutMapping("/att_preco_injetavel/{id}")
    @Transactional
    public MedInjetaveis updateMedInjetaveis(@PathVariable Long id, @RequestBody AtualizarPrecoInjetavelDto injetaveis) {
        MedInjetaveis selectInjetaveis = (MedInjetaveis) medInjetaveisRepository.getReferenceById(id);
        selectInjetaveis.setPreco(injetaveis.getPreco());
        selectInjetaveis.setPrecoComDesconto(injetaveis.getPrecoComDesconto());
        return medInjetaveisRepository.save(selectInjetaveis);
    }

    @DeleteMapping("/excluir_injetavel")
    public ResponseEntity<Void> deleteMedInjetaveis(@RequestBody ExcluirInjetavelDto deleteDto) {
        Long id = deleteDto.getId();
        medInjetaveisRepository.findById(id).ifPresent(injetaveis -> {
            medInjetaveisRepository.delete(injetaveis);
        });
        return ResponseEntity.noContent().build();
    }

}
