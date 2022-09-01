package com.habib.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.habib.entities.Profile;

public interface IProfile extends JpaRepository<Profile, Long>{

}
