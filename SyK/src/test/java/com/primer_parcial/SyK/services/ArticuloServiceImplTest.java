package com.primer_parcial.SyK.services;

import com.primer_parcial.SyK.data.FactoryArticuloTestData;
import com.primer_parcial.SyK.models.Articulo;
import com.primer_parcial.SyK.repository.ArticuloRepository;
import com.primer_parcial.SyK.repository.CategoriaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class ArticuloServiceImplTest {

    @InjectMocks
    private ArticuloServiceImpl articuloService;

    @Mock
    private ArticuloRepository articuloRepository;

    @Mock
    private CategoriaRepository categoriaRepository;

    @DisplayName("Test para obtener articulos por codigo")
    @Test
    void GetArticleByCodTest() {

        //Given
        Articulo articulo = FactoryArticuloTestData.mockArticulo();

        //When
        when(articuloRepository.findByCodigo(anyString())).thenReturn(Optional.of(articulo));
        ResponseEntity<Articulo> respuesta = articuloService.getArticleByCod(articulo.getCodigo());

        //Then
        Assertions.assertNotNull(respuesta);

    }

    @DisplayName("Test para listar a los Articulos")
    @Test
    void getAllArticlesTest() {

        //Given
        Articulo articulo = FactoryArticuloTestData.mockArticulo();

        //When

        ResponseEntity<List<Articulo>> lista = articuloService.getAllArticles();

        //Then
        Assertions.assertNotNull(lista);
    }

    @DisplayName("Test para crear a los Articulos")
    @Test
    void createArticleTest() {
        //Given
        Articulo articulo = FactoryArticuloTestData.mockArticulo();
        given(articuloRepository.findByCodigo(articulo.getCodigo())).willReturn(Optional.of(articulo));
        given(articuloRepository.save(articulo)).willReturn(articulo);
        //When

        ResponseEntity<Articulo> articuloGuardado = articuloService.createArticle(articulo);

        //Then
        Assertions.assertNotNull(articuloGuardado);
    }

    @Test
    void editArticleTest() {
        //Given
        //When
        //Then
    }

    @Test
    void deleteArticleTest() {
        //Given
        //When
        //Then
    }
}