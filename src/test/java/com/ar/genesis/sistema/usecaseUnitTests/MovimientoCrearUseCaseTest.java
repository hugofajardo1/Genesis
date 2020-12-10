package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.*;
import com.ar.genesis.sistema.core.exception.MovimientoIncompletoException;
import com.ar.genesis.sistema.core.exception.RubroExisteException;
import com.ar.genesis.sistema.core.repository.IMovimientoRepository;
import com.ar.genesis.sistema.core.usecase.MovimientoCrearUseCase;
import com.ar.genesis.sistema.core.usecase.RubroCrearUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class MovimientoCrearUseCaseTest {
    @Mock
    IMovimientoRepository miMovimientoRepository;
    @Test
    void crearMovimiento_MovimientoNoExiste_GuardaCorrectamente() throws MovimientoIncompletoException {
        Ficha unaFicha = Ficha.instancia(1, "Fajardo, Hugo", "Bs As 245", Localidad.instancia(1, "Chilecito"), Provincia.instancia(1, "La Rioja"), "3825416543", TipoIva.instancia(1, "Responsable Inscripto"), "20255071336", "B-00007-777", "Contacto: Fajardo");
        Movimiento unMovimiento = Movimiento.instancia(null, TipoMovimiento.instancia(1, "Factura A"), unaFicha, unaFicha.getTipoIva(), unaFicha.getCuit(), LocalDate.now(), LocalTime.now(), 200.0, 200.0, 200.0);
        Producto unProducto = Producto.instancia(1, "Teclado Genius USB", "A548743", "770077007700770", TipoUnidad.instancia(1, "Unidad"), 100, 21, 35, 0, Rubro.instancia(1,"Hardware"), SubRubro.instancia(1, "Perifericos"), Ubicacion.instancia(1, "Estante 1"), Proveedor.instancia(1, "Proveedor 1"));
        MovimientoItem unItem = MovimientoItem.instancia(null, unProducto, 1.0, unProducto.getIva(), unProducto.getCosto(), unProducto.getPrecioVenta(), unProducto.getPrecioVenta());
        unMovimiento.getMovimientos().add(unItem);
        when(miMovimientoRepository.validarMovimiento(unMovimiento)).thenReturn(true);
        when(miMovimientoRepository.guardarMovimiento(unMovimiento)).thenReturn(true);
        MovimientoCrearUseCase movimientoCrearUseCase = new MovimientoCrearUseCase(miMovimientoRepository);
        boolean resultado = movimientoCrearUseCase.crearMovimiento(unMovimiento);
        Assertions.assertTrue(resultado);
    }
    @Test
    void crearMovimiento_MovimientoIncompleto_NoGuardaMovimiento() throws MovimientoIncompletoException {
        Ficha unaFicha = Ficha.instancia(1, "Fajardo, Hugo", "Bs As 245", Localidad.instancia(1, "Chilecito"), Provincia.instancia(1, "La Rioja"), "3825416543", TipoIva.instancia(1, "Responsable Inscripto"), "20255071336", "B-00007-777", "Contacto: Fajardo");
        Movimiento unMovimiento = Movimiento.instancia(null, TipoMovimiento.instancia(1, "Factura A"), unaFicha, unaFicha.getTipoIva(), unaFicha.getCuit(), LocalDate.now(), LocalTime.now(), 200.0, 200.0, 200.0);
        when(miMovimientoRepository.validarMovimiento(unMovimiento)).thenReturn(false);
        when(miMovimientoRepository.guardarMovimiento(unMovimiento)).thenReturn(false);
        MovimientoCrearUseCase movimientoCrearUseCase = new MovimientoCrearUseCase(miMovimientoRepository);
        Assertions.assertThrows(MovimientoIncompletoException.class, () -> movimientoCrearUseCase.crearMovimiento(unMovimiento));
    }
}
