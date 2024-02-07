package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/create")
    public String createProductPage(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "createProduct";
    }

    @PostMapping("/create")
    public String createProductPost(@ModelAttribute Product product, Model model){
        service.create(product);
        return "redirect:/product";
    }

    @GetMapping("")
    public String productListPage(Model model){
        List<Product> allProducts = service.findAll();
        model.addAttribute("products", allProducts);
        return "productList";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable String id, Model model) {
        Product product = service.findById(id);
        if (product != null) {
            model.addAttribute("product", product);
            return "editProduct";
        } else {
            return "redirect:/product";
        }
    }


    @PostMapping("/edit/{id}")
    public String editProduct( @ModelAttribute Product product) {
        service.update(product);
        return "redirect:/product";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable String id) {
        Product product = service.findById(id);
        service.delete(product);
        return "redirect:/product";
    }
}
