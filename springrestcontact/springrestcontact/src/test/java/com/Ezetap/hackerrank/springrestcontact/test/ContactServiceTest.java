
package com.Ezetap.hackerrank.springrestcontact.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.Ezetap.hackerrank.springrestcontact.entity.Contact;



public class ContactServiceTest extends AbstractTest {
   @Override
   @Before
   public void setUp() {
      super.setUp();
   }
   @Test
   public void getContactList() throws Exception {
      String uri = "/add";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals("created", status);
      String content = mvcResult.getResponse().getContentAsString();
      
   }
   @Test
   public void createProduct() throws Exception {
      String uri = "/add";
      Contact contact = new Contact();
      //
      contact.setName("ankit");
      contact.setEmailAddress("ankit.kansal@email.com");
      String inputJson = super.mapToJson(contact);
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
         .contentType(MediaType.APPLICATION_JSON_VALUE)
         .content(inputJson)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(201, status);
      String content = mvcResult.getResponse().getContentAsString();
      assertEquals(content, "contact added successfully");
   }
   @Test
   public void updateProduct() throws Exception {
      String uri = "/search/ankit";
      Contact contact = new Contact();
      contact.setName("ankit");
      contact.setEmailAddress("ankit.kansal@email.com");
      String inputJson = super.mapToJson(contact);
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
         .contentType(MediaType.APPLICATION_JSON_VALUE)
         .content(inputJson)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      assertEquals(content, "contact updated successfully");
   }
   @Test
   public void deleteProduct() throws Exception {
      String uri = "/delete/ankit";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      assertEquals(content, "Contact Deleted");
   }
}