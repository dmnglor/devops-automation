package com.demo.cicd.devopsautomation.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.cicd.devopsautomation.entity.Product;
import com.demo.cicd.devopsautomation.service.IProductService;


@RestController
public class ProductController 
{
@Autowired
private IProductService iproductService;

@GetMapping(value = "/products")
public List<Product> getProduct() 
{
  List<Product> products = iproductService.findAll();
return products;
}
}
