package br.edu.ifpi.api_produtos.model;

import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/destaque")
    public List<Produto> listarDestaque() {
        return produtos.stream()
                .filter(p -> Boolean.TRUE.equals(p.getDestaque()))
                .toList();
    }

    @GetMapping("/{id}")
    public Produto buscarProduto(@PathVariable Long id){
        return produtos.get(id.intValue() - 1);
    }

    @GetMapping("{id}/descricao")
    public String buscarDescricao(@PathVariable Long id) {
        Produto produto = buscarProduto(id);
        return produto.getDescricao();
    }

    @PostMapping
    public Produto adicionarProduto(@RequestBody Produto produto) {
        produtos.add(produto);
        return produto;
    }
}

