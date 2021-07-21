
package com.assignment.java_assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.java_assignment.model.Post;

@Repository
public interface AdminRepository extends CrudRepository<Post, Long> {
	@Query("SELECT p FROM Post p WHERE p.userId = ?1")
	List<Post> findByUserId(long userId);
	
	@Query("SELECT p FROM Post p WHERE p.audited = ?1")
	List<Post> findAllAuditedPosts(boolean audited);
}
