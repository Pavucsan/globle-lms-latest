package com.pavucs.globelibraryservice.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class Book {

    //    @ApiModelProperty(example = "99")
    private long bookId;
    //    @ApiModelProperty(example = "BOOK X")
    private String bookName;
    //    @ApiModelProperty(example = "AUTHOR X")
    private String author;
    //    @ApiModelProperty(example = "10")
    private int copy;

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", copy='" + copy + '\'' +
                '}';
    }
}
