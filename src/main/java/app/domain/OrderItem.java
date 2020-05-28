package app.domain;


import javax.persistence.*;

@Entity
public class OrderItem
{
    @Id @GeneratedValue @Column(name="ORDER_ITEM_ID")
    private Long id;

//    @Column(name="ORDER_ID")
//    private Long orderId;

    // 외래키의 주인은 나야 나 ~~~
    @ManyToOne
    @JoinColumn(name="ORDER_ID")
    private Orders order;

//    @Column(name="ITEM_ID")
//    private Long itemId;

    // 외래키의 주인은 나야 나 ~~~
    @ManyToOne
    @JoinColumn(name="ITEM_ID")
    private Item item;


    private int orderPrice;

    private int count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
