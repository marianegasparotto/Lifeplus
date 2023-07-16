package com.api.lifeplus.controller;
import com.api.lifeplus.domain.dto.AtualizarPrecoDto;
import com.api.lifeplus.domain.dto.CadastrarMedicamentoDto;
import com.api.lifeplus.domain.dto.ExcluirMedicamentoDto;
import com.api.lifeplus.domain.model.Medicamentos;
import com.api.lifeplus.infra.repository.MedicamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentosController {
    @Autowired
    private MedicamentosRepository repository;

    @GetMapping("/ordenar_medicamento")
    public List<Medicamentos> getAllMedicamentos(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicamentos> getMedicamentosById(@PathVariable Long id) {
        Medicamentos medicamentos = repository.findById(id)
                .orElse(null);

        if (medicamentos != null) {
            return ResponseEntity.ok(medicamentos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/cadastro_medicamento")
    public Medicamentos createMedicamento(@RequestBody CadastrarMedicamentoDto medicamento) {
        Medicamentos newMedicamentos = new Medicamentos(medicamento);
        return repository.save(newMedicamentos);
    }

    @PutMapping("/att_preco_medicamento/{id}")
    @Transactional
    public Medicamentos updateMedicamento(@PathVariable Long id,@RequestBody AtualizarPrecoDto medicamento) {
        Medicamentos selectMedicamento = repository.getReferenceById(id);
        selectMedicamento.setPreco(medicamento.getPreco());
        selectMedicamento.setPrecoComDesconto(medicamento.getPrecoComDesconto());
        return repository.save(selectMedicamento);
    }

    @DeleteMapping("/excluir_medicamento")
    public ResponseEntity<Void> deleteMedicamento(@RequestBody ExcluirMedicamentoDto deleteDto) {
        Long id = deleteDto.getId();
        repository.findById(id).ifPresent(medicamento -> {
            repository.delete(medicamento);
        });

        return ResponseEntity.noContent().build();
    }

}