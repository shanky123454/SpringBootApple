package in.com.model;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books extends RepresentationModel<Books>{

	public String bookId;
	public String bookName;
	public String bookAuthor;
	public Float price;
}
