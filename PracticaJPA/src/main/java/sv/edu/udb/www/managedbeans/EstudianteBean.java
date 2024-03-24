package sv.edu.udb.www.managedbeans;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import sv.edu.udb.www.entities.EstudiantesEntity;
import sv.edu.udb.www.models.EstudiantesModel;
import sv.edu.udb.www.utils.JsfUtil;
import java.util.List;
@ManagedBean
@RequestScoped

public class EstudianteBean {
    EstudiantesModel modelo = new EstudiantesModel();
    private EstudiantesEntity estudiante;
    private List<EstudiantesEntity> listaEstudiantes;
    public EstudianteBean() {
        estudiante = new EstudiantesEntity();
    }
    public EstudiantesEntity getEstudiante() {
        return estudiante;
    }
    public void setEstudiante(EstudiantesEntity estudiante) {
        this.estudiante = estudiante;
    }
    public List<EstudiantesEntity> getListaEstudiantes() {
/* Notese que se llama al método listarEstudiantes
para obtener la lista de objetos a partir de la bd */
        return modelo.listarEstudiante();
    }
    public String guardarEstudiante() {
        if (modelo.insertarEstudiante(estudiante) != 1) {
            JsfUtil.setErrorMessage(null, "Ya se registró un alumno con este carnet");
            return null;//Regreso a la misma página
        } else {
            JsfUtil.setFlashMessage("exito", "Alumno registrado exitosamente");
            //Forzando la redirección en el cliente
            return "registroEstudiantes?faces-redirect=true";
        }
    }
    public String eliminarEstudiante() {
        // Leyendo el parametro enviado desde la vista
        String carnet= JsfUtil.getRequest().getParameter("carnet");

        if (modelo.eliminarEstudiante(carnet) > 0) {
            JsfUtil.setFlashMessage("exito", "Estudiante eliminado exitosamente");
        }
        else{
            JsfUtil.setErrorMessage(null, "No se pudo borrar a este alumno");
        }
        return "registroEstudiantes?faces-redirect=true";
    }
}
