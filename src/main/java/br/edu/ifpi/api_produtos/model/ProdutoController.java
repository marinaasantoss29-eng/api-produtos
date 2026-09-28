package br.edu.ifpi.api_produtos.model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final List<Produto> produtos = new ArrayList<>();

    public ProdutoController() {
        produtos.add(new Produto(1L, "Teclado", 120.00));
        produtos.add(new Produto(2L, "Mouse", 80.00));
        produtos.add(new Produto(3L, "Monitor", 900.00));
    }
    @GetMapping
    public List<Produto> listar() {
        return produtos;
    }
    
    @GetMapping("/{id}")
    public Produto buscarProduto(@PathVariable Long id){
        return produtos.get(id.intValue() - 1);
    }
    
}
