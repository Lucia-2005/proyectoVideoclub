package com.videoclub.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.videoclub.model.Pelicula;
import com.videoclub.model.Usuario;
import com.videoclub.util.VideoclubUtils;

public class VideoclubDAO {

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
	
	//selectById USUARIO
	public Usuario selectUserById(int id) {
		Transaction transaction=null;
		Usuario u=null;
		try(Session session=VideoclubUtils.getSessionFactory().openSession()){
			transaction=session.beginTransaction();
			u=session.get(Usuario.class, id);
			transaction.commit();
		}catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();			
			}
		}
		return u;
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
	
	//insert USUARIO
	public void insertUsuario(Usuario u) {
		Transaction transaction=null;
		try(Session session=VideoclubUtils.getSessionFactory().openSession()){
			transaction=session.beginTransaction();
			session.persist(u);
			transaction.commit();
		}catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();			
			}
		}
	}
	
	//----------------------------------------------------------------------------------
	
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
	
	//actualizar USUARIO
	public void updateUsuario(Usuario u) {
		Transaction transaction=null;
		try(Session session=VideoclubUtils.getSessionFactory().openSession()){
			transaction=session.beginTransaction();
			session.merge(u);
			transaction.commit();
		}catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();			
			}
		}
	}
	
	//----------------------------------------------------------------------------------
	
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
	
	//eliminar USUARIO
	public void deleteUsuario(int id) {
		Transaction transaction=null;
		Usuario u=null;
		try(Session session=VideoclubUtils.getSessionFactory().openSession()){
			transaction=session.beginTransaction();
			u=session.get(Usuario.class, id);
			session.remove(u);
			transaction.commit();
		}catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();			
			}
		}
	}
	
	//---------------------------------------------------------------------------------------
	
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
	
	//seleccionar todos USUARIOS
	public List<Usuario> selectAllUsuarios(){
		Transaction transaction=null;
		List<Usuario> usuarios=null;
		try(Session session=VideoclubUtils.getSessionFactory().openSession()){
			transaction=session.beginTransaction();
			usuarios=session.createQuery("FROM Usuario", Usuario.class).getResultList();
			transaction.commit();
		}catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();			
			}
		}
		return usuarios;
	}
	
}//DAO
