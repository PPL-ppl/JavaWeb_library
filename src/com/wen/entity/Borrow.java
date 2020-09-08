package com.wen.entity;

public class Borrow {
    private Integer id;
    private Book book;
    private Reader reader;
    private String borrowtime;
    private String returntime;
    private Integer state;

    public Borrow() {
    }

    public Borrow(Integer id, Book book, Reader reader, String borrowtime, String returntime, Integer state) {
        this.id = id;
        this.book = book;
        this.reader = reader;
        this.borrowtime = borrowtime;
        this.returntime = returntime;
        this.state = state;
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
     * @return book
     */
    public Book getBook() {
        return book;
    }

    /**
     * 设置
     *
     * @param book
     */
    public void setBook(Book book) {
        this.book = book;
    }

    /**
     * 获取
     *
     * @return reader
     */
    public Reader getReader() {
        return reader;
    }

    /**
     * 设置
     *
     * @param reader
     */
    public void setReader(Reader reader) {
        this.reader = reader;
    }

    /**
     * 获取
     *
     * @return borrowtime
     */
    public String getBorrowtime() {
        return borrowtime;
    }

    /**
     * 设置
     *
     * @param borrowtime
     */
    public void setBorrowtime(String borrowtime) {
        this.borrowtime = borrowtime;
    }

    /**
     * 获取
     *
     * @return returntime
     */
    public String getReturntime() {
        return returntime;
    }

    /**
     * 设置
     *
     * @param returntime
     */
    public void setReturntime(String returntime) {
        this.returntime = returntime;
    }

    /**
     * 获取
     *
     * @return state
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置
     *
     * @param state
     */
    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Borrow{id = " + id + ", book = " + book + ", reader = " + reader + ", borrowtime = " + borrowtime + ", returntime = " + returntime + ", state = " + state + "}";
    }
}
