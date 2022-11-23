package com.primer_parcial.SyK.controllers;

import com.primer_parcial.SyK.models.Articulo;
import com.primer_parcial.SyK.models.Categoria;
import com.primer_parcial.SyK.services.CategoriaService;
import com.primer_parcial.SyK.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/categoria")
    public ResponseEntity crearCategoria(@RequestBody Categoria categoria, @RequestHeader(value = "Authorization") String token){
        if (jwtUtil.getKey(token)==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token no valido");
        }
        return categoriaService.createCategoria(categoria);

    }
    @PutMapping("/categoria/{id}")
    public ResponseEntity editarCategoria(@PathVariable Long id ,@RequestBody Categoria categoria, @RequestHeader(value = "Authorization") String token){
        if (jwtUtil.getKey(token)==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token no valido");
        }
        return categoriaService.editCategoria(id,categoria);

    }
    @DeleteMapping("categoria/{id}")
    public ResponseEntity eliminarCategoria(@PathVariable Long id, @RequestHeader(value = "Authorization") String token){
        if (jwtUtil.getKey(token)==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token no valido");
        }
        return categoriaService.deleteCategoria(id);

    }
}
