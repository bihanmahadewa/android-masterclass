package com.bihanmahadewa.dominospizza;

public class Product {
    private String productTitle;
    private String productDescription;
    private String productPrice;
    private String productImg;

    public Product(String productTitle, String productDescription, String productPrice, String productImg){
        setProductTitle(productTitle);
        setProductDescription(productDescription);
        setProductPrice(productPrice);
        setProductImg(productImg);
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }
}
