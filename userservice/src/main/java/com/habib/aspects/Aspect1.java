/**
 * 
 */
package com.habib.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import com.habib.entities.Compte;

/**
 * @author moi
 *
 */
@Aspect
@Service
public class Aspect1 {

	@After("execution(* *.findc(..))")
	public void msg(JoinPoint jp)
	{
		
		System.out.println("appel de la méthode "+jp.getSignature().getName());
		System.out.println(jp.getKind());
		Class<Compte> cc = Compte.class;
		//cc.get
	}
	
	@AfterReturning(pointcut = "execution(* *.findc(..))",returning = "result")
	public void res(JoinPoint jp, Object result)
	{
		System.out.println(jp.getSignature().getName());
		System.out.println("******"+result.toString());
	}
}
