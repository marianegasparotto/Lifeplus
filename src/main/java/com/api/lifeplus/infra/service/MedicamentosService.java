package com.api.lifeplus.infra.service;

import com.api.lifeplus.domain.dto.AtualizarPrecoDto;
import com.api.lifeplus.domain.dto.CadastrarMedicamentoDto;
import com.api.lifeplus.domain.model.Medicamentos;
import com.api.lifeplus.infra.repository.MedicamentosRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MedicamentosService {
    @Autowired
    private MedicamentosRepository repository;

    public List<Medicamentos> getAllMedicamentos() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new ServiceException("Não foi possível obter a lista de medicamentos", e);
        }
    }

    public Optional<Medicamentos> getMedicamentosById(Long id) {
        return repository.findById(id);
    }

    public Medicamentos createMedicamento(CadastrarMedicamentoDto medicamento) {
        try {
            Medicamentos newMedicamento = new Medicamentos(medicamento);
            return repository.save(newMedicamento);
        } catch (Exception e) {
            throw new ServiceException("Não foi possível cadastrar  o medicamento", e);
        }
    }

    @Transactional
    public Medicamentos updateMedicamento(Long id, AtualizarPrecoDto medicamento) {
        try {
            Medicamentos selectMedicamento = repository.getReferenceById(id);
            selectMedicamento.setPreco(medicamento.getPreco());
            selectMedicamento.setPrecoComDesconto(medicamento.getPrecoComDesconto());
            return repository.save(selectMedicamento);
        } catch (Exception e) {
            throw new ServiceException("Não foi possível atualizar o medicamento escolhido", e);
        }
    }

    public void deleteMedicamento(Long id) {
        Optional<Medicamentos> medicamentoOptional = repository.findById(id);
        if (medicamentoOptional.isPresent()) {
            try {
                repository.delete(medicamentoOptional.get());
            } catch (Exception e) {
                throw new ServiceException("Erro ao excluir o medicamento selecionado", e);
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Medicamento escolhido não encontrado");
        }
    }
}
