package com.example.Cycle;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Primary
//@Service
@Component
public class DealerEmail implements Email {
	
	@Override
	public String emailId() {
		return "dealersensey_cycle@gmail.com";
	}

}
