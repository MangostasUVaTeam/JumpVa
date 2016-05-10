
package database;

public class Consulta {
    public boolean autenticacion(String email, String contrasenia){
        try{
            Statement statement = connection.createStatement();
            ResultSet product = statement.executeQuery("SELECT U.email FROM Usuario U WHERE U.email ="+email+"AND U.contrasenia ="+contrasenia);
            if((String)product.next()==email){
                return true;
            } else {
                return false;
            }
        } catch(SQLException e){
            
        }
    }
}
