package com.example.Cycle;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Service
@Component
public class CarrierEmail implements Email{
	
	@Override
	public String emailId() {
		// TODO Auto-generated method stub
		return "carrier_cycle@gmail.com";
	}

}
