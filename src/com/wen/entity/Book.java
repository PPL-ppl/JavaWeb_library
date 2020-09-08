package com.wen.entity;

public class Book {
    private Integer id;
    private String name;
    private String author;
    private String publish;
    private Integer pages;
    private Double price;
    private BookCase bookcase;

    public Book() {
    }

    public Book(String name, String author, String publish) {
        this.name = name;
        this.author = author;
        this.publish = publish;
    }

    public Book(Integer id, String name, String author, String publish, Integer pages, Double price, BookCase bookcase) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publish = publish;
        this.pages = pages;
        this.price = price;
        this.bookcase = bookcase;
    }

    /**
     * 获取
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     *
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置
     *
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取
     *
     * @return publish
     */
    public String getPublish() {
        return publish;
    }

    /**
     * 设置
     *
     * @param publish
     */
    public void setPublish(String publish) {
        this.publish = publish;
    }

    /**
     * 获取
     *
     * @return pages
     */
    public Integer getPages() {
        return pages;
    }

    /**
     * 设置
     *
     * @param pages
     */
    public void setPages(Integer pages) {
        this.pages = pages;
    }

    /**
     * 获取
     *
     * @return price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置
     *
     * @param price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 获取
     *
     * @return bookcase
     */
    public BookCase getBookcase() {
        return bookcase;
    }

    /**
     * 设置
     *
     * @param bookcase
     */
    public void setBookcase(BookCase bookcase) {
        this.bookcase = bookcase;
    }

    @Override
    public String toString() {
        return "Book{id = " + id + ", name = " + name + ", author = " + author + ", publish = " + publish + ", pages = " + pages + ", price = " + price + ", bookcase = " + bookcase + "}";
    }
}
