package main.Entrata;

public class EtantraEnum {
    public enum etantraProducts{
        Property_Management("Property Management"),
        Marketing("Marketing & Leasing"),
        Accounting("Accounting"),
        Utilities("Utilities");
        private String val;
        etantraProducts(String val) {
            this.val=val;
        }
        public String getProduct(){
            return val;
        }
    }

    public enum signInOption{
        PropertyManagerLogin("Property Manager Login"),
        ResidentLogin("Resident Login");
        private String val;
        signInOption(String val) {
            this.val=val;
        }
        public String getOption(){
            return val;
        }
    }
}
