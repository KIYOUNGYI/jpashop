//package app.domain;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//
//@Entity
//public class Item
//{
//    @Id @GeneratedValue
//    @Column(name="ITEM_ID")
//    private Long id;
//    private String name;
//    private int price;
//    private int stockQuantity;
//
//    public Item() {
//    }
//
//    public Item(String name, int price, int stockQuantity) {
//        this.name = name;
//        this.price = price;
//        this.stockQuantity = stockQuantity;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public int getStockQuantity() {
//        return stockQuantity;
//    }
//
//    @Override
//    public String toString() {
//        return "Item{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", price=" + price +
//                ", stockQuantity=" + stockQuantity +
//                '}';
//    }
//}
