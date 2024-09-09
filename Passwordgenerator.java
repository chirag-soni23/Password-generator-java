import java.util.Random;
import java.util.Scanner;

public class Passwordgenerator{
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHAR = "!@#$%^&*()-_+=<>?";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();

            System.out.println("Enter a length of password: ");
            int length = scanner.nextInt();

            System.out.println("Include uppercase letters? (yes/no): ");
            boolean includeLowercase = scanner.next().equalsIgnoreCase("yes");

            System.out.println("Include lowercase letters? (yes/no): ");
            boolean includeUppercase = scanner.next().equalsIgnoreCase("yes");

            System.out.println("Include digit? (yes/no): ");
            boolean includeDigits = scanner.next().equalsIgnoreCase("yes");

            System.out.println("Include special character? (yes/no): ");
            boolean includeSpecial = scanner.next().equalsIgnoreCase("yes");

            // build a character pool
            StringBuilder characterPool = new StringBuilder();

            if(includeLowercase){
                characterPool.append(LOWERCASE);
            } if(includeUppercase){
                characterPool.append(UPPERCASE);
            } if(includeDigits){
                characterPool.append(DIGITS);
            } if(includeSpecial){
                characterPool.append(SPECIAL_CHAR);
            }

            if(characterPool.length()>0){
                String password = generatePassword(length, characterPool.toString(), random);
                System.out.println("Generate password: " + password);
            }else{
                System.out.println("You must selected at least one character type.");
            }
        }

    }
    
    public static String generatePassword(int length, String characterPool, Random random){
        StringBuilder password = new StringBuilder(length);
        for(int i = 0;i<length;i++){
            int index = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));

        }
        return password.toString();
    };

}