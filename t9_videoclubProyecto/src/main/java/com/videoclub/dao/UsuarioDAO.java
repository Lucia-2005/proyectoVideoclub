package com.videoclub.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.videoclub.model.Pelicula;
import com.videoclub.model.Usuario;
import com.videoclub.util.VideoclubUtils;

public class UsuarioDAO {

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

	//---------------------------------------------------------------------------------------
	
	//public List<>
	
}//DAO
