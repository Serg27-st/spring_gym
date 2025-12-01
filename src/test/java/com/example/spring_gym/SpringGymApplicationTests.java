package com.example.spring_gym;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.spring_gym.model.Inventario;
import com.example.spring_gym.model.Socio;
import com.example.spring_gym.model.Venta;
import com.example.spring_gym.repository.InventarioRepository;
import com.example.spring_gym.repository.SocioRepository;
import com.example.spring_gym.repository.VentaRepository;

@SpringBootTest
class SpringGymApplicationTests {

	@Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private SocioRepository socioRepository;
	
    @Autowired
    private InventarioRepository inventarioRepository;

    // Logger apuntando a esta clase
    private static final Logger log = LoggerFactory.getLogger(SpringGymApplicationTests.class);

    @Test
    public void testCrearNuevoSocio() {
        // Crear un nuevo socio
        Socio socio = new Socio();
        socio.setNombre("Sergio Taf");
        socio.setEmail("sergio@example.com");
        socio.setPassword("1234");

        // Guardar en la base de datos
        Socio savedSocio = socioRepository.save(socio);

        // Verificar que se guardó correctamente
        assertThat(savedSocio.getIdSocio()).isNotNull();
        assertThat(savedSocio.getNombre()).isEqualTo("Sergio Taf");
        assertThat(savedSocio.getEmail()).isEqualTo("sergio@example.com");
        assertThat(savedSocio.getPassword()).isEqualTo("1234");

        // Mostrar mensaje en la terminal
        System.out.println("SIN ERROR");
    }

	@Test
    public void testCrearNuevoProducto() {
        // Crear un nuevo producto
        Inventario producto = new Inventario();
        producto.setNombre("Proteína Whey");
        producto.setDescripcion("Suplemento para ganar masa muscular");
        producto.setPrecio(120.50);
        producto.setCantidad(50);

        // Guardar en la base de datos
        Inventario savedProducto = inventarioRepository.save(producto);

        // Verificar que se guardó correctamente
        assertThat(savedProducto.getIdInventario()).isNotNull();
        assertThat(savedProducto.getNombre()).isEqualTo("Proteína Whey");
        assertThat(savedProducto.getDescripcion()).isEqualTo("Suplemento para ganar masa muscular");
        assertThat(savedProducto.getPrecio()).isEqualTo(120.50);
        assertThat(savedProducto.getCantidad()).isEqualTo(50);

        // Mensaje en consola
        log.info("Producto creado SIN ERROR");
    }


	  @Test
    public void testGenerarVenta() {
        // Crear socio de prueba
        Socio socio = new Socio();
        socio.setNombre("Sergio Tafur");
        socio.setEmail("sergio@example.com");
        socio.setPassword("1234");
        Socio savedSocio = socioRepository.save(socio);

        // Crear producto de prueba
        Inventario producto = new Inventario();
        producto.setNombre("Proteína Whey");
        producto.setDescripcion("Suplemento para ganar masa muscular");
        producto.setPrecio(120.50);
        producto.setCantidad(50);
        Inventario savedProducto = inventarioRepository.save(producto);

        // Crear venta
        Venta venta = new Venta();
        venta.setSocio(savedSocio);
        venta.setMontoTotal(2 * savedProducto.getPrecio());

        // Guardar venta
        Venta savedVenta = ventaRepository.save(venta);

        // Verificar que la venta se creó correctamente
        assertThat(savedVenta.getIdVenta()).isNotNull();
        assertThat(savedVenta.getSocio().getNombre()).isEqualTo("Sergio Tafur");
        assertThat(savedVenta.getMontoTotal()).isEqualTo(241.0);

        log.info("Venta generada SIN ERROR");
    }
	
}


