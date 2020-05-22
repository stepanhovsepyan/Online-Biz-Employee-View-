public class Product{
  String name;
  double purchaseCost;
  double sellPrice;
  int quantity;
  int itemNumber;
  public Product(double purchaseCost, int sellPrice, int quantity, String name){
    this.purchaseCost = purchaseCost;
    this.sellPrice = sellPrice;
    this.quantity = quantity;
    this.name = name;
  }
  public double getpurchaseCost(){
    return purchaseCost;
  }
  public double getsellPrice(){
    return sellPrice;
  }
  public int getQuantity(){
    return quantity;
  }
  public String getName(){
    return name;
  }
  public int getitemNumber(){
    return itemNumber;
  }
  public void setpurchaseCost(int newpurchaseCost){
    purchaseCost = newpurchaseCost;
  }
  public void setsellPrice(double newsellPrice){
    sellPrice = newsellPrice;
  }
  public void setQuantity(int newQuantity){
    quantity = newQuantity;
  }
}
