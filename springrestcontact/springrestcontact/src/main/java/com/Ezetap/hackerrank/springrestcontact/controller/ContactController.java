package com.Ezetap.hackerrank.springrestcontact.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Ezetap.hackerrank.springrestcontact.entity.Contact;
import com.Ezetap.hackerrank.springrestcontact.repository.ContactRepository;

@RestController
public class ContactController {
	
	@Autowired
	private ContactRepository contactrepository;
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> addContact(@RequestBody Contact contact) {
		//contact.setContactId(String.valueOf(nextContactSequenceService.getNextSequence("contact_sequence")));
		Contact savedContact=contactrepository.save(contact);
		return new ResponseEntity<>("contact added successfully", HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/search/{name}", method = RequestMethod.GET, consumes = "application/json")
	public ResponseEntity<?> search(@PathVariable("name") String name) {
		Contact contact= contactrepository.findByName(name);
		return new ResponseEntity<Object>(contact, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/search/{emailAddress}", method = RequestMethod.GET, consumes = "application/json")
	public ResponseEntity<?> searchEmail(@PathVariable("emailAddress") String emailAddress) {
		Contact contact= contactrepository.findByEmailAddress(emailAddress);
		return new ResponseEntity<Object>(contact, HttpStatus.OK);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<?> update(@RequestBody Contact contact) {
		contactrepository.save(contact);
		return new ResponseEntity<Object>("contact updated successfully", HttpStatus.OK);
    }
	@RequestMapping(value = "/{name}", method = RequestMethod.DELETE) 
    public ResponseEntity<?> delete(@PathVariable String name) {
		contactrepository.delete(contactrepository.findByName(name)); 
		return new ResponseEntity<Object>("Contact Deleted", HttpStatus.OK);
    }


}
