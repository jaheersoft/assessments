package com.movie.catalog.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LanguageDTO {

	private String id;
	private String name;
}
