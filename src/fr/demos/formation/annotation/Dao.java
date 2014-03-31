package fr.demos.formation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;


@Retention(RetentionPolicy.RUNTIME) //jusqu'a quand restera ds le code, RUNTIME pour dire qu'on a besoin en moment de execution ausi
@Target({ElementType.FIELD, ElementType.TYPE}) //ElementType.TYPE, ElementType.METHOD,  sue quoi on veut la mettre ?
@Qualifier   //injection
public @interface Dao {
	

}
