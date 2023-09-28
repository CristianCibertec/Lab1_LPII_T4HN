package controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import models.Empleado;


public class EmpleadoController {
	
    public String createEmpleado(String apellido, String nombre, int edad, String sexo, int salario )
    {
    	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
    	Session session = sessionFactory.openSession();
    	try {
    		Empleado empleado = new Empleado(apellido,nombre,edad,sexo,salario);
    		session.beginTransaction();
    		session.save(empleado);
    		session.getTransaction();
    		sessionFactory.close();
    		
    		return "Empleado creado";
    		
    	}catch(Exception ex){
    		
    		ex.printStackTrace();
    	}
      return "Error al registrar Empleado";
    }

    public String deleteEmpleado(int idempleado) {
    	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
        	session.beginTransaction();
        	Empleado empleado = session.get(Empleado.class, idempleado);
        	session.delete(empleado);
        	session.getTransaction().commit();
        	sessionFactory.close();
        	return "Empleado eliminado";
        }catch(Exception ex) {
        	ex.printStackTrace();
        }
    return "Error al eliminar empleado";
    }

    public String updateEmplado(int idempelado, String apellido) {
    	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        try {
        	session.beginTransaction();
        	
        	Empleado empleado = session.get(Empleado.class, idempelado);
        	session.update(empleado);
        	session.getTransaction().commit();
        	sessionFactory.close();
        	
        	return "Empleado actualizado";
        	
        }catch(Exception ex){
        	ex.printStackTrace();
        }
       return "Error al actualizar empleado";

    }

    public String getEmpleado(int idempleado) {
    	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        try {
        	session.beginTransaction();
        	Empleado empleado = session.get(Empleado.class, idempleado);
        	session.getTransaction().commit();
        	sessionFactory.close();
        	
        	return "Empleado encontrado";
        	
        }catch(Exception ex){
        	ex.printStackTrace();
        }
       return "Empleado no encontrado";

    }
    
    }


