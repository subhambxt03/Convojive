import javax.swing.*;

public class login {
    public static String getUsername(String role) {
        JTextField usernameField = new JTextField();
        Object[] fields = {role + " Username:", usernameField};

        int option = JOptionPane.showConfirmDialog(null, fields, "Login - " + role,
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.OK_OPTION && !usernameField.getText().trim().isEmpty()) {
            return usernameField.getText().trim();
        } else {
            System.exit(0);
            return null; // unreachable
        }
    }
}
