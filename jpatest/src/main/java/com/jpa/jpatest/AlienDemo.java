package com.jpa.jpatest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jpa.jpatest.model.Alien;;
@RepositoryRestResource(collectionResourceRel="aliens",path="aliens")
public interface AlienDemo extends JpaRepository<Alien,Integer> {

}
