package net.javaguides.springboot.service;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Pickup;
import net.javaguides.springboot.repository.PickupRepository;

@Service
public class PickupServiceImpl implements PickupService {

	@Autowired
	private PickupRepository pickupRepository;

	@Override
	public List<Pickup> getAllPickup() {
		return pickupRepository.findAll();
	}

	@Override
	public void savePickup(Pickup pickup) {
		
	   //criteria
		
		
		this.pickupRepository.save(pickup);
	}

	@Override
	public Pickup getPickupById(long id) {
		Optional<Pickup> optional = pickupRepository.findById(id);
		Pickup employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException(" Employee not found for id :: " + id);
		}
		return employee;
	}

	

	@Override
	public Page<Pickup> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.pickupRepository.findAll(pageable);
	}

	private static SessionFactory factory; 
	
	  @Autowired
	  public void SomeService(EntityManagerFactory factory) {
	    if(factory.unwrap(SessionFactory.class) == null){
	      throw new NullPointerException("factory is not a hibernate factory");
	    }
	    this.factory = factory.unwrap(SessionFactory.class);
	  }
	  
	@Override
	public Integer siguienteOrder() {
		
	
		Session session = factory.openSession();
		
		Criteria crit = session.createCriteria(Pickup.class);
		ProjectionList projList = Projections.projectionList();
		projList.add(Projections.max("orden"));
	
		crit.setProjection(projList);
		List<Object[]> results = crit.list();
	
		
		Object o =  results.get(0);
		
		Integer siguienteOrder;
		
		
		if(o==null) {
			siguienteOrder=1;
		}else {
			siguienteOrder = Integer.valueOf(o.toString()) +1;
		}
		  
		return siguienteOrder;
		
	}
	
	public Integer siguientePedido() {
		
	
		Session session = factory.openSession();
		
		Criteria crit = session.createCriteria(Pickup.class);
		ProjectionList projList = Projections.projectionList();
		projList.add(Projections.max("orden"));
	
		crit.setProjection(projList);
		List<Object[]> results = crit.list();
	
		
		Object o =  results.get(0);
		
		Integer siguientePedido;
		
		
		if(o==null) {
			siguientePedido=1;
		}else {
			siguientePedido = Integer.valueOf(o.toString()) +1;
		}
		
		
		  
		return siguientePedido;
		
	}

	
	public java.time.LocalTime LocalTime() {
	
		java.time.LocalTime hora;
		
		hora =  LocalTime.now();
		
		return hora;
	}
	

}
