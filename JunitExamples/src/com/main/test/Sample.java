package com.main.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.main.example.Calculater;
import com.main.example.Domain;
import com.main.example.Testable;

@RunWith(Parameterized.class)
public class Sample {

	private Domain domain;
	private Testable testable;
	private String expected;

	@Before
	public void init() {
		testable = new Testable();
	}

	public Sample(Domain domain) {
		this.domain = domain;
	}

	@Parameterized.Parameters
	public static Collection Adding() {
		Collection<Object[]> d = new ArrayList<>();
		//return Arrays.asList(new Object[][] { { new Domain("Arjun", "20"), "Arjun" }, { new Domain("Robert", "Arjund"), "Robert"} });
	//return Arrays.asList(new Object[][] {{getData(),"Arjun"}});//
		
		for(int i = 0 ;i <5 ;  i++) {
			Object[] obj = new Object[]{new Domain("Arjun" + i, "Age" + i)};
			d.add(obj);
		}
	return d;
	}
	
	
	@Test
	public void testAdd() {
		assertEquals(domain.getName(), testable.NameEquals(domain));
	}
}
