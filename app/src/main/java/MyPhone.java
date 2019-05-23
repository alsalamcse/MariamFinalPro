public class MyPhone
{
    private int year;
    private  String name;
    private Double price;
    private String company;
    private String  Production;
    private long _id;
    public MyPhone()
    {

    }
    public MyPhone(String name, Double price, String company, String Production, int year)
    {
        this.name = name;
        this.price = price;
        this.company = company;
        this.Production = Production;
        this.year = year;
    }

    public MyPhone(String name, Double price, String company, String Production, int year,long _id) {
        this.name = name;
        this.price = price;
        this.company = company;
        this.Production = Production;
        this.year = year;
        this._id = _id ;
    }
    public long get_id() { return _id; }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getProduction() {
        return Production;
    }

    public  Double  getprice() {
        return price;
    }

    public  int  getYear() {
        return year;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setProduction(String  Production) {
        this.Production = Production;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString() { return "name:"+name+ "price:" +price+ "company:"+company+ "Production:"+Production+ "year:"+year+ "id:"+ _id; }


}

