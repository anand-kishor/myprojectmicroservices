package com.ecommerce.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.model.CartItem;
import com.ecommerce.model.OrderDetails;
import com.ecommerce.model.UserDetails;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.repository.OrderDetailsRepository;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.repository.UserDetailsRepository;

@Controller
public class PaymentController {
	
	@Autowired
	private OrderDetailsRepository orderDetailsRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	@RequestMapping(value="/checkout")
	public String checkOut(Model model,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		List<CartItem> cartItemList=cartRepository.findAllByCardItemUsername(username);
		model.addAttribute("cartitemlist", cartItemList);
		model.addAttribute("grantotal", this.getGrandTotal(cartItemList));
		
		UserDetails userDetails=userDetailsRepository.getUsername(username);
		String address=userDetails.getUserAddress();
		
		model.addAttribute("address", address);
		
		return "order_conform";
	}
	@RequestMapping(value="/update-address")
	public String updateAddress(@RequestParam("address") String address,Model model,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		List<CartItem> cartItemList=cartRepository.findAllByCardItemUsername(username);
		model.addAttribute("cartitemlist", cartItemList);
		model.addAttribute("grantotal", this.getGrandTotal(cartItemList));
		
		UserDetails userDetails=userDetailsRepository.getUsername(username);
		userDetails.setUserAddress(address);
		userDetailsRepository.save(userDetails);
		model.addAttribute("address", address);
		
		
	return "order_conform";	
	}
	/*
	 * @RequestMapping(value="/receipt",method=RequestMethod.POST) public String
	 * receipt(@RequestParam("rd") String rd,Model model,HttpSession session) {
	 * String username=(String)session.getAttribute("username"); OrderDetails
	 * orderDetails=new OrderDetails(); orderDetails.setOrderDate(new
	 * java.util.Date());
	 * orderDetails.setAddress(userDetailsRepository.getUsername(username).
	 * getUserAddress()); orderDetails.setTransaction(rd);
	 * orderDetails.setUsername(username); List<CartItem>
	 * cartItemList=cartRepository.findAllByCardItemUsername(username);
	 * model.addAttribute("cartitemlist", cartItemList);
	 * model.addAttribute("grantotal", this.getGrandTotal(cartItemList));
	 * UserDetails userDetails=userDetailsRepository.getUsername(username);
	 * orderDetails.setTotalAmount(this.getGrandTotal(cartItemList));
	 * orderDetailsRepository.save(orderDetails);
	 * //orderDetailsRepository.updateCart(username);
	 * model.addAttribute("orderDetails", orderDetails); return "receipt"; }
	 */
	
	@RequestMapping(value="/payment")
	public String payment(@RequestParam("address") String address,Model model,HttpSession session)
	{
		return "payment";
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
