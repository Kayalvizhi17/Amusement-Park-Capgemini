package com.amusementpark.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.when;
import com.amusementpark.demo.entity.Customer;
import com.amusementpark.demo.repository.CustomerRepository;
import com.amusementpark.demo.service.impl.CustomerServiceImpl;

@SpringBootTest
class AmusementparkApplicationTests {

	@MockBean
	private CustomerRepository customerrepository;
	@Autowired
	private CustomerServiceImpl csi;
	
	@Test
	void contextLoads() {
	}
	
//	// To test the getter of customer Id
	
	@Test
	void getCustomer_id()
	{
		Customer ob=new Customer((long) 4,"akash","tiwari","abs","9163","akas");
		
	ob.setCustomer_id((long)5);
		assertEquals((long)5, ob.getCustomer_id());
	}
	
	
	// To test the getter of username 
	@Test
	void getUsername()
	{
		Customer ob=new Customer((long) 4,"akash","tiwari","abs","9163","akas");
		
	ob.setUsername("aksh");
		assertEquals("aksh", ob.getUsername());
	}


	//To test Service method
	
	@Test
	void insertCustomer()
	{
		Customer ob=new Customer((long) 4,"akash","tiwari123","abs","9163223410","akas9163@gmail.com");
		
	when(customerrepository.save(ob)).thenReturn(ob);
		
		assertEquals(ob,csi.insertCustomer(ob));

	}

}
