package com.coffeeshop.menu.controller;

import com.coffeeshop.menu.model.Product;
import com.coffeeshop.menu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    // Display list of products
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listProducts", productService.getAllProducts());
        return "menu";
    }
    
    // Show form for new product
    @GetMapping("/showNewProductForm")
    public String showNewProductForm(Model model) {
        // Create model attribute to bind form data
        Product product = new Product();
        model.addAttribute("product", product);
        return "add-new-product";
    }

    // Save product to database
    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product) {
        // Save product to database
        productService.saveProduct(product);
        return "redirect:/";
    }

    // Show form for updating product
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable int id, Model model) {
        // Get product from the service
        Product product = productService.getProductById(id);
        
        // Set product as a model attribute to pre-populate the form
        model.addAttribute("product", product);
        return "update-product";
    }

    // Delete product
    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id) {
        // Call delete product method from service
        this.productService.deleteProductById(id);
        return "redirect:/";
    }
}