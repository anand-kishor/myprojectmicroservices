package com.ecommerce.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.model.Category;
import com.ecommerce.model.Product;
import com.ecommerce.repository.CategoryRepository;
import com.ecommerce.repository.ProductRepository;

@Controller
public class ProductController {
	@Autowired
	private CategoryRepository categoryRepository; 
	@Autowired
	private ProductRepository productRepository; 
	
	@RequestMapping("/product")
	public String showProduct(Model model)
	{
		Product product=new Product();
		model.addAttribute(product);
		List<Product> productList=productRepository.findAll();
		model.addAttribute("productlist", productList);
		List<Category> categoryList=this.categoryRepository.findAll();
		model.addAttribute("categoryList",categoryList );
		model.addAttribute("pageinfo", "manage product");
		return "product";
	}
	@RequestMapping(value="/insert-product", method=RequestMethod.POST)
	public String insertProduct(@ModelAttribute("product") Product product,@RequestParam("pimage") MultipartFile file,
			Model model)
	{
		
		
		model.addAttribute("product", product);
		productRepository.save(product);
		model.addAttribute("pageinfo", "manage product");
		List<Category> categoryList=this.categoryRepository.findAll();
		
		model.addAttribute("categorylist", categoryList);
		String imagepath="E:\\myproject\\patnahub\\src\\main\\webapp\\images";
		imagepath=imagepath+String.valueOf(product.getProductId()+".jpg");
		File fileImage=new File(imagepath);
		if(!file.isEmpty())
		{
			try {
				byte bytes[]=file.getBytes();
				FileOutputStream fos=new FileOutputStream(fileImage);
				BufferedOutputStream bs=new BufferedOutputStream(fos);
				bs.write(bytes);
				bs.close();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("image not present in file");
				model.addAttribute("error info", "exception occured in image uploading:"+e.getMessage());
			}
		}
		else {
			model.addAttribute("error info", "problem occured in image uploading:");
		}
		List<Product> productList=productRepository.findAll();
		model.addAttribute("productList", productList);
		return "product";
	}
	@RequestMapping(value="/update-product", method=RequestMethod.POST)
	public String updateProduct(@ModelAttribute("product") Product product ,Model model)
	{
		 
		
		 model.addAttribute(product);
		 model.addAttribute("pageinfo", "manage product");
		 List<Category> categoryList=this.categoryRepository.findAll();
			model.addAttribute("categoryList",categoryList );
		 List<Product> productList=productRepository.findAll();
		 model.addAttribute("productlist", productList);
	return "product";
	}
	@RequestMapping(value="/delete-product/{productId}")
	public String updateProduct(@PathVariable("product") int productId,Model model)
	{
		 Product product=productRepository.getById(productId);
		 productRepository.delete(product);
		 Product product1=new Product();
		 model.addAttribute(product1);
		 model.addAttribute("pageinfo", "manage product");
		 List<Category> categoryList=this.categoryRepository.findAll();
			model.addAttribute("categoryList",categoryList );
		 List<Product> productList=productRepository.findAll();
		 model.addAttribute("productlist", productList);
	return "product";
	}
	@RequestMapping(value="/edit-product/{productId}")
	public String editProduct(@PathVariable("product") int productId,Model model)
	{
		 Product product=productRepository.getById(productId);
		 model.addAttribute(product);
		
		 model.addAttribute("pageinfo", "manage product");
		 List<Category> categoryList=this.categoryRepository.findAll();
			model.addAttribute("categoryList",categoryList );
		 
	return "update_product";
	}
	
	@RequestMapping(value="/product-display", method=RequestMethod.GET)
	public String productDisplay(Model model)
	{
		 model.addAttribute("pageinfo", "product catalog");
		
		 List<Product> productList=productRepository.findAll();
		 model.addAttribute("productlist", productList);
		return "product_display";
	}
	@RequestMapping(value="/total-product-display/{productId}")
	public String totalProductDisplay(@PathVariable ("productId") int productId,Model model)
	{
		 model.addAttribute("pageinfo", "product catalog");
		Product product=productRepository.findByProductId(productId);
		 model.addAttribute("product", product);
		return "total_product_display";
	}
}
