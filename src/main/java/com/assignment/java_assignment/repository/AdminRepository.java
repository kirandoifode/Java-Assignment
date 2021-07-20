
package com.assignment.java_assignment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.java_assignment.model.Post;

@Repository
public interface AdminRepository extends CrudRepository<Post, Long> {

}
