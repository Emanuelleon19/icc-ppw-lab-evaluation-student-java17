package ec.edu.ups.icc.libraryevaluation.books.entities;

import java.math.BigDecimal;
import ec.edu.ups.icc.libraryevaluation.core.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class BookEntity extends BaseEntity {
  @Column(nullable = false, unique = true, length = 20)
  private String isbn;

  @Column(nullable = false, length = 160)
  private String title;

  @Column(nullable = false, length = 120)
  private String author;

  @Column(nullable = false, length = 80)
  private String category;

  @Column(name = "copies_available", nullable = false)
  private Integer copiesAvailable;

  @Column(nullable = false, precision = 10, scale = 2)
  private BigDecimal price;

  @Column(nullable = false)
  private boolean active = true;

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Integer getCopiesAvailable() {
    return copiesAvailable;
  }

  public void setCopiesAvailable(Integer copiesAvailable) {
    this.copiesAvailable = copiesAvailable;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }
}