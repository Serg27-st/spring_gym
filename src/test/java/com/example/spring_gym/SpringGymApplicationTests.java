package com.example.spring_gym;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.spring_gym.model.Socio;
import com.example.spring_gym.repository.SocioRepository;

@SpringBootTest
class SpringGymApplicationTests {

    @Autowired
    private SocioRepository socioRepository;

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
        log.info("SIN ERROR");
    }
}


