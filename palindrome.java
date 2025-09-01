class Palindrome{
    public static void main(String[] args){
        String str = "RaceCar";
        String word = str.toUpperCase();
        String original_word = word;
        String reversed_word = "";
        for(int i = word.length() - 1;i >=0 ;i--){
            reversed_word = reversed_word + word.charAt(i);
    }
    if(original_word.equals(reversed_word))
    System.out.println("Palindrome");
    else
       System.out.println("Not a Palindrome");
}
}