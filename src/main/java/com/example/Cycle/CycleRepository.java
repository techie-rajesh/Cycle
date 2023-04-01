
package com.example.Cycle;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CycleRepository extends JpaRepository<Cycle, Integer>
{
	@Query(value="select * from cycle_details where c_model like ?",nativeQuery = true)
	List<Cycle> GetByName(String n);
	@Query(value="select * from cycle_details where c_model like ? and c_color like ?",nativeQuery = true)
	List<Cycle> getByTwo(String a, String b);
}

