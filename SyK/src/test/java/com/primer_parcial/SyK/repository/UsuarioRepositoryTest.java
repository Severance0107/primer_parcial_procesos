package com.primer_parcial.SyK.repository;

import static org.assertj.core.api.Assertions.assertThat;
import com.primer_parcial.SyK.models.Usuario;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    void testGuardarUsuario(){

        //Given - Dado o condición previa o configuracion
        Usuario usuario1 = Usuario.builder()
                .correo("kevingay@fchat.com")
                .password("123")
                .build();

        //When - accion o el comportamiento que vamos a probar
        Usuario usuarioGuardado = usuarioRepository.save(usuario1);

        //then - Verificar la salida
        assertThat(usuarioGuardado).isNotNull();
        assertThat(usuarioGuardado.getId()).isGreaterThan(0);

    }
}
