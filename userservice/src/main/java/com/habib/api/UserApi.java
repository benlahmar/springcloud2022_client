/**
 * 
 */
package com.habib.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.habib.entities.Compte;
import com.habib.entities.Role;
import com.habib.repositories.ICompte;
import com.habib.repositories.IProfile;
import com.habib.repositories.IRole;

/**
 * @author moi
 *
 */
@RestController
@RefreshScope
public class UserApi {

	@Autowired
	IRole rrepo;
	@Autowired
	IProfile rprofile;
	@Autowired
	ICompte rcompte;
	
	@PostMapping("/comptes")
	public ResponseEntity<Compte> addc(@RequestBody Compte c)
	{
		c=rcompte.save(c);
		return new ResponseEntity<Compte>(c,HttpStatus.CREATED);
	}
	
	@GetMapping("/comptes/{id}")
	public ResponseEntity<Compte> findc(@PathVariable long id)
	{
		Optional<Compte> oc = rcompte.findById(id);
		if(oc.isPresent())
		return new ResponseEntity<Compte>(oc.get(),HttpStatus.OK);
		else
			return new ResponseEntity<Compte>(HttpStatus.NO_CONTENT);
		
	}
	
	@PostMapping("/roles")
	public ResponseEntity<Role> addr(@RequestBody Role c)
	{
		c=rrepo.save(c);
		return new ResponseEntity<Role>(c,HttpStatus.CREATED);
	}
	@GetMapping("/roles")
	public List<Role> allrole()
	{
		return rrepo.findAll();
	}
	
	@PostMapping("comptes/roles/{idc}/{idr}")
	public Compte addrole2compte(@PathVariable long idc,@PathVariable long idr)
	{
		Role r = rrepo.findById(idr).get();
		Compte c = rcompte.findById(idc).get();
		//c.getRoles().add(r);
		r.getComptes().add(c);
		//c=rcompte.save(c);
		rrepo.save(r);
		return c;
	}
	
	@Value("${narsa.version}")
	String value;
	
	
	@GetMapping("/value")
	public String getparam()
	{
		return value;
	}
}
