package pe.apirestoracle.daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import oracle.jdbc.internal.OracleTypes;
import pe.apirestoracle.dao.VentaDao;
import pe.apirestoracle.entity.Venta;

@Component
public class VentaDaoImpl implements VentaDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	@Override
	public int create(Venta r) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Venta r) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> readAll() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("pk_ventas") //nombre del paquete
				.withProcedureName("sp_listar_v") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("cursor_v", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()));	
				Map<String, Object> map = simpleJdbcCall.execute();
		return map;
	}
	@Override
	public Map<String, Object> readv2(int id){
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("pk_ventas") //nombre del paquete
				.withProcedureName("sp_listar_v2") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("cursor_v", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("idp", OracleTypes.NUMBER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("idp", id);
		        Map<String, Object> map= simpleJdbcCall.execute(in);	
				return map;	
	}

}
