package app.core.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "title")
@ToString(exclude = "library")
@Entity
@Builder
@Setter
//@RequiredArgsConstructor
public class Book {

	@Id
	private String title;
	private String author;
	@ManyToOne
	@JoinColumn(name = "library_name")
	@JsonIgnore
	private Library library;

}
