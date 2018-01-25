/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.Data;
import com.entity.Program;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
public class DataService {
    
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorkshopBootcampPU");
        EntityManager em = emf.createEntityManager();
    
        int MAXPAGE = 5;
    int page = 1;
    
    public void addData(Data m){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(m);
        em.getTransaction().commit();
        em.close();
    }
    
    public void updateData(Data m){
          em = emf.createEntityManager();
          em.getTransaction().begin();
//          em.merge(m);
          Data ms = em.find(Data.class, m.getId());
          ms.setId(m.getId());
          ms.setName(m.getName());
          ms.setGender(m.getGender());
          ms.setPlaceOfBirth(m.getPlaceOfBirth());
          ms.setDateOfBirth(m.getDateOfBirth());
          ms.setMaritalstatus(m.getMaritalstatus());
          ms.setReligionCode(m.getReligionCode());
          ms.setCurrentAddress(m.getCurrentAddress());
          ms.setEducationCode(m.getEducationCode());
          ms.setGpa(m.getGpa());
          ms.setProgramCode(m.getProgramCode());
          ms.setExpectedSalary(m.getExpectedSalary());
          em.getTransaction().commit();
          em.close();
    }

    public List<Data> selectAll(){
     em = emf.createEntityManager();
     em.getTransaction().begin();
     List<Data> list = em.createQuery("select m from Data m").getResultList();
     
     em.getTransaction().commit();
     em.close();
     return list;
     }
    public List<Program> selectProgram(){
        em = emf.createEntityManager();
        List<Program> list2= em.createQuery("select p from Program p").getResultList();
        em.close();
        return list2;
    }
    public List<Data> selectPaging (int page, String search){
        int start = (MAXPAGE*page) - MAXPAGE;
        em = emf.createEntityManager();
        List<Data> list = new ArrayList<Data>();
        list = em.createQuery("select m from Data m where m.name like :cari")
                .setParameter("cari", "%"+search+"%").setFirstResult(start).setMaxResults(MAXPAGE).getResultList();
        em.close();
        return list;
    }
    public void deleteData(long id){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Data mhs = em.find(Data.class, id);
        em.remove(mhs);
        em.getTransaction().commit();
        em.close();
    }
    public Data getById(long id){
        em = emf.createEntityManager();
        Data m = em.find(Data.class, id);
          em.close();
          return m;
    }
    
    public int getCountPage(String search){
         int jml = 0;
         int hitung = 0;
         em = emf.createEntityManager();

         hitung = Integer.parseInt(em.createQuery("select COUNT(m.id) from Data m "
                 + "where m.name like :cari ").setParameter("cari", "%"+search+"%")
                 .getSingleResult().toString());
         jml = hitung / MAXPAGE;
         if (hitung % MAXPAGE > 0) {
             jml = jml + 1;
         }
         em.close();
         return jml;
    }
}
  
