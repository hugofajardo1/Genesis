package com.ar.genesis.sistema.informefichaTest.controller;

import com.ar.genesis.sistema.ficha.core.domain.Ficha;
import com.ar.genesis.sistema.ficha.core.exception.FichaNoExisteException;
import com.ar.genesis.sistema.informeficha.core.domain.InformeFicha;
import com.ar.genesis.sistema.informeficha.core.input.IInformeFichaInput;
import com.ar.genesis.sistema.informeficha.service.controller.InformeFichaController;
import com.ar.genesis.sistema.informeficha.service.dto.InformeFichaDTO;
import com.ar.genesis.sistema.localidad.core.domain.Localidad;
import com.ar.genesis.sistema.movimiento.core.domain.Movimiento;
import com.ar.genesis.sistema.movimiento.core.domain.MovimientoItem;
import com.ar.genesis.sistema.producto.core.domain.Producto;
import com.ar.genesis.sistema.proveedor.core.domain.Proveedor;
import com.ar.genesis.sistema.provincia.core.domain.Provincia;
import com.ar.genesis.sistema.puntoventa.core.domain.PuntoVenta;
import com.ar.genesis.sistema.rubro.core.domain.Rubro;
import com.ar.genesis.sistema.subrubro.core.domain.SubRubro;
import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import com.ar.genesis.sistema.tipoiva.core.domain.TipoIva;
import com.ar.genesis.sistema.tipomovimiento.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.tipounidad.core.domain.TipoUnidad;
import com.ar.genesis.sistema.ubicacion.core.domain.Ubicacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class InformeFichaControllerTest {
    @Mock
    IInformeFichaInput miInformeFichaInput;

    @Test
    public void obtenerInformeFichaPorId_DevuelveInformeFicha() throws FichaNoExisteException {
        PuntoVenta unPuntoVenta = PuntoVenta.instancia(1, "Punto Venta 1", Sucursal.instancia(1, "Sucursal 1"),5);
        Ficha unaFicha = Ficha.instancia(1, "Fajardo, Hugo", "Bs As 245", Localidad.instancia(1, "Chilecito"), Provincia.instancia(1, "La Rioja"), "3825416543", TipoIva.instancia(1, "Responsable Inscripto"), "20255071336", "B-00007-777", "Contacto: Fajardo");
        Movimiento unMovimiento = Movimiento.instanciaProveedor(null, unPuntoVenta, TipoMovimiento.instancia(1, "Factura A", "Debe"), 1, unaFicha, unaFicha.getTipoIva(), unaFicha.getCuit(), LocalDate.now(), LocalTime.now(), 200.0, 200.0, 200.0);
        Producto unProducto = Producto.instancia(1, "Teclado Genius USB", "A548743", "770077007700770", TipoUnidad.instancia(1, "Unidad"), 100, 21, 35, 0, Rubro.instancia(1,"Hardware"), SubRubro.instancia(1, "Perifericos"), Ubicacion.instancia(1, "Estante 1"), Proveedor.instancia(1, "Proveedor 1"));
        MovimientoItem unItem = MovimientoItem.instancia(null, unProducto, 1.0, unProducto.getIva(), unProducto.getCosto(), unProducto.getPrecioVenta(), unProducto.getPrecioVenta(), unMovimiento);
        unMovimiento.getItems().add(unItem);
        List<Movimiento> movimientos = new ArrayList<>();
        movimientos.add(unMovimiento);

        LocalDate fechaDesde = LocalDate.of(2020,12,1);
        LocalDate fechaHasta = LocalDate.of(2020,12,31);

        InformeFicha unInformeFicha = InformeFicha.instancia(unaFicha, fechaDesde, fechaHasta, 0.0, 200.0, movimientos);

        when(miInformeFichaInput.obtenerInformeFicha(1, fechaDesde, fechaHasta)).thenReturn(unInformeFicha);

        InformeFichaController informeFichaController = new InformeFichaController(miInformeFichaInput);
        ResponseEntity<?> responseEntity = informeFichaController.obtenerInformeFicha(1, fechaDesde, fechaHasta);
        InformeFichaDTO resultado = (InformeFichaDTO) responseEntity.getBody();
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerInformeFichaPorId_DevuelveNull() throws FichaNoExisteException {
        LocalDate fechaDesde = LocalDate.of(2020,12,1);
        LocalDate fechaHasta = LocalDate.of(2020,12,31);

        when(miInformeFichaInput.obtenerInformeFicha(1, fechaDesde, fechaHasta)).thenReturn(null);

        InformeFichaController informeFichaController = new InformeFichaController(miInformeFichaInput);
        ResponseEntity<?> responseEntity = informeFichaController.obtenerInformeFicha(1, fechaDesde, fechaHasta);
        InformeFichaDTO resultado = (InformeFichaDTO) responseEntity.getBody();
        Assertions.assertNull(resultado);
    }
}