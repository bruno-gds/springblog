package com.fiap.springblog.controller;

import com.fiap.springblog.model.Artigo;
import com.fiap.springblog.model.ArtigoStatusCount;
import com.fiap.springblog.model.AutorTotalArtigo;
import com.fiap.springblog.service.ArtigoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 10/10/2023
 * Project Name: springblog
 */

@RestController
@RequestMapping("/artigos")
public class ArtigoController {

    @Autowired
    private ArtigoService artigoService;


    @ExceptionHandler(OptimisticLockingFailureException.class)
    public ResponseEntity<String> handleOptimisticLockingFailureException(OptimisticLockingFailureException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("Erro de concorrência: O Artigo foi atualizado por outro usuário. Por favor, tente novamente!");
    }

    @GetMapping
    public List<Artigo> obterTodos(){
        return this.artigoService.obterTodos();
    }

    @GetMapping("/{codigo}")
    public Artigo obterPorCodigo(@PathVariable String codigo){
        return this.artigoService.obterPorCodigo(codigo);
    }

//    @PostMapping
//    public Artigo criar(@RequestBody Artigo artigo){
//        return this.artigoService.criar(artigo);
//    }

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody Artigo artigo){
        return this.artigoService.criar(artigo);
    }

    @PutMapping("/atualiza-artigo/{id}")
    public ResponseEntity<?> atualizarArtigo(
            @PathVariable("id") String id,
            @Valid @RequestBody Artigo artigo){
        return this.artigoService.atualizarArtigo(id, artigo);
    }

    @GetMapping("/maiordata")
    public List<Artigo> findByDataGreaterThan(@RequestParam("data") LocalDateTime data){
        return this.artigoService.findByDataGreaterThan(data);
    }

    @GetMapping("/data-status")
    public List<Artigo> findByDataAndStatus(
            @RequestParam("data") LocalDateTime data,
            @RequestParam("status") Integer status){
        return this.artigoService.findByDataAndStatus(data, status);
    }

    @PutMapping
    public void atualizar(@RequestBody Artigo artigo){
        this.artigoService.atualizar(artigo);
    }

    @PutMapping("/{id}")
    public void atualizarArtigo(
            @PathVariable String id,
            @RequestBody String novaUrl){
        this.artigoService.atualizarArtigo(id, novaUrl);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id){
        this.artigoService.deleteById(id);
    }

    @DeleteMapping("/delete")
    public void deleteArtigoById(@RequestParam("Id") String id){
        this.artigoService.deleteArtigoById(id);
    }

    @GetMapping("/status-maiordata")
    public List<Artigo> findByStatusAndDataGreaterThan(
            @RequestParam("status") Integer status,
            @RequestParam("data") LocalDateTime data){
        return this.artigoService.findByStatusAndDataGreaterThan(status, data);
    }

    @GetMapping("/periodo")
    public List<Artigo> obterArtigoPorDataHora(
            @RequestParam("de") LocalDateTime de,
            @RequestParam("ate") LocalDateTime ate){
        return this.artigoService.obterArtigoPorDataHora(de, ate);
    }

    @GetMapping("/artigo-complexo")
    public List<Artigo> encontrarArtigosComplexos(
            @RequestParam(name = "status", required = false) Integer status,
            @RequestParam("data") LocalDateTime data,
            @RequestParam(name = "titulo", required = false) String titulo){
        return this.artigoService.encontrarArtigosComplexos(status, data, titulo);
    }

    @GetMapping("/pagina-artigos")
    public ResponseEntity<Page<Artigo>> listaArtigos(Pageable pageable){
        Page<Artigo> artigos = this.artigoService.listaArtigos(pageable);

        return ResponseEntity.ok(artigos);
    }

    @GetMapping("/status-ordenado")
    public List<Artigo> findByStatusOrderByTituloAsc(@RequestParam("status") Integer status){
        return this.artigoService.findByStatusOrderByTituloAsc(status);
    }

    @GetMapping("/status-query-ordenacao")
    public List<Artigo> obterArtigoPorStatusComOrdenacao(@RequestParam("status") Integer status){
        return this.artigoService.obterArtigoPorStatusComOrdenacao(status);
    }

    @GetMapping("/buscatexto")
    public List<Artigo> findByTexto(@RequestParam("searchTerm") String searchTerm){
        return this.artigoService.findByTexto(searchTerm);
    }

    @GetMapping("/contar-artigo")
    public List<ArtigoStatusCount> contarArtigosPorStatus(){
        return this.artigoService.contarArtigosPorStatus();
    }

    @GetMapping("/total-artigo-autor-periodo")
    public List<AutorTotalArtigo> calcularTotalArtigosPorAutorNoPeriodo(
            @RequestParam("dataInicio") LocalDate dataInicio,
            @RequestParam("dataFim") LocalDate dataFim){
        return this.artigoService.calcularTotalArtigosPorAutorNoPeriodo(dataInicio, dataFim);
    }
}
