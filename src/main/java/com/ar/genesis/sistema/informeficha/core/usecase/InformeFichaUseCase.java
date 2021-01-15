package com.ar.genesis.sistema.informeficha.core.usecase;

import com.ar.genesis.sistema.ficha.core.domain.Ficha;
import com.ar.genesis.sistema.ficha.core.exception.FichaNoExisteException;
import com.ar.genesis.sistema.informeficha.core.domain.InformeFicha;
import com.ar.genesis.sistema.informeficha.core.input.IInformeFichaInput;
import com.ar.genesis.sistema.informeficha.core.repository.IInformeFichaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
public class InformeFichaUseCase implements IInformeFichaInput {

    IInformeFichaRepository miInformeFichaRepository;

    public InformeFichaUseCase(IInformeFichaRepository miInformeFichaRepository) { this.miInformeFichaRepository = miInformeFichaRepository; }

    @Override
    public InformeFicha obtenerInformeFicha(Integer id, LocalDate fechaDesde, LocalDate fechaHasta) throws FichaNoExisteException {
        InformeFicha unInformeFicha = miInformeFichaRepository.obtenerInformeFicha(id, fechaDesde, fechaHasta);
        if(unInformeFicha==null){
            throw new FichaNoExisteException();
        }
        return unInformeFicha;
    }
}
