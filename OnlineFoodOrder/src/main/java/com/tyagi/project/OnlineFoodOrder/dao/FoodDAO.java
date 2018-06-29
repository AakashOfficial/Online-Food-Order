package com.tyagi.project.OnlineFoodOrder.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyagi.project.OnlineFoodOrder.model.Food;

@Repository("foodDAO")
public class FoodDAO {
	@Autowired
	SessionFactory sessionFactory;

	public FoodDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void insertUpdateFood(Food food) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(food);
	}

	public Food getFood(int ProdId) {
		Session session = sessionFactory.openSession();
		Food food = (Food) session.get(Food.class, ProdId);
		session.close();
		return food;
	}

	@Transactional
	public void deleteFood(Food food) {
		sessionFactory.getCurrentSession().delete(food);
	}

	public List<Food> getFoodDetails() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Food");
		List<Food> list = query.list();
		session.close();
		return list;
	}

}