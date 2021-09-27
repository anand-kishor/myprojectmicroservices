package com.ecommerce.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.model.CartItem;
import com.ecommerce.model.Product;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.repository.ProductRepository;

@Controller
public class CartController {
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping("/cart")
	public String showCart(Model model,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		List<CartItem> cartItemList=cartRepository.findAllByCardItemUsername(username);
		model.addAttribute("cartitemlist", cartItemList);
		model.addAttribute("grantotal", this.getGrandTotal(cartItemList));
		return "cart";
	}
	@RequestMapping("/addcart/{productId}")
	public String addCart(@PathVariable("productId") int productId,@RequestParam("quantity") int quantity,Model model,HttpSession session)
	{
		Product product=productRepository.findByProductId(productId);
		String username=(String)session.getAttribute("username");
		CartItem cartItem=new CartItem();
		cartItem.setProductId(product.getProductId());
		cartItem.setProductName(product.getProductName());
		cartItem.setQuantity(quantity);
		cartItem.setPrice(product.getPrice());
		cartItem.setUsername(username);
		
		cartRepository.save(cartItem);
		List<CartItem> cartItemList=cartRepository.findAll();
		model.addAttribute("cartitemlist", cartItemList);
		model.addAttribute("grantotal", this.getGrandTotal(cartItemList));
		
		return "cart";
	}
	@RequestMapping("/updatecart/{cartItemId}")
	public String updateCart(@PathVariable("cartItemId") int cartItemId,@RequestParam("quantity") int quantity,Model model,HttpSession session)
	{
		CartItem cartItem=cartRepository.findBycardItemId(cartItemId);
		cartItem.setQuantity(quantity);
		String username=(String)session.getAttribute("username");
		List<CartItem> cartItemList=cartRepository.findAllByCardItemUsername(username);
		model.addAttribute("cartitemlist", cartItemList);
		model.addAttribute("grantotal", this.getGrandTotal(cartItemList));
		
	return "cart";
	}
	@RequestMapping("/deletecart/{cartItemId}")
	public String deleteCart(@PathVariable("cartItemId") int cartItemId,Model model,HttpSession session)
	{
		CartItem cartItem=cartRepository.findBycardItemId(cartItemId);
		cartRepository.delete(cartItem);
		String username=(String)session.getAttribute("username");
		List<CartItem> cartItemList=cartRepository.findAllByCardItemUsername(username);
		model.addAttribute("cartitemlist", cartItemList);
		model.addAttribute("grantotal", this.getGrandTotal(cartItemList));
		return "cart";
	}	
	public int getGrandTotal(List<CartItem> cartList)
	{
		int grandTotal=0,count=0;
		while(count<cartList.size())
		{
			grandTotal=grandTotal+(cartList.get(count).getQuantity()*cartList.get(count).getPrice());
			count++;
		}
		return grandTotal;
	}
}
