package com.jpa.jpatest.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="cdfBase",path="cdfBase")
public interface opsbridge_storeDemo extends JpaRepository<cdfBase,String> {


}
