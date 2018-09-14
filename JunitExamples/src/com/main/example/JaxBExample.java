package com.main.example;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JaxBExample {

	public void marsheller() {
		List<TestData> dataList = new ArrayList<>();
		dataList = new RandomStrings().getGeneratedData();
		clearproperyFile();
		for (TestData data : dataList) {
			Domain domain = new Domain(data.getName(), data.getAge());
			try (BufferedWriter bw = new BufferedWriter(
					new FileWriter("src\\data\\" + "domain_" + data.getName() + ".xml"))) {
				JAXBContext context = JAXBContext.newInstance(Domain.class);
				Marshaller ms = context.createMarshaller();
				ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				ms.marshal(domain, System.out);
				ms.marshal(domain, bw);
				createProperyFile(data.getName());
			} catch (IOException | JAXBException e) {
				System.out.println("" + e.getMessage());
			}
		}

	}

	private void clearproperyFile() {
		try(BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(new File("src\\data\\testdataConfig.properties")))){
			Properties prop =  new Properties();
			prop.store(bo, null);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
			}
		
	}

	private void createProperyFile(String name) {
		try(BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(new File("src\\data\\testdataConfig.properties"),true))){
		Properties prop =  new Properties();
		prop.setProperty("data."+name, "domain_" + name + ".xml");
		prop.store(bo, null);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
		}
	}
	
	public void readXMLProperty() {
		try(BufferedInputStream bi = new BufferedInputStream(new FileInputStream(new File("src\\data\\testdataConfig.properties")))) {
			Properties prop = new Properties();
			prop.load(bi);
			Enumeration enuKeys = prop.keys();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value = prop.getProperty(key);
				System.out.println(key + ": " + value);
				unMarsheller(value);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public void unMarsheller(String value) {
		try (BufferedReader br = new BufferedReader(new FileReader("src\\data\\"+value))) {
			JAXBContext context = JAXBContext.newInstance(Domain.class);
			Unmarshaller ms = context.createUnmarshaller();
			Domain domain = (Domain) ms.unmarshal(br);
			System.out.println("Age" + domain.getAge());
			System.out.println("Name" + domain.getName());

		} catch (IOException | JAXBException e) {
			System.out.println("" + e.getMessage());
		}
	}

}
