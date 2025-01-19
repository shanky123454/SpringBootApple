package in.com.bo;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Lob;

import org.springframework.data.annotation.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@javax.persistence.Table(name = "marriageSeeker")
public class MarriageSeeker implements Serializable {

	private static final long serialVersionUID = 1L;

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	
	@NonNull
	public String name;
	
	@NonNull
	public Integer age;
	
	@NonNull
	public String address;
	
	@NonNull
	@Lob
	public char[] biodata;
	
	@NonNull
	@Lob
	public byte[] photo;
	
	@NonNull
	public LocalDateTime dateTime;
	
	@NonNull
	public Boolean indian;

}
