package com.movie.cinema.documents;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "screens")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Screen {

	private String id;
	private String name;
	
	@DocumentReference
	@Builder.Default
	@JsonBackReference
	private List<Seat> seats = new ArrayList<>();
	
	@DocumentReference(lazy = true)
    @ReadOnlyProperty
    @JsonManagedReference
	private Cinema cinema;
}
