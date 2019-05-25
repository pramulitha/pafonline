package com.springbootrestapi.controller;

import java.util.List;
import javax.validation.Valid;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootrestapi.dao.ProductDAO;
import com.springbootrestapi.model.Product;

@RestController
@RequestMapping("/company")
public class ProductController {
	
@Autowired

ProductDAO productDAO;


/*to save products */

@PostMapping("/Products")
public Product createProduct(@Valid @RequestBody Product prd)
{
	return productDAO.save(prd);
}


/*get all products */

@GetMapping("/Products")
public List <Product> getAllProducts(){
	return productDAO.findAll();
}

/*get Product by prdproductId */

@GetMapping("/notes/{productId}")
public ResponseEntity<Product> getProductByproductId(@PathVariable(value ="productId")Long prdproductId){

	
		Product prd = productDAO.findone(prdproductId);
		
		if(prd==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(prd);
		
		
}


/*update an Product by prdproductId
 
 */


@PutMapping("/Products/{productId}")
public ResponseEntity<Product> updateProduct(@PathVariable(value ="productId") Long prdproductId,@Valid @RequestBody Product prdDetails){


	Product prd = productDAO.findone(prdproductId);
	
	if(prd==null) {
		return ResponseEntity.notFound().build();
	}
	prd.setProductName(prdDetails.getProductName());
	prd.setDescription(prdDetails.getDescription());
	prd.setPrice(prdDetails.getPrice());
	
	Product updateProduct = productDAO.save(prd);
	return ResponseEntity.ok().body(updateProduct);





}


/*Delete an Product*/
@DeleteMapping("/notes/{productId}")
public ResponseEntity<Product> deleteProduct(@PathVariable(value="productId")Long prdproductId) {
Product prd = productDAO.findone(prdproductId);
	
	if(prd==null) {
		return ResponseEntity.notFound().build();
	}
	 productDAO.delete(prd);
	 return ResponseEntity.ok().build();


}

}

