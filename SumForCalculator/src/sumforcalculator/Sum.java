package sumforcalculator;

class Sum {
    public static void main(String[] args) {
        double ans = 12, ans2;
        String a = "", a2;
        try{
            ans2 = Double.parseDouble(a.toString());
            ans = ans + ans2;
        }
        catch(java.lang.NumberFormatException o){}
        System.out.println("Answer: " + ans);
        //output.setText(String.valueOf(ans));
    }
}
