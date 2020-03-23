package cosmonaut.util;

import cosmonaut.entity.OrderItem;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ShoppingCart {
    private List<OrderItem> orderItems;

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    @PostConstruct
    public void init() {
        orderItems = new ArrayList<>();
    }
}
