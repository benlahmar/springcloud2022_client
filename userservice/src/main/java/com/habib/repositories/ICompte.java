/**
 * 
 */
package com.habib.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.habib.entities.Compte;

/**
 * @author moi
 *
 */
@RepositoryRestResource(collectionResourceRel = "acounts", itemResourceRel = "acount")
public interface ICompte extends JpaRepository<Compte, Long>{

	Compte findByUsernameAndPassword(String log,String pass);
}
