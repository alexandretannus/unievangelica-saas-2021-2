package br.edu.unievangelica.saas.oauthjwt.domain.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR') and hasAuthority('SCOPE_read')") 
    public List<Produto> listar() {
        return produtoService.listar();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_CADASTRAR') and hasAuthority('SCOPE_write')") 
    public ResponseEntity<Produto> criar(@RequestBody Produto produto) {
        Produto produtoSalvo = produtoService.salvar(produto);

        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
    }

}
