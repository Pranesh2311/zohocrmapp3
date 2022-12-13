package com.zoho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zoho.dto.Gst;
import com.zoho.entities.Billing;
import com.zoho.entities.Contacts;

import com.zoho.services.BillingService;
import com.zoho.services.ContactService;

@Controller
public class BillingController {
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private BillingService billingService;
	
	@RequestMapping("/billingForm")
	public String viewBillingForm(@RequestParam("contactId")long id, Model model) {
		Contacts contact = contactService.findContactById(id);
		model.addAttribute("contact", contact);
		return "create_bill";
	}
	
//	@RequestMapping("/calculate")
//	public String calculate() {
//		return "create_bill";
//	}
	
	@RequestMapping("/gstCalculate")
	public String gstCalculate(@ModelAttribute("gst")Gst gst, BindingResult result, Model model) {
		model.addAttribute("gst", gst);
		return "create_bill";
	}
	
	@RequestMapping("/generateBill")
	public String generateBill(@ModelAttribute("billing") Billing billing) { //"@ModelAttribute("billing")" it is not mandatory to write this, without this also it should work but it is a good practise...
		billingService.generateInvoice(billing);
		return "create_bill";
	}
	
	//http://localhost:8080/listBill
	@RequestMapping("/listBill")
	public String listAllBilling(Model model) {
		List<Billing> billings = billingService.getAllBillingList();
		model.addAttribute("billings", billings);
		return "billing_list";
	}
}
