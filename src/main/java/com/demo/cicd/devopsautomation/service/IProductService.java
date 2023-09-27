package com.demo.cicd.devopsautomation.service;
import java.util.List;

import com.demo.cicd.devopsautomation.entity.Product;


public interface IProductService 
{
List<Product> findAll();
}
