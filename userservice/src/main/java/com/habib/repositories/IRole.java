package com.habib.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.habib.entities.Role;

public interface IRole extends JpaRepository<Role, Long>{

}
