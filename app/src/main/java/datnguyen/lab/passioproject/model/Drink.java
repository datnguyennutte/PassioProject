package datnguyen.lab.passioproject.model;

public class Drink {
    private String drinkName;
    private Integer price, urlImage;

    public Drink(String drinkName, int price, Integer urlImage) {
        this.drinkName = drinkName;
        this.price = price;
        this.urlImage = urlImage;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Integer getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(Integer urlImage) {
        this.urlImage = urlImage;
    }
}
