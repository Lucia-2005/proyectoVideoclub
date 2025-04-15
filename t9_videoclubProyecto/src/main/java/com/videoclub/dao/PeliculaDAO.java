package com.videoclub.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.videoclub.model.Pelicula;
import com.videoclub.util.VideoclubUtils;

public class PeliculaDAO {

	//selectById PELICULA
		public Pelicula selectPeliById(int id) {
			Transaction transaction=null;
			Pelicula p=null;
			try(Session session=VideoclubUtils.getSessionFactory().openSession()){
				transaction=session.beginTransaction();
				p=session.get(Pelicula.class, id);
				transaction.commit();
			}catch(Exception e) {
				if(transaction!=null) {
					transaction.rollback();			
				}
			}
			return p;
		}
		
		//-----------------------------------------------------------------------------------
		
		//insertar PELICULA
		public void insertPelicula(Pelicula p) {
			Transaction transaction=null;
			try(Session session=VideoclubUtils.getSessionFactory().openSession()){
				transaction=session.beginTransaction();
				session.persist(p);
				transaction.commit();
			}catch(Exception e) {
				if(transaction!=null) {
					transaction.rollback();			
				}
			}
		}
		
		//-----------------------------------------------------------------------------------
		
		//actualizar PELICULA
		public void updatePelicula(Pelicula p) {
			Transaction transaction=null;
			try(Session session=VideoclubUtils.getSessionFactory().openSession()){
				transaction=session.beginTransaction();
				session.merge(p);
				transaction.commit();
			}catch(Exception e) {
				if(transaction!=null) {
					transaction.rollback();			
				}
			}
		}
		
		//-----------------------------------------------------------------------------------
		
		//eliminar PELICULA
		public void deletePelicula(int id) {
			Transaction transaction=null;
			Pelicula p=null;
			try(Session session=VideoclubUtils.getSessionFactory().openSession()){
				transaction=session.beginTransaction();
				p=session.get(Pelicula.class, id);
				session.remove(p);
				transaction.commit();
			}catch(Exception e) {
				if(transaction!=null) {
					transaction.rollback();			
				}
			}
		}
		
		//-----------------------------------------------------------------------------------
		
		//seleccionar todas PELICULAS
		public List<Pelicula> selectAllPeliculas(){
			Transaction transaction=null;
			List<Pelicula> peliculas=null;
			try(Session session=VideoclubUtils.getSessionFactory().openSession()){
				transaction=session.beginTransaction();
				peliculas=session.createQuery("FROM Pelicula", Pelicula.class).getResultList();
				transaction.commit();
			}catch(Exception e) {
				if(transaction!=null) {
					transaction.rollback();			
				}
			}
			return peliculas;
		}
		
		//-----------------------------------------------------------------------------------
		
		//seleccionar peliculas a partir de cierto año
		public List<Pelicula> selectPeliculaSegunYear(int year){
			Transaction transaction=null;
			List<Pelicula> peliculas=null;
			try(Session session=VideoclubUtils.getSessionFactory().openSession()){
				transaction=session.beginTransaction();
				//consulta de mysql, pero todos los valores son de la clase
				Query <Pelicula> query=session.createQuery("FROM Pelicula WHERE year> :yearMin", Pelicula.class);
				query.setParameter("yearMin", year);
				peliculas=query.getResultList();
				transaction.commit();
			}catch(Exception e) {
				if(transaction!= null) {
					transaction.rollback();
				}
			}
			return peliculas;
		}
		
}//DAO
