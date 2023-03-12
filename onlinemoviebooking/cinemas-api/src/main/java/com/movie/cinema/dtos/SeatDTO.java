package com.movie.cinema.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeatDTO {

	//private int id;
	
	private String row;
	
	private int number;
	
	private String type;
}
