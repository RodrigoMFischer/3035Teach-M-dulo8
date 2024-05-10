package com.Teach3035.crud.dto.res;

import com.Teach3035.crud.model.BookModel;

public record BookDTORes(Long id, String title, Integer publicationYear) {

    public static BookDTORes modelToDTO(BookModel bookModel){
       return new BookDTORes(bookModel.getId(), bookModel.getTitle(), bookModel.getPublicationYear());
    }

}
