package com.Teach3035.crud.dto.req;

import com.Teach3035.crud.model.BookModel;

public record BookDTOReq(String title, Integer publicationYear) {

    public BookModel dtoToModel () {
        return new BookModel(this.title, this.publicationYear );
    }

    public BookModel dtoToModel (long id) {
        return new BookModel(id, this.title, this.publicationYear );
    }

}
