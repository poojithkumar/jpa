package com.jpa.jpatest.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="suiteInfo",path="suiteInfo")
public interface suiteController extends JpaRepository<suiteInformations,String> {

}
