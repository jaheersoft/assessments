package com.movie.cinema.documents;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "cinemas")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cinema {

	private String id;
	private String name;
	private String address;
	private String city;
	private String country;
	
	@DocumentReference
	@Builder.Default
	@JsonBackReference
	private List<Screen> screens = new ArrayList<>();
}
