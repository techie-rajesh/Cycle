package com.example.Cycle;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CycleApplicationCRUD_Test {
	@Autowired
	CycleService cycleSer;
	@MockBean
	CycleRepository cycleRep;

	@Test
	public void getAllTest() {
		
		when(cycleRep.findAll()).thenReturn(Stream.of(new Cycle(1, "hero", "blue", 2500),new Cycle(2, "honda", "red", 4500))
				.collect(Collectors.toList()));
		assertEquals(2, cycleSer.get().size());
		
		verify(cycleRep,times(1)).findAll();	
	}
	@Test
	public void getByIdTest() {
		Cycle cy=new Cycle(2, "honda", "red", 4500);
		when(cycleRep.findById(1)).thenReturn(Optional.of(cy));
		
		Cycle result=cycleSer.getById(1);
		assertThat(result).isNotNull();
		assertThat(result.getColor()).isEqualTo("red");
		//assertEquals(Optional.of(cy),cycleSer.getById(2));
		//verify(cycleRep,times(1)).findById(2);
	}
	@Test
	
	public void StoreTest() {
		List<Cycle> cl1=new ArrayList<>();
		cl1.add(new Cycle(4,"honda","green",4500));
		cl1.add(new Cycle(5,"hero","white",2800));
		when(cycleRep.saveAll(cl1)).thenReturn(cl1);
		
		String result= cycleSer.add(cl1);
		assertThat(result).isNotNull();
	
		//assertEquals(cl1, cycleSer.add(cl1));
		//verify(cycleRep,times(1)).save(cl1);
	}
	@Test
	public void removeTest() {
		when(cycleRep.findAll()).thenReturn(Stream.of(new Cycle(1, "hero", "blue", 2500),new Cycle(2, "honda", "red", 4500))
				.collect(Collectors.toList()));
	//	assertEquals(2, cycleSer.remove());
		//verify(cycleRep,times(1)).deleteAll();
	}
	//@Test
	public void updateTest() {
		 Cycle cl=cycleRep.findById(4).get();
		Cycle updateCyc=new Cycle(4,"herculas","orange",9500);
		cycleSer.edit(updateCyc, 4);
		cl.setId(updateCyc.getId());
		cl.setColor(updateCyc.getColor());
		cl.setModel(updateCyc.getModel());
		cl.setPrice(updateCyc.getPrice());
		when(cycleRep.save(cl)).thenReturn(cl);

	}
}
