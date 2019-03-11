package com.Ezetap.hackerrank.springrestcontact.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.Ezetap.hackerrank.springrestcontact.entity.Contact;

public interface ContactRepository extends PagingAndSortingRepository<Contact, Long>{

	public Contact findByName(String Name);
	public Contact findByEmailAddress(String emailAddress);
	
}
