package app.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Orders
{
    @Id @GeneratedValue
    @Column(name="ORDER_ID")
    private Long id;

    private Long memberId;
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public Orders() {
    }

    public Orders(Long memberId, LocalDateTime orderDate, OrderStatus orderStatus)
    {
        this.memberId = memberId;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }

    public Long getId() {
        return id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", orderDate=" + orderDate +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
