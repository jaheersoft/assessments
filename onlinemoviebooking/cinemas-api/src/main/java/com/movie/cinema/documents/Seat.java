package com.movie.cinema.documents;

import javax.persistence.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "seats")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seat {

	private int id;
	private String row;
	private int number;
	private String type;
	
	@DocumentReference(lazy = true)
    @ReadOnlyProperty
    @JsonManagedReference
	private Screen screen;
}
