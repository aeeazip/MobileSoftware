package ddwucom.mobile.finalreport;

import java.io.Serializable;

public class MyData implements Serializable {
    private long _id;
    private String imageSrc;
    private String company;
    private String name;
    private String price;
    private String explanation;

    public MyData(String imageSrc, String company, String name, String price, String explanation) {
        this.imageSrc = imageSrc;
        this.company = company;
        this.name = name;
        this.price = price;
        this.explanation = explanation;
    }

    public MyData(long _id, String imageSrc, String company, String name, String price, String explanation) {
        this._id = _id;
        this.imageSrc = imageSrc;
        this.company = company;
        this.name = name;
        this.price = price;
        this.explanation = explanation;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    @Override
    public String toString() {
        return "MyData{" +
                "_id=" + _id +
                ", company='" + company + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", explanation='" + explanation + '\'' +
                '}';
    }
}
