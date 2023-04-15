package app.core.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
@EqualsAndHashCode(of = "id")
@ToString(exclude = { "library", "readers" })
@Entity
@Builder
//@RequiredArgsConstructor
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String author;
	@ManyToOne
	@JoinColumn(name = "library_name")
	@JsonIgnore
	private Library library;
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "reader_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "reader_id"))
	private List<Reader> readers;

	public void addReader(Reader reader) {
		if (readers == null) {
			this.readers = new ArrayList<>();
		}
		readers.add(reader);

	}

}
