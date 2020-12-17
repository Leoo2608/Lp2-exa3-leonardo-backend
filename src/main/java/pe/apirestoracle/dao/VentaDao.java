package pe.apirestoracle.dao;

import java.util.List;
import java.util.Map;

import pe.apirestoracle.entity.Venta;

public interface VentaDao {
	int create(Venta r);
	int update(Venta r);
	int update(int id);
	int delete(int id);
    Map<String, Object> read(int id);
    Map<String, Object> readAll();
    Map<String, Object> readv2(int id);
}
