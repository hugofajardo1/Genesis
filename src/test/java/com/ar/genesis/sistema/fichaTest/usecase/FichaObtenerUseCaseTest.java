package com.ar.genesis.sistema.fichaTest.usecase;

import com.ar.genesis.sistema.ficha.core.domain.Ficha;
import com.ar.genesis.sistema.localidad.core.domain.Localidad;
import com.ar.genesis.sistema.provincia.core.domain.Provincia;
import com.ar.genesis.sistema.tipoiva.core.domain.TipoIva;
import com.ar.genesis.sistema.ficha.core.repository.IFichaObtenerRepository;
import com.ar.genesis.sistema.ficha.core.usecase.FichaObtenerUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class FichaObtenerUseCaseTest {
    @Mock
    IFichaObtenerRepository miFichaObtenerRepository;

    @Spy
    List<Ficha> fichas = factoryListaFichas();

    @Test
    public void obtenerFichas_devuelveLista(){
        when(miFichaObtenerRepository.obtenerFichas()).thenReturn(fichas);
        FichaObtenerUseCase obtenerFichasUseCase = new FichaObtenerUseCase(miFichaObtenerRepository);
        List<Ficha> resultado = obtenerFichasUseCase.obtenerFichas();
        Assertions.assertEquals(2,resultado.size());
    }

    public List<Ficha> factoryListaFichas() {
        List<Ficha> fichas = new ArrayList<>();
        Ficha ficha1 = Ficha.instancia(1, "Fajardo, Hugo", "Bs As 245", Localidad.instancia(1, "Chilecito"), Provincia.instancia(1, "La Rioja"), "3825416543", TipoIva.instancia(1, "Responsable Inscripto"), "20255071336", "B-00007-777", "Contacto: Fajardo");
        Ficha ficha2 = Ficha.instancia(2, "Fajardo, Lourdes", "Juan XXIII 59", Localidad.instancia(1, "Chilecito"), Provincia.instancia(1, "La Rioja"), "5453454", TipoIva.instancia(1, "Responsable Inscripto"), "20255071336", "B-00007-777", "Contacto: Fajardo Luli");
        fichas.add(ficha1);
        fichas.add(ficha2);
        return fichas;
    }
}
