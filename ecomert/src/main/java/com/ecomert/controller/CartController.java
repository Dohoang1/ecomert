package com.ecomert.controller;

import com.ecomert.model.Cart;
import com.ecomert.model.Product;
import com.ecomert.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private Cart cart;

    @Autowired
    private IProductService productService;

    @GetMapping
    public String viewCart(Model model) {
        model.addAttribute("cart", cart);
        return "cart";
    }

    @PostMapping("/add/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> addToCart(@PathVariable Long id) {
        try {
            Product product = productService.findById(id)
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            cart.addProduct(product);

            Map<String, Object> response = new HashMap<>();
            response.put("message", "Product added to cart");
            response.put("cartCount", cart.getItemCount());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @PostMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> updateQuantity(
            @PathVariable Long id,
            @RequestParam int quantity) {
        cart.updateQuantity(id, quantity);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Cart updated");
        response.put("cartCount", cart.getItemCount());
        response.put("total", cart.getTotal());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/remove/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> removeFromCart(@PathVariable Long id) {
        cart.removeProduct(id);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Product removed from cart");
        response.put("cartCount", cart.getItemCount());
        response.put("total", cart.getTotal());
        return ResponseEntity.ok(response);
    }
}