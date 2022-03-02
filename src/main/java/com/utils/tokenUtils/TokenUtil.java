package com.utils.tokenUtils;

import org.springframework.security.core.context.SecurityContextHolder;


public interface TokenUtil {

		public default long getUserId() {
			Object principal =SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				long id=0;
				return id;
		}
	
}
