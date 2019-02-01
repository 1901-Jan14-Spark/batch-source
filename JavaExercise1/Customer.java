public class Customer {

        //#3//
        private static Double C1funds = 2000.00;
        
        //#2//
        CustomerPurchases(Double cost){
            Double debit = cost;
        }
       
        CustomerPayments(Double pay, Double debt){
            Double remainingDebt = debt - pay;
        }


        //#4//
        public static String getCustomerName(){
            return(customerName);
        }

        public static String getCustomerLocation(){
            return(location);
        }

        public static Double getCustomerFunds(){
            return(funds);   
        }

        public static boolean getCustomerAlcoholClearance(){
            return(AlcoholClearance);
        }

        public static void setCustomerName(String newName){
            Customer.customerName = newName;
        }

        public static void setCustomerLocation(String newLocation){
            Customer.location = newLocation;
        }

        public static void setCustomerFunds(double newTotal){
            Customer.funds += newTotal;
        }

        public static void setCustomerAlcoholClearance(boolean clearance){
            Customer.alcoholClearance = clearance;
        }

        //#5//
    public static void main(String[] args){

        String C2customerName;
        String C2location;
        boolean C2alcoholClearance;

        Double Customer1Purchase = CustomerPurchases(280.43);
        Double Customer1Payment = CustomerPayments(300, Customer1Purchase);
        getCustomerFunds()
        setCustomerFunds(-300);

        C2alcoholClearance = setCustomerAlcoholClearance(false);
        C2location = setCustomerLocation("France");
        C2customerName = setCustomerName("Nathan");

        Double Customer2Purchase = CustomerPurchases(34.33);
        Double Customer2Payment = CustomerPayments(30, Customer2Purchase);

        System.out.println(getCustomerAlcoholClearance());
        System.out.println(getCustomerLocation());
        System.out.println(gtCustomerName());


    }
}
