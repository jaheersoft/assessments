package com.movie.cinema.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScreenDTO {

	//private String id;
	
	private String name;
	
	private List<SeatDTO> seats;
	
	//private List<ShowDTO> shows;
}
