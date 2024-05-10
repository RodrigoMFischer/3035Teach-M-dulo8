package com.Teach3035.crud.controller;

import com.Teach3035.crud.dto.req.BookDTOReq;
import com.Teach3035.crud.dto.req.BookPatchTitleDTOReq;
import com.Teach3035.crud.dto.res.BookDTORes;
import com.Teach3035.crud.model.BookModel;
import com.Teach3035.crud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDTORes>> findAllBooks() {
        System.out.println("Entrando em FindAllBooks Controller");
        List<BookDTORes> list = this.bookService.findAllBooks();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTORes> findById (@PathVariable("id") long id) {
        BookDTORes bookModel = this.bookService.findById(id);

       return ResponseEntity.ok(bookModel);
    }

    @PostMapping
    public ResponseEntity<BookDTORes> create(@RequestBody BookDTOReq bookDTOReq, UriComponentsBuilder uriBuilder) {
        BookDTORes newBook = this.bookService.create(bookDTOReq);
        URI uri = uriBuilder.path("/books/{id}").buildAndExpand(newBook.id()).toUri();

       return ResponseEntity.created(uri).body(newBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTORes> update(@PathVariable("id") Long id, @RequestBody BookDTOReq bookDTOReq){
        BookDTORes bookUpdate = this.bookService.update(id, bookDTOReq);

        return ResponseEntity.ok(bookUpdate);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BookDTORes> updateTitle(@PathVariable("id") Long id, @RequestBody BookPatchTitleDTOReq bookPatchTitleDTOReq) {
        BookDTORes bookModel = this.bookService.updateTitle(id, bookPatchTitleDTOReq);

        return ResponseEntity.ok(bookModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        this.bookService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
