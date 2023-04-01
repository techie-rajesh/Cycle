package com.example.Cycle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class CycleDao {
	@Autowired
	CycleRepository cr;

	public String add(List<Cycle> cy) {
		// TODO Auto-generated method stub
		cr.saveAll(cy);
		return "Stored";
	}

	public List<Cycle> get() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}

	public Cycle getById(int a) {
		// TODO Auto-generated method stub
	return 	cr.findById(a).get();
		
		
	}

	public List<Cycle> getByName(String n) {
		// TODO Auto-generated method stub
		return cr.GetByName(n);
	}

	public List<Cycle> getByTwo(String a, String b) {
		// TODO Auto-generated method stub
		return cr.getByTwo(a,b);
	}

	public String remove() {
		// TODO Auto-generated method stub
		cr.deleteAll();
		return "Deleted";
	}

	public String edit(Cycle cyc,int id) {
		// TODO Auto-generated method stub
		 Cycle cl=cr.findById(id).get();
		 Cycle y=cyc;
		 cl.setId(y.getId());
		 cl.setColor(y.getColor());
		 cl.setModel(y.getModel());
		 cl.setPrice(y.getPrice());
		 cr.save(cl);
		 return "updated";
	}

}
