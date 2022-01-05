package com.thbs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.thbs.models.house;
//asdfgfredfcd
@Service
public interface houseServices  {

	java.util.List<house> getAllEmployees();
	void saveEmployee(house h);

	house getEmployeeById(int pid);

	void deleteEmployeeById(int pid);
	
	Page<house> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	Optional<house> getAEmployee(int pid);
	
	/*
	 * @Query("Select * from housedetails where pid=") public List<house>
	 * search(String keyword);
	 */

}
