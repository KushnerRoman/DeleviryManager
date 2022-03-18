package com.utils.ApiResponseAnnotations;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Target(value=ElementType.METHOD)
@Retention(value=RetentionPolicy.RUNTIME)
@ApiResponses( value= {



		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 201, message = "Created"),
		@ApiResponse(code = 400, message = "Bad Request (wrong inputs)"),
		@ApiResponse(code = 401, message = "Unauthorized( Not Allowed !)"),
		@ApiResponse(code = 403, message = "Forbidden ( StoreManger only ! )"),
		@ApiResponse(code = 404, message = "Not Found 111111111111111111")

			})
public @interface DefaultApiResponses {

}
