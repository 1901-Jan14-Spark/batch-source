public class Pizza{
String crustType;
String sauceType;
boolean hasCheese;
String shape;
int slices;
int size;


Pizza (String sauceType, boolean hasCheese){
    this.sauceType = sauceType;
    this.hasCheese = hasCheese;
}
public static void main() {
    Pizza p = new Pizza("red",true);
    system.out.prinln(p.toString());
    
}
public String toString(){
    return "My Pizza: crustType"+crustType+", hasCheese="+hascheese+", sauceType="+sauceType;
}
}