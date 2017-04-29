/**
 * 
 */
package com.raj.spring.customerRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.raj.spring.model.Customer;

/**
 * @author admin
 *
 */
public interface CustomerRepository extends CrudRepository<Customer, Long>{

	List<Customer> findByEmail(String email);

    List<Customer> findByCreatedDate(Date date);

	// custom query example and return a stream
    @Query("select c from Customer c where c.email = :email")
    Stream<Customer> findByEmailReturnStream(@Param("email") String email);
}
