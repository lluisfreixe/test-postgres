package cat.dgp.openshift;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class IndividuoDaoImpl implements IndividuoDao {

	public IndividuoDaoImpl(NamedParameterJdbcTemplate template) {
		this.template = template;
	}

	NamedParameterJdbcTemplate template;

	@Override
	public List<Individuo> findAll() {
		return template.query("select * from Individuo where id_individuo > 0", new IndividuoRowMapper());
	}

	@Override
	public void insertIndividuo(Individuo emp) {
		final String sql = "insert into Individuo(id_individuo, nombre , apellido, edad, telefono, correo) values(:id_individuo,:nombre,:apellido,:edad,:telefono,:correo)";

		KeyHolder holder = new GeneratedKeyHolder();
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("id_individuo", emp.getId_individuo())
				.addValue("nombre", emp.getNombre())
				.addValue("apellido", emp.getApellido())
				.addValue("edad", emp.getEdad())
				.addValue("telefono", emp.getTelefono())
				.addValue("correo", emp.getCorreo());
		template.update(sql, param, holder);

	}

	@Override
	public void updateIndividuo(Individuo emp) {
		final String sql = "update Individuo set id_individuo=:id_individuo, nombre=:nombre, apellido=:apellido, edad=:edad, telefono=:telefono, correo=:correo where id_individuo=:id_individuo";

		KeyHolder holder = new GeneratedKeyHolder();
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("id_individuo", emp.getId_individuo())
				.addValue("nombre", emp.getNombre())
				.addValue("apellido", emp.getApellido())
				.addValue("edad", emp.getEdad())
				.addValue("telefono", emp.getTelefono())
				.addValue("correo", emp.getCorreo());
		template.update(sql, param, holder);

	}

	@Override
	public void executeUpdateIndividuo(Individuo emp) {
		final String sql = "update Individuo set id_individuo=:id_individuo, nombre=:nombre, apellido=:apellido, edad=:edad, telefono=:telefono, correo=:correo where id_individuo=:id_individuo";

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id_individuo", emp.getId_individuo());
		map.put("nombre", emp.getNombre());
		map.put("apellido", emp.getApellido());
		map.put("edad", emp.getEdad());
		map.put("telefono", emp.getTelefono());
		map.put("correo", emp.getCorreo());

		template.execute(sql, map, new PreparedStatementCallback<Object>() {
			@Override
			public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				return ps.executeUpdate();
			}
		});

	}

	@Override
	public void deleteIndividuo(Individuo emp) {
		final String sql = "delete from Individuo where id_individuo=:id_individuo";

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id_individuo", emp.getId_individuo());

		template.execute(sql, map, new PreparedStatementCallback<Object>() {
			@Override
			public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				return ps.executeUpdate();
			}
		});

	}

	@Override
	public void deleteIndividuoAll() {
		final String sql = "delete from Individuo where id_individuo > 0";

		Map<String, Object> map = new HashMap<String, Object>();

		template.execute(sql, map, new PreparedStatementCallback<Object>() {
			@Override
			public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				return ps.executeUpdate();
			}
		});

	}

}
