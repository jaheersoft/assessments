package com.movie.catalog.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CastDTO {
	private String id;
	private String name;
	private String role;
}
