package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Department department = new Department(1, "Books");
		
		Seller newSeller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.0, department);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		sellerDao.insert(newSeller);
		
		System.out.println(newSeller.getId());
		
		//Seller seller = sellerDao.findById(3);
		
		//System.out.println(seller);
		
		//Department department = new Department(2, null);
		
		List<Seller> sellers = sellerDao.findAll();
		
		//for(Seller seller : sellers) {
		//	System.out.println(seller);
		//}
	
		
		for(Seller sellerItem : sellers) {
			System.out.println(sellerItem);
		}
		
		Seller seller = sellerDao.findById(1);
		seller.setName("Martha Wayne");
		sellerDao.update(seller);
		
		
		sellerDao.deleteById(1);

	}

}
