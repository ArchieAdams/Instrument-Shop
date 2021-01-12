public class Instrument{

    public String instrument;
    public String name;
    public String manufacturer;
    public double price;
    public int stock;
    public String ISBN;

    public Instrument(String instrument,String name , String manufacturer,double price , int stock, String ISBN){
        this.instrument = instrument;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.stock = stock;
        this.ISBN = ISBN;
    }

    public String getInstrument() {
        return instrument;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
