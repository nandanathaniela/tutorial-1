package id.ac.ui.cs.advprog.eshop.model;
import lombok.Getter;
import java.util.Map;

@Getter
public class BankPayment extends Payment {
    public BankPayment(String id, String method, Order order, Map<String, String> paymentData, String status) {
    }

    public BankPayment(String id, String method, Order order, Map<String, String> paymentData) {
    }
}