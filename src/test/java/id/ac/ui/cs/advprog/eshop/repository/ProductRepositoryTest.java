package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {

    @InjectMocks
    ProductRepository productRepository;
    @BeforeEach
    void setup() {}

    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setProductId("6f1238f8-d13a-4e5b-936f-e55156158104");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("6f1238f8-d13a-4e5b-936f-e55156158104");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("857b3c84-8eab-4296-8ca9-6773ffd86517");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testEditProduct() {
        Product product = new Product();
        product.setProductId("6f1238f8-d13a-4e5b-936f-e55156158104");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Product editedProduct = new Product();
        editedProduct.setProductId("6f1238f8-d13a-4e5b-936f-e55156158104");
        editedProduct.setProductName("Sampo Cap Bakso");
        editedProduct.setProductQuantity(200);
        productRepository.edit(editedProduct);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(editedProduct.getProductId(), savedProduct.getProductId());
        assertEquals(editedProduct.getProductName(), savedProduct.getProductName());
        assertEquals(editedProduct.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testEditProductWithMoreThanOneItem() {
        Product product1 = new Product();
        product1.setProductId("6f1238f8-d13a-4e5b-936f-e55156158104");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("857b3c84-8eab-4296-8ca9-6773ffd86517");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Product editedProduct = new Product();
        editedProduct.setProductId("6f1238f8-d13a-4e5b-936f-e55156158104");
        editedProduct.setProductName("Sampo Cap Bakso");
        editedProduct.setProductQuantity(200);
        productRepository.edit(editedProduct);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(editedProduct.getProductId(), savedProduct.getProductId());
        assertEquals(editedProduct.getProductName(), savedProduct.getProductName());
        assertEquals(editedProduct.getProductQuantity(), savedProduct.getProductQuantity());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertEquals(product2.getProductName(), savedProduct.getProductName());
        assertEquals(product2.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testEditProductNotFound() {
        Product editedProduct = new Product();
        editedProduct.setProductId("6f1238f8-d13a-4e5b-936f-e55156158104");
        editedProduct.setProductName("Sampo Cap Bakso");
        editedProduct.setProductQuantity(200);

        assertThrows(IllegalArgumentException.class, () ->
                productRepository.edit(editedProduct));
    }

    @Test
    void testEditProductWithNullId() {
        Product editedProduct = new Product();
        editedProduct.setProductName("Sampo Cap Bakso");
        editedProduct.setProductQuantity(200);

        assertThrows(IllegalArgumentException.class, () ->
                productRepository.edit(editedProduct));
    }

    @Test
    void testDeleteProduct() {
        Product product = new Product();
        product.setProductId("6f1238f8-d13a-4e5b-936f-e55156158104");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Product deletedProduct = productRepository.delete(product.getProductId());
        assertEquals(product, deletedProduct);

        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testDeleteProductWithMoreThanOneItem() {
        Product product1 = new Product();
        product1.setProductId("6f1238f8-d13a-4e5b-936f-e55156158104");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("857b3c84-8eab-4296-8ca9-6773ffd86517");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Product deletedProduct = productRepository.delete(product1.getProductId());
        assertEquals(product1, deletedProduct);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertEquals(product2.getProductName(), savedProduct.getProductName());
        assertEquals(product2.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testDeleteProductWithNullId() {
        assertThrows(IllegalArgumentException.class, () ->
                productRepository.delete(null));
    }

    @Test
    void testDeleteProductNotFound() {
        assertThrows(IllegalArgumentException.class, () ->
                productRepository.delete("6f1238f8-d13a-4e5b-936f-e55156158104"));
    }
}