package com.tyagi.project.OnlineFoodOrder;

import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tyagi.project.OnlineFoodOrder.dao.SupplierDAO;
import com.tyagi.project.OnlineFoodOrder.model.Supplier;

import javax.naming.Context;

public class SupplierTestCase {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.tyagi.project.OnlineFoodOrder");
		context.refresh();

		SupplierDAO supplierDAO = (SupplierDAO) context.getBean("supplierDAO");

		/*Supplier supplier = new Supplier();

		supplier.setSuppname("Aman");
		supplier.setSuppaddress("Ghaziabad");

		supplierDAO.insertUpdateSupplier(supplier);
		System.out.println("Supplier Inserted");*/

		// Retrieval TestCase

		/*Supplier supplier = supplierDAO.getSupplier(1);
		System.out.println("Supplier Name:" + supplier.getSuppname());
		System.out.println("Supplier Description:" + supplier.getSuppaddress());*/
		 
		// Deletion TestCase

		Supplier supplier = supplierDAO.getSupplier(2);
		supplierDAO.deleteSupplier(supplier);
		System.out.println("The Supplier Deleted");
		 

				

	}

}
