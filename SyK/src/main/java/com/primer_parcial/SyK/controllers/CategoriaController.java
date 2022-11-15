package com.primer_parcial.SyK.controllers;

import com.primer_parcial.SyK.models.Articulo;
import com.primer_parcial.SyK.models.Categoria;
import com.primer_parcial.SyK.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/categoria")
    public ResponseEntity crearCategoria(@RequestBody Categoria categoria){
        return categoriaService.createCategoria(categoria);

    }
    @PutMapping("/categoria/{id}")
    public ResponseEntity editarCategoria(@PathVariable Long id ,@RequestBody Categoria categoria){

        return categoriaService.editCategoria(id,categoria);

    }
    @DeleteMapping("categoria/{id}")
    public ResponseEntity eliminarCategoria(@PathVariable Long id){

        return categoriaService.deleteCategoria(id);

    }
}
