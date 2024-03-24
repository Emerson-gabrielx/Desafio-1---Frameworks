package sv.edu.udb.www.managedbeans;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class LoginBean {
    private String username;
    private String password;
    private String message;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String login() {
        // Aquí validarías las credenciales del usuario
        // contra una base de datos o un servicio de autenticación

        // Si las credenciales son correctas, puedes redirigir a otra página
        if (username.equals("admin") && password.equals("admin")) {
            message = "Inicio de sesión exitoso";
            return null; // Permanece en la misma página
        } else {
            message = "Credenciales incorrectas";
            return null; // Permanece en la misma página
        }
    }
}

