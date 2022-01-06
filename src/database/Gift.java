package database;

import enums.Category;
import org.json.simple.JSONObject;

public class Gift {

    public Gift() { }

    private String productName;
    private Double price;
    private Category category;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public JSONObject toJSONObject() {
        JSONObject output = new JSONObject();

        output.put("productName", this.productName);
        output.put("price", this.price);
        output.put("category", this.category.getValue());

        return output;
    }

    @Override
    public String toString() {
        return "Gift{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}
