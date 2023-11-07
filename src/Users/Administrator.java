package Users;

public abstract class Administrator extends User{

    private static final String password = "1234";
    private static final String username = "Yves";

    public static boolean isLoginCorrect(String usernameInput, String passwordInput){
        return usernameInput.equals(username) && passwordInput.equals(password);
    }
}
