public class BMI {

    public static void main(String[] args) {
        
        double x = Double.parseDouble(args[0]) / 100; 
        double y = Double.parseDouble(args[1]);

        System.out.println("Der BMI beträgt: " + y / Math.pow(x,2));
    }
}
