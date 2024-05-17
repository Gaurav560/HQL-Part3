package com.telusko;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.transform.Transformers;

import java.util.List;


public class App {
    public static void main(String[] args) {

        // creating session object

        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);

        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sessionfactory = con.buildSessionFactory(reg);
        System.out.println(sessionfactory);
        Session session = sessionfactory.openSession();

        Transaction tx = session.beginTransaction();


        //-----------------------------------------------------------------------------------------------




          //sql query in hibernate to get a list of students above marks 50(Native Queries)
//        NativeQuery<Student> query = session.createNativeQuery("select * from Student where marks > 50", Student.class);
//        List<Student> students = query.getResultList();
//
//        for (Student s : students) {
//            System.out.println(s);
//        }



        //-----------------------------------------------------------------------------------------------




        //sql query to find certain columns in hibernate(Native Queries)
        NativeQuery<StudentDTO> query = session.createNativeQuery("select sname,marks from Student where marks > 65", StudentDTO.class);
        List<StudentDTO> students = query.getResultList();
        for (StudentDTO student : students) {
            System.out.println("Marks: " + student.getMarks());
            System.out.println("Name: " + student.getSname());
        }





        //-----------------------------------------------------------------------------------------------










        tx.commit();

        session.close();
    }
}
