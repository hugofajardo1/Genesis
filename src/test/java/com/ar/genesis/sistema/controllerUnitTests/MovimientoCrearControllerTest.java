package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Movimiento;
import com.ar.genesis.sistema.core.exception.MovimientoExisteException;
import com.ar.genesis.sistema.core.exception.MovimientoIncompletoException;
import com.ar.genesis.sistema.core.input.IMovimientoCrearInput;
import com.ar.genesis.sistema.service.controller.MovimientoCrearController;
import com.ar.genesis.sistema.service.dto.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MovimientoCrearControllerTest {
    @Mock
    IMovimientoCrearInput miMovimientoCrearInput;

    @Test
    public  void crearMovimiento_MovimientoNoExiste_Devuelve200() throws MovimientoExisteException, MovimientoIncompletoException {
        FichaDTO unaFichaDTO = new FichaDTO(1, "Fajardo, Hugo Manuel", "Bs As 245", new LocalidadDTO(1, "Chilecito"), new ProvinciaDTO(1, "La Rioja"),"3825416543", new TipoIvaDTO(1, "Responsable Inscripto"), "20255071336", "007-4343-0", "hugofajardo1@gmail.com");
        ProductoDTO unProductoDTO = new ProductoDTO(1, "Producto", "C42343", "770077007700770", new TipoUnidadDTO(1, "Unidad"), 100.0, 21.0, 35.0, 0.0, new RubroDTO(1, "Hardware"), new SubRubroDTO(1, "Perifericos"), new UbicacionDTO(1, "Estante 1"), new ProveedorDTO(1, "Proveedor 1"));
        MovimientoItemDTO  unMovimientoItemDTO = new MovimientoItemDTO(1, unProductoDTO, 1.0, unProductoDTO.getIva(), unProductoDTO.getCosto(), unProductoDTO.getPrecioVenta(), unProductoDTO.getPrecioVenta());
        ArrayList<MovimientoItemDTO> itemsDTO = new ArrayList<>();
        itemsDTO.add(unMovimientoItemDTO);
        MovimientoDTO unMovimientoDTO = new MovimientoDTO(null, new TipoMovimientoDTO(1, "Factura A"), unaFichaDTO, unaFichaDTO.getTipoIva(), unaFichaDTO.getCuit(), LocalDate.now(), LocalTime.now(), 100.0, 121.0, 121.0, itemsDTO);
        when(miMovimientoCrearInput.crearMovimiento(any(Movimiento.class))).thenReturn(true);

        MovimientoCrearController movimientoCrearController = new MovimientoCrearController(miMovimientoCrearInput);
        ResponseEntity<?> responseEntity = movimientoCrearController.crearMovimiento(unMovimientoDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearMovimiento_MovimientoExiste_Devuelve412() throws MovimientoExisteException, MovimientoIncompletoException {
        FichaDTO unaFichaDTO = new FichaDTO(1, "Fajardo, Hugo Manuel", "Bs As 245", new LocalidadDTO(1, "Chilecito"), new ProvinciaDTO(1, "La Rioja"),"3825416543", new TipoIvaDTO(1, "Responsable Inscripto"), "20255071336", "007-4343-0", "hugofajardo1@gmail.com");
        ProductoDTO unProductoDTO = new ProductoDTO(1, "Producto", "C42343", "770077007700770", new TipoUnidadDTO(1, "Unidad"), 100.0, 21.0, 35.0, 0.0, new RubroDTO(1, "Hardware"), new SubRubroDTO(1, "Perifericos"), new UbicacionDTO(1, "Estante 1"), new ProveedorDTO(1, "Proveedor 1"));
        MovimientoItemDTO  unMovimientoItemDTO = new MovimientoItemDTO(1, unProductoDTO, 1.0, unProductoDTO.getIva(), unProductoDTO.getCosto(), unProductoDTO.getPrecioVenta(), unProductoDTO.getPrecioVenta());
        ArrayList<MovimientoItemDTO> itemsDTO = new ArrayList<>();
        itemsDTO.add(unMovimientoItemDTO);
        MovimientoDTO unMovimientoDTO = new MovimientoDTO(null, new TipoMovimientoDTO(1, "Factura A"), unaFichaDTO, unaFichaDTO.getTipoIva(), unaFichaDTO.getCuit(), LocalDate.now(), LocalTime.now(), 100.0, 121.0, 121.0, itemsDTO);
        when(miMovimientoCrearInput.crearMovimiento(any(Movimiento.class))).thenThrow(MovimientoExisteException.class);

        MovimientoCrearController movimientoCrearController = new MovimientoCrearController(miMovimientoCrearInput);
        ResponseEntity<?> responseEntity = movimientoCrearController.crearMovimiento(unMovimientoDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
