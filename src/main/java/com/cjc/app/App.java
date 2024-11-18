package com.cjc.app;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.cjc.configue.HibernateUtil;
import com.cjc.model.Student;

public class App {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
	   SessionFactory sf= HibernateUtil.getSessionFactory();	
	   Session session = sf.openSession();
	   
	  // insertData(session);
	// getAllDataUsingSQL(session);
	 // getdataUsingName(sc,session)   ;
	
	  getDataUsingHQL(session);
	   
	   
	 //  Deletedata(sc,session);
	   
		session.beginTransaction().commit();
        session.close();
		System.out.println("Done....!");
	}
	
	
	private static void insertData(Session session) {
		Student stu1 = new Student(1, "ABC", "Pune", 52.25f);
		Student stu2 = new Student(2, "STU", "Mumbai", 72.25f);
		Student stu3 = new Student(3, "PQR", "Nashik", 95.25f);
		Student stu4 = new Student(4, "ABC", "Pune", 62.25f);
		Student stu5 = new Student(5, "XYZ", "Mumbai", 92.25f);

		session.save(stu1);
		session.save(stu2);
		session.save(stu3);
		session.save(stu4);
		session.save(stu5);

		session.beginTransaction().commit();

		System.out.println("Data Inserted ....!");
	}
//All Data Using SQL	
	private static void getAllDataUsingSQL(Session session)
	{
		String sql="select * from Student";
		
		Query query = session.createSQLQuery(sql).addEntity(Student.class);
		
		List<Student> list = query.getResultList();
		
		for(Student st:list)
		{
			
			System.out.println("----------------");
			System.out.println("Student RollNo : "+st.getRollNo());
			System.out.println("Student Name: "+st.getName());
			System.out.println("Student Adress :"+st.getAddress());
			System.out.println("Student Marks:"+st.getMarks());
		}
		
		
	}
	private static void getDataUsingHQL(Session session)
	{
		// Get Data using HQl
//		Sql= select * from Student
//	    HQL= from student
	    
	    String hql="from Student";
	    
	    Query query = session.createQuery(hql);
	    
	    List<Student> list = query.getResultList();
	    
	    for(Student st:list)
	    {
	
			System.out.println("----------------");
			System.out.println("Student RollNo : "+st.getRollNo());
			System.out.println("Student Name: "+st.getName());
			System.out.println("Student Adress :"+st.getAddress());
			System.out.println("Student Marks:"+st.getMarks());
	    	
	    }
	    
	}
	
//Get All Data using Scanner & (Hql)
	
	private static void getdataUsingName(Scanner sc,Session session)  
	{
		
		System.out.println("Eneter City name : ");
		String city=sc.next();
		
		String hql="from Student where Address=?";
		Query query = session.createQuery(hql);
		query.setParameter(0,city);
		
		List<Student> list = query.getResultList();
		
		
		for(Student st:list)
	    {
	
			System.out.println("----------------");
			System.out.println("Student RollNo : "+st.getRollNo());
			System.out.println("Student Name: "+st.getName());
			System.out.println("Student Adress :"+st.getAddress());
			System.out.println("Student Marks:"+st.getMarks());
	    	
	    }
		
		
	}
//Delete Data using HQL
	

	private static void Deletedata(Scanner sc, Session session) {
	System.out.println("Enter City Name :");
	String city = sc.next();
	
	String hql="delete from Student where Address= :adr";
	
	Query query = session.createQuery(hql);
	query.setParameter("adr",city);
	
	Transaction tx = session.beginTransaction();

	query.executeUpdate();

	tx.commit();

	System.out.println("Deleted Successfully..!");
		
		
	}
	
	
}



