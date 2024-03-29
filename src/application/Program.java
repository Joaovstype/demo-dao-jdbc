package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ===");
		
		Seller seller = sellerDao.findById(2);
		
		System.out.println(seller);
		
		System.out.println("=== TEST : seller delete ===");
		
		System.out.println("Enter id for delete: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
	
		
		System.out.println("\n=== TEST 2: seller findByDepartment ===");
		
		System.out.println("Enter with the department Id: ");
		
		int departmentId = sc.nextInt();
		
		Department department = new Department(departmentId,null);
		
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: seller findAll ===");
		
		list = sellerDao.findAll();
		
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 4: seller insert ===");
		
		Seller newSeller = new Seller(null,"Greg", "Greg@gmail.com", new Date(), 4000.0, department);
		
		sellerDao.insert(newSeller);
		
		System.out.println("Inserted! New id = " + newSeller);
		
		System.out.println("\n=== TEST 5: seller update ===");
		
		seller = sellerDao.findById(1);
		
		seller.setName("MArtha Wayne");
		
		sellerDao.update(seller);
		
		System.out.println("Update complete");
		
		sc.close();
	}

	
}
