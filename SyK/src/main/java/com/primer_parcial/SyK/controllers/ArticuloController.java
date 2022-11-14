package com.primer_parcial.SyK.controllers;


import com.primer_parcial.SyK.models.Articulo;
import com.primer_parcial.SyK.models.Categoria;
import com.primer_parcial.SyK.repository.ArticuloRepository;
import com.primer_parcial.SyK.repository.CategoriaRepository;
import com.primer_parcial.SyK.services.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;

    @Autowired
    private ArticuloRepository articuloRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    //----------------------------------------------Crear un articulo---------------------------------------------------
    @PostMapping("/articulo")
    public ResponseEntity crearArticulo(@RequestBody Articulo articulo){
        
        return articuloService.createArticle(articulo);
    }

    //--------------------------------------------Modificar un articulo-------------------------------------------------
    @PutMapping("/articulo/{codigo}")
    public ResponseEntity editarArticulo(@PathVariable String codigo, @RequestBody Articulo articulo ){

        return articuloService.editArticle(codigo, articulo);

    }

    //------------------------------------------Eliminar un articulo----------------------------------------------------

    @DeleteMapping("articulo/{codigo}")
    public ResponseEntity eliminarArticulo(@PathVariable String codigo){

        return articuloService.deleteArticle(codigo);

    }




    //--------------------------------------------Listar Articulo por codigo--------------------------------------------
    @GetMapping(value = "/articulo/codigo/{codigo}")
    public ResponseEntity getArticulo(@PathVariable String codigo) {

        return articuloService.getArticleByCod(codigo);

    }


    //----------------------------------------------Listar todos los articulos------------------------------------------

    @GetMapping("/articulos")
    public ResponseEntity listarArticulo(){

        return articuloService.getAllArticles();

    }


}

