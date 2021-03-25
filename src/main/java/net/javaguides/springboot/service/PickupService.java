package net.javaguides.springboot.service;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.domain.Page;

import net.javaguides.springboot.model.Pickup;

public interface PickupService {
	List<Pickup> getAllPickup();
	void savePickup(Pickup pickup);
	Pickup getPickupById(long id);
	Page<Pickup> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	Integer siguienteOrder();
	Integer siguientePedido();
	java.time.LocalTime LocalTime();
	
	
}
