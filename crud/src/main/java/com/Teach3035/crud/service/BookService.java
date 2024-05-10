package com.Teach3035.crud.service;

import com.Teach3035.crud.dto.req.BookDTOReq;
import com.Teach3035.crud.dto.req.BookPatchTitleDTOReq;
import com.Teach3035.crud.dto.res.BookDTORes;
import com.Teach3035.crud.model.BookModel;
import com.Teach3035.crud.repository.BookRepository;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;


    public List<BookDTORes> findAllBooks() {
        System.out.println("Entrando em FindAllBooks");
        List<BookModel> list = this.bookRepository.findAll();
        list.forEach(System.out::println);
        return list.stream().map(BookDTORes::modelToDTO).toList();
    }

    public BookDTORes findById(long id) {
        BookModel bookModel = this.findByIdEntity(id);

        System.out.println(bookModel);
        return BookDTORes.modelToDTO(bookModel);
    }

    public BookDTORes create(BookDTOReq bookDTOReq) {
        BookModel book = this.bookRepository.save(bookDTOReq.dtoToModel());
        System.out.println(book);
        return BookDTORes.modelToDTO(book);
    }

    public BookDTORes update(long id, BookDTOReq bookDTOReq) {
        BookModel bookModelRes = this.bookRepository.save(bookDTOReq.dtoToModel(id));
        System.out.println(bookModelRes);
        return BookDTORes.modelToDTO(bookModelRes);
    }

    public BookDTORes updateTitle(Long id, BookPatchTitleDTOReq bookPatchTitle) {

        BookModel bookModel = this.findByIdEntity(id);
        System.out.println(bookModel);
        bookModel.setTitle(bookPatchTitle.title());
        System.out.println(bookModel);
        BookModel bookModelRes = this.bookRepository.save(bookModel);
        System.out.println(bookModelRes);
        return BookDTORes.modelToDTO(bookModelRes);
    }

    public void delete(Long id) {
        BookModel bookModel = this.findByIdEntity(id);
        this.bookRepository.delete(bookModel);
    }

    private BookModel findByIdEntity(Long id) {
        try {
            return this.bookRepository.findById(id).orElseThrow(() -> new ClassNotFoundException("Livro não encontrado"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
