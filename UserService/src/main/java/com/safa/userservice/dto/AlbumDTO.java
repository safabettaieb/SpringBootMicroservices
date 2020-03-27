package com.safa.userservice.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDTO {

	@Size(min = 3, max = 30,message = "name should have [3..30] chars")
	private String name;

	private String description;

    @NotNull(message = "user id is required")
	private Long userId;

}
