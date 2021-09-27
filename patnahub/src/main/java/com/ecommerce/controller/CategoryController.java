package com.ecommerce.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.model.Category;
import com.ecommerce.repository.CategoryRepository;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@RequestMapping("/category")
    public String category(Model model) {
        model.addAttribute("title", "category type");
        List<Category> listCateg=categoryRepository.findAll();
        model.addAttribute("listCategory", listCateg);
        return "category";
    }

	@RequestMapping(value="/add-category",method=RequestMethod.GET)
    public String addCategory(Model model,@RequestParam("categoryName") String categoryName,
    		@RequestParam("categoryDesc") String categoryDesc) 
	{
        model.addAttribute("title", "category type");
        Category category=new Category();
        
        category.setCategoryName(categoryName);
        category.setCategoryDesc(categoryDesc);
        categoryRepository.save(category);
        List<Category> listCateg=categoryRepository.findAll();
        model.addAttribute("listcategory", listCateg);
        return "category";
    }
	
	@RequestMapping(value="/update-category/{categoryId}",method=RequestMethod.GET)
    public String updateCategory(Model model,@RequestParam("categoryId") Integer categoryId,@RequestParam("categoryName") String categoryName,
    		@RequestParam("categoryDesc") String categoryDesc) 
	{
        model.addAttribute("update category", "category type");
        Category category=categoryRepository.findByCategoryId(categoryId);
        
        category.setCategoryName(categoryName);
        category.setCategoryDesc(categoryDesc);
        //categoryRepository.save(category);
        //List<Category> listCateg=categoryRepository.findAll();
        //model.addAttribute("listcategory", listCateg);
        model.addAttribute("category", category);
        return "category";
    }
	@RequestMapping(value="/delete-category/{categoryId}",method=RequestMethod.GET)
    public String deleteCategory(Model model,@PathVariable("categoryId") int categoryId)
    		{
		categoryRepository.deleteById(categoryId);
		   
		 List<Category> listCateg=categoryRepository.findAll();
	        model.addAttribute("listcategory", listCateg);
	        model.addAttribute("pageinfo", "manage category");
	        return "category";
    		}
	@RequestMapping("/edit-category/{categoryId}")
    public String editCategory(Model model,@PathVariable("categoryId") int categoryId)
    {
		 Category category=categoryRepository.findByCategoryId(categoryId);
		 model.addAttribute("category",category);
		 model.addAttribute("pageinfo", "manage category");
		 return "update_category";
    }
}
