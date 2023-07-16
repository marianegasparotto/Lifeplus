package com.api.lifeplus.infra.service;

import com.api.lifeplus.domain.dto.AtualizarPrecoInjetavelDto;
import com.api.lifeplus.domain.dto.CadastrarInjetavelDto;
import com.api.lifeplus.domain.model.MedInjetaveis;
import com.api.lifeplus.infra.repository.MedInjetaveisRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class InjetaveisService {
    @Autowired
    private MedInjetaveisRepository medInjetaveisRepository;

    public List<MedInjetaveis> getAllMedInjetaveis() {
        try {
            return medInjetaveisRepository.findAll();
        } catch (Exception e) {
            throw new ServiceException("Não foi possível obter a lista de injetaveis", e);
        }
    }

    public Optional<MedInjetaveis> getMedInjetaveisById(Long id) {
        return medInjetaveisRepository.findById(id);
    }

    public MedInjetaveis createInjetaveis(CadastrarInjetavelDto injetaveis) {
        try {
            MedInjetaveis newInjetaveis = new MedInjetaveis(injetaveis);
            return medInjetaveisRepository.save(newInjetaveis);
        } catch (Exception e) {
            throw new ServiceException("Não foi possível cadastrar  o injetavel", e);
        }
    }

    @Transactional
    public MedInjetaveis updateInjetaveis(Long id, AtualizarPrecoInjetavelDto injetaveis) {
        try {
            MedInjetaveis selectInjetaveis = medInjetaveisRepository.getReferenceById(id);
            selectInjetaveis.setPreco(injetaveis.getPreco());
            selectInjetaveis.setPrecoComDesconto(injetaveis.getPrecoComDesconto());
            return medInjetaveisRepository.save(selectInjetaveis);
        } catch (Exception e) {
            throw new ServiceException("Não foi possível atualizar o preco do injetavel escolhido", e);
        }
    }

    public void deleteInjetavel(Long id) {
        Optional<MedInjetaveis> injetaveisOptional = medInjetaveisRepository.findById(id);
        if (injetaveisOptional.isPresent()) {
            try {
                medInjetaveisRepository.delete(injetaveisOptional.get());
            } catch (Exception e) {
                throw new ServiceException("Erro ao excluir o injetavel selecionado", e);
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Injetavel escolhido não encontrado ");
        }
    }
}
