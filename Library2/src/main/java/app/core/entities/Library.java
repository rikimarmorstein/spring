package app.core.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "books")
@EqualsAndHashCode(of = "name")
@Entity
@Builder
public class Library {

	@Id
	private String name;
	private String adress;
	@OneToMany(mappedBy = "library", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Book> books;

	public void addBook(Book book) {
		if (books == null) {
			this.books = new ArrayList<>();
		}
		book.setLibrary(this);
		this.books.add(book);
	}

}
