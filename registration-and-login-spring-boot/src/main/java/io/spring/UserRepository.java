package io.spring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT u FROM User u WHERE u.email = ?1")
	// In HQL, use the java class name and property name of the mapped @Entity instead of the actual table name and column name
	User findByEmail(String email);

}
