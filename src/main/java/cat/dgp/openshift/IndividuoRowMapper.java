package cat.dgp.openshift;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class IndividuoRowMapper implements RowMapper<Individuo> {

	@Override
	public Individuo mapRow(ResultSet rs, int arg1) throws SQLException {
		Individuo emp = new Individuo();
		emp.setId_individuo(rs.getInt("id_individuo"));
		emp.setNombre(rs.getString("nombre"));
		emp.setApellido(rs.getString("apellido"));
		emp.setEdad(rs.getInt("edad"));
		emp.setTelefono(rs.getString("telefono"));
		emp.setCorreo(rs.getString("correo"));
		return emp;
	}

}
